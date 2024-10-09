package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.product.Product;

import static java.util.Objects.requireNonNull;

public class AddProductCommand extends Command {

    public static final String COMMAND_WORD = "ADD_PRODUCT";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a product to InvenTrack. ";

    public static final String MESSAGE_SUCCESS = "New product added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This product already exists.";

    private final Product toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddProductCommand(Product product) {
        requireNonNull(product);
        toAdd = product;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasProduct(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addProduct(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddProductCommand)) {
            return false;
        }

        AddProductCommand otherAddCommand = (AddProductCommand) other;
        return toAdd.equals(otherAddCommand.toAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", toAdd)
                .toString();
    }
}