package main;

import main.common.config.AppConfig;
import main.interfaces.console.controller.MainConsoleController;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MainConsoleController mainConsoleController = appConfig.mainConsoleController();
        System.out.println("[server] server is running");
        mainConsoleController.run();
    }
}