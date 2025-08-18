package interfaces.console.controller;

import interfaces.console.view.ItineraryView;
import itinerary.application.ItineraryService;
import itinerary.domain.Itinerary;
import java.util.List;

public class ItineraryConsoleController {
    private final ItineraryService itineraryService;
    private final ItineraryView itineraryView;

    public ItineraryConsoleController(ItineraryService itineraryService, ItineraryView itineraryView) {
        this.itineraryService = itineraryService;
        this.itineraryView = itineraryView;
    }

    public void recordItinerary() {
        int travelId;
        while (true) {
            travelId = itineraryView.promptTravelIdForItinerary();

            if (!itineraryService.travelExists(travelId)) { // 여행 자체가 없는 경우
                itineraryView.showNoTravelIdMessage(travelId);
                continue; // 다시 입력
            }
            break; // 유효한 여행 ID면 종료
        }

        do {
            Itinerary itinerary = itineraryView.readItineraryFromUser(travelId);
            Itinerary savedItinerary = itineraryService.save(itinerary);
            itineraryView.showItinerarySaved(savedItinerary);
        } while (itineraryView.askAddMoreItinerary());
    }

    public void listItineraries() {
        int travelId;
        while (true) {
            travelId = itineraryView.promptTravelIdForQuery();

            if (!itineraryService.travelExists(travelId)) { // 여행 자체가 없는 경우
                itineraryView.showNoTravelIdMessage(travelId);
                continue;
            }

            List<Itinerary> itineraries = itineraryService.getItinerariesByTravelId(travelId);

            if (itineraries.isEmpty()) { // 여행은 존재하지만 여정이 없는 경우
                itineraryView.showNoItinerariesMessage(travelId);
                break; // 조회 끝, 다시 메뉴로
            }

            itineraryView.showItineraryListHeader(travelId);
            itineraryView.showItineraries(itineraries);
            break;
        }
    }
}