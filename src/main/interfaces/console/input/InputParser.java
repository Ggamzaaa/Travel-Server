package main.interfaces.console.input;

import main.common.exception.ErrorCode;
import main.common.exception.ItineraryException;
import main.common.exception.TravelException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputParser {
    public void validateTravelName(String travelName) {
        if (travelName.isEmpty()) {
            throw new TravelException(ErrorCode.TRAVEL_NAME_IS_EMPTY);
        }
    }

    public LocalDate validateStartDate(String inputStartDate) {
        if (inputStartDate.isEmpty()) {
            throw new TravelException(ErrorCode.TRAVEL_START_DATE_IS_EMPTY);
        }
        try {
            return LocalDate.parse(inputStartDate);
        } catch (DateTimeParseException e) {
            throw new TravelException(ErrorCode.TRAVEL_DATE_FORMAT_EXCEPTION);
        }
    }

    public LocalDate validateEndDate(String inputEndDate, LocalDate startDate) {
        if (inputEndDate.isEmpty()) {
            throw new TravelException(ErrorCode.TRAVEL_END_DATE_IS_EMPTY);
        }
        LocalDate endDate = stringToLocalDate(inputEndDate);

        if (endDate.isBefore(startDate)) {
            throw new TravelException(ErrorCode.TRAVEL_START_DATE_AFTER_END_DATE);
        }
        return endDate;
    }

    public LocalDate stringToLocalDate(String localDate) {
        try {
            return LocalDate.parse(localDate);
        } catch (DateTimeParseException e) {
            throw new TravelException(ErrorCode.TRAVEL_DATE_FORMAT_EXCEPTION);
        }
    }

    public void validateDeparturePlace(String departurePlace) {
        if (departurePlace.isEmpty()) {
            throw new ItineraryException(ErrorCode.TRAVEL_DEPARTURE_PLACE_IS_EMPTY);
        }
    }

    public void validateDestination(String destination) {
        if (destination.isEmpty()) {
            throw new ItineraryException(ErrorCode.TRAVEL_DESTINATION_IS_EMPTY);
        }
    }

    public void validateDepartureTime(String departureTime) {
        if (departureTime.isEmpty()) {
            throw new ItineraryException(ErrorCode.TRAVEL_DEPARTURE_TIME_IS_EMPTY);
        }
    }

    public void validateArrivalTime(String arrivalTime) {
        if (arrivalTime.isEmpty()) {
            throw new ItineraryException(ErrorCode.TRAVEL_ARRIVAL_TIME_IS_EMPTY);
        }
    }

    public LocalDateTime parseLocalDateTime(String dateTimeString) {
        try {
            return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (DateTimeParseException e) {
            throw new TravelException(ErrorCode.TRAVEL_DATE_FORMAT_EXCEPTION);
        }
    }

    public LocalDateTime validateArrivalTime(String inputArrivalTime, LocalDateTime departureTime) {
        LocalDateTime arrivalTime = parseLocalDateTime(inputArrivalTime);

        if (arrivalTime.isBefore(departureTime)) {
            throw new ItineraryException(ErrorCode.TRAVEL_DEPARTURE_TIME_AFTER_ARRIVAL_TIME);
        }
        return arrivalTime;
    }

    public LocalDateTime validateCheckOut(String inputCheckOut, LocalDateTime checkIn) {
        LocalDateTime checkOut = parseLocalDateTime(inputCheckOut);

        if (checkOut.isBefore(checkIn)) {
            throw new ItineraryException(ErrorCode.TRAVEL_CHECK_IN_AFTER_CHECK_OUT);
        }
        return checkOut;
    }
}