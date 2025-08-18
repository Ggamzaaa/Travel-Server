package interfaces.console.view;

import interfaces.console.util.InputHandler;
import interfaces.console.util.RetryHandler;

public class MainView {
    private final InputHandler inputHandler;
    private final RetryHandler retryHandler;

    public MainView(InputHandler inputHandler, RetryHandler retryHandler) {
        this.inputHandler = inputHandler;
        this.retryHandler = retryHandler;
    }

    public void printBanner() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("          깜자팀 여행 일정 작성 서비스         ");
        System.out.println("========================================");
    }

    private MainMenuOption printMenu() {
        System.out.println("메뉴 리스트");
        System.out.println(" - 여행 기록 (1)");
        System.out.println(" - 여정 기록 (2)");
        System.out.println(" - 여행 조회 (3)");
        System.out.println(" - 여정 조회 (4)");
        System.out.println(" - 종료     (5)");
        System.out.println();
        System.out.println("원하는 메뉴 번호를 선택하세요 * : ");
        return inputHandler.readMenuSelection();
    }

    public MainMenuOption askMenuSelection() {
        return retryHandler.handle(this::printMenu);
    }

    public UserCommand askContinue() {
        return retryHandler.handle(this::printContinue);
    }

    private UserCommand printContinue() {
        System.out.println("계속 하시겠습니까? (Y/N): ");
        return inputHandler.askContinue();
    }

//    public void printInvalidSelection() {
//        System.out.println("메뉴 번호를 다시 한 번 확인해주세요.");
//    }
}