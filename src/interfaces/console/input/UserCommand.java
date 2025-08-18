package interfaces.console.input;

import common.exception.ErrorCode;
import common.exception.MainMenuException;

public enum UserCommand {
    YES("Y"),
    NO("N");

    private final String command;

    UserCommand(String command) {
        this.command = command;
    }

    public static UserCommand of(String command) {
        for (UserCommand userCommand : UserCommand.values()) {
            if (userCommand.command.equals(command)) {
                return userCommand;
            }
        }
        throw new MainMenuException(ErrorCode.MAIN_MENU_INVALID_YES_OR_NO);
    }
}
