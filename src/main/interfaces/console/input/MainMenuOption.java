package main.interfaces.console.input;

import main.common.exception.ErrorCode;
import main.common.exception.MainMenuException;

public enum MainMenuOption {
    ONE("1", "여행 기록"),
    TWO("2", "여정 기록"),
    THREE("3", "여행 조회"),
    FOUR("4", "여정 조회"),
    FIVE("5", "종료"),
    ;

    private final String menuNumber;
    private final String menuMessage;

    MainMenuOption(String menuNumber, String menuMessage) {
        this.menuNumber = menuNumber;
        this.menuMessage = menuMessage;
    }

    public static MainMenuOption of(String menuNumber) {
        for (MainMenuOption mainMenuOption : MainMenuOption.values()) {
            if (mainMenuOption.menuNumber.equals(menuNumber)) {
                return mainMenuOption;
            }
        }
        throw new MainMenuException(ErrorCode.MAIN_MENU_INVALID_RANGE);
    }
}
