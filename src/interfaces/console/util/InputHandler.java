package interfaces.console.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import interfaces.console.view.MainMenuOption;
import interfaces.console.view.UserCommand;

public class InputHandler {
    private final InputParser inputParser;

    public InputHandler(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public String getTravelName() {
        Scanner sc = new Scanner(System.in);
        String travelNameValue = sc.nextLine();
        inputParser.validateTravelName(travelNameValue);
        return travelNameValue;
    }

    public LocalDate getStartDate() {
        Scanner sc = new Scanner(System.in);
        String travelStartDate = sc.nextLine();
        return inputParser.validateStartDate(travelStartDate);
    }

    public LocalDate getEndDate(LocalDate startDate) {
        Scanner sc = new Scanner(System.in);
        String travelEndDate = sc.nextLine();
        return inputParser.validateEndDate(travelEndDate, startDate);
    }

    public Integer getTravelId() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }

    public String getDeparturePlace() {
        Scanner sc = new Scanner(System.in);
        String departurePlaceValue = sc.nextLine();
        inputParser.validateDeparturePlace(departurePlaceValue);
        return departurePlaceValue;
    }

    public String getDeparturePlaceString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String getDestination() {
        Scanner sc = new Scanner(System.in);
        String destinationValue = sc.nextLine();
        inputParser.validateDestination(destinationValue);
        return destinationValue;
    }

    public String getDestinationString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public LocalDateTime getDepartureTime() {
        Scanner sc = new Scanner(System.in);
        String departureTimeValue = sc.nextLine().trim();
        if (departureTimeValue.isEmpty()) {
            return null;
        }
        return inputParser.parseLocalDateTime(departureTimeValue);
    }

    public String getDepartureTimeString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public LocalDateTime getArrivalTime(LocalDateTime departureTime) {
        Scanner sc = new Scanner(System.in);
        String arrivalTimeValue = sc.nextLine().trim();
        if (arrivalTimeValue.isEmpty()) {
            return null;
        }
        return inputParser.validateArrivalTime(arrivalTimeValue, departureTime);
    }

    public String getArrivalTimeString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public LocalDateTime getCheckIn() {
        Scanner sc = new Scanner(System.in);
        String checkInValue = sc.nextLine().trim();
        if (checkInValue.isEmpty()) {
            return null;
        }
        return inputParser.parseLocalDateTime(checkInValue);
    }

    public LocalDateTime getCheckOut(LocalDateTime checkIn) {
        Scanner sc = new Scanner(System.in);
        String checkOutValue = sc.nextLine().trim();
        if (checkOutValue.isEmpty()) {
            return null;
        }
        return inputParser.validateCheckOut(checkOutValue, checkIn);
    }

    public MainMenuOption readMenuSelection() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return MainMenuOption.of(input);
    }

    public UserCommand askContinue() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim().toUpperCase();
        return UserCommand.of(input);
    }
}