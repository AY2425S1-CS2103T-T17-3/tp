package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;

import org.junit.jupiter.api.Test;

public class RemarkCommandTest {
    @Test
    public void execute() {
        assertCommandFailure(new RemarkCommand(), model, MESSAGE_NOT_IMPLEMENTED_YET);
    }

}
