package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.supplier.Address;
import seedu.address.model.supplier.Email;
import seedu.address.model.supplier.Name;
import seedu.address.model.supplier.Phone;
import seedu.address.model.supplier.Remark;
import seedu.address.model.supplier.Supplier;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Supplier objects.
 */
public class SupplierBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_REMARK = "";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Remark remark;
    private Set<Tag> tags;

    /**
     * Creates a {@code SupplierBuilder} with the default details.
     */
    public SupplierBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        remark = new Remark(DEFAULT_REMARK);
        tags = new HashSet<>();
    }

    /**
     * Initializes the SupplierBuilder with the data of {@code supplierToCopy}.
     */
    public SupplierBuilder(Supplier supplierToCopy) {
        name = supplierToCopy.getName();
        phone = supplierToCopy.getPhone();
        email = supplierToCopy.getEmail();
        address = supplierToCopy.getAddress();
        remark = supplierToCopy.getRemark();
        tags = new HashSet<>(supplierToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Supplier} that we are building.
     */
    public SupplierBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Supplier} that we are building.
     */
    public SupplierBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Supplier} that we are building.
     */
    public SupplierBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Supplier} that we are building.
     */
    public SupplierBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Supplier} that we are building.
     */
    public SupplierBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Remark} of the {@code Person} that we are building.
     */
    public SupplierBuilder withRemark(String remark) {
        this.remark = new Remark(remark);
        return this;
    }

    public Supplier build() {
        return new Supplier(name, phone, email, address, remark, tags);
    }

}
