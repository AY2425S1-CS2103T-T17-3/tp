package seedu.address.testutil;

import seedu.address.model.product.Product;
import seedu.address.model.product.ProductName;

/**
 * A utility class to help with building Product objects.
 */
public class ProductBuilder {

    public static final String DEFAULT_NAME = "Apple";

    private ProductName name;

    public ProductBuilder() {
        name = new ProductName(DEFAULT_NAME);
    }

    /**
     * Initializes the ProductBuilder with the data of {@code productToCopy}.
     */
    public ProductBuilder(Product productToCopy) {
        name = productToCopy.getName();
    }

    /**
     * Sets the {@code ProductName} of the {@code Product} that we are building.
     */
    public ProductBuilder withName(String name) {
        this.name = new ProductName(name);
        return this;
    }

    public Product build() {
        return new Product(name);
    }
}
