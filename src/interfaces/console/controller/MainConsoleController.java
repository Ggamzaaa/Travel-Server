package interfaces.console.controller;

import interfaces.console.view.ExitView;
import interfaces.console.view.MainView;
import interfaces.console.input.MainMenuOption;
import interfaces.console.input.UserCommand;

public class MainConsoleController {
    private final MainView mainView;
    private final ExitView exitView;
    private final TravelConsoleController travelController;
    private final ItineraryConsoleController itineraryController;

    public MainConsoleController(MainView mainView,
                                 ExitView exitView,
                                 TravelConsoleController travelController,
                                 ItineraryConsoleController itineraryController) {
        this.mainView = mainView;
        this.exitView = exitView;
        this.travelController = travelController;
        this.itineraryController = itineraryController;
    }
    public void run() {
        mainView.printBanner();

        boolean keepRunning = true;
        while (keepRunning) {
            MainMenuOption mainMenuOption = mainView.askMenuSelection();

            if (mainMenuOption == MainMenuOption.ONE) travelController.recordTravel();
            if (mainMenuOption == MainMenuOption.TWO) itineraryController.recordItinerary();
            if (mainMenuOption == MainMenuOption.THREE) travelController.listTravels();
            if (mainMenuOption == MainMenuOption.FOUR) itineraryController.listItineraries();
            if (mainMenuOption == MainMenuOption.FIVE) {
                exitView.printExit();
                break;
            }

            UserCommand isUserRetry = mainView.askContinue();
            if (isUserRetry != UserCommand.YES) {
                keepRunning = false;
                exitView.printExit();
            }
        }
    }
}
