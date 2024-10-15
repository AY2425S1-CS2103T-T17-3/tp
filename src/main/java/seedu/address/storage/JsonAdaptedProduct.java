package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.product.Product;
import seedu.address.model.product.ProductName;

/**
 * Jackson-friendly version of {@link Product}.
 */
class JsonAdaptedProduct {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Product's %s field is missing!";

    private final String name;
    private final String supplierName; // This is empty if the product has no supplier
    private final int stockLevel;
    private final int minStockLevel;
    private final int maxStockLevel;

    /**
     * Constructs a {@code JsonAdaptedProduct} with the given product details.
     */
    @JsonCreator
    public JsonAdaptedProduct(@JsonProperty("name") String name, @JsonProperty("supplierName") String supplierName,
                              @JsonProperty("stockLevel") int stockLevel,
                              @JsonProperty("minStockLevel") int minStockLevel,
                              @JsonProperty("maxStockLevel") int maxStockLevel) {
        this.name = name;
        this.supplierName = supplierName;
        this.stockLevel = stockLevel;
        this.minStockLevel = minStockLevel;
        this.maxStockLevel = maxStockLevel;
    }

    /**
     * Converts a given {@code Product} into this class for Jackson use.
     */
    public JsonAdaptedProduct(Product source) {
        name = source.getName().fullName;
        supplierName = source.getSupplierName() != null ? source.getSupplierName().fullName : "";
        stockLevel = source.getStockLevel();
        minStockLevel = source.getMinStockLevel();
        maxStockLevel = source.getMaxStockLevel();
    }

    /**
     * Converts this Jackson-friendly adapted product object into the model's {@code Product} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted product.
     */
    public Product toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, ProductName
                .class.getSimpleName()));
        }
        if (!ProductName.isValidName(name)) {
            throw new IllegalValueException(ProductName.MESSAGE_CONSTRAINTS);
        }
        final ProductName modelName = new ProductName(name);

        Product product = new Product(modelName);
        product.setStockLevel(stockLevel);
        product.setMinStockLevel(minStockLevel);
        product.setMaxStockLevel(maxStockLevel);

        if (!supplierName.isEmpty()) {
            product.setSupplierName(new seedu.address.model.supplier.Name(supplierName));
        }

        return product;
    }
}
