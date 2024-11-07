package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_SYNTAX;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_SUPPLIERS;

import java.util.Arrays;

import seedu.address.logic.commands.ViewSupplierCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.supplier.NameContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new ViewSupplierCommand object
 */
public class ViewSupplierCommandParser implements Parser<ViewSupplierCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewSupplierCommand
     * and returns a ViewSupplierCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewSupplierCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            return new ViewSupplierCommand(PREDICATE_SHOW_ALL_SUPPLIERS);
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new ViewSupplierCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
