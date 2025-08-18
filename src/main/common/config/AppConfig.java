package main.common.config;

import main.common.exception.GlobalExceptionHandler;
import main.interfaces.console.controller.MainConsoleController;
import main.interfaces.console.controller.ItineraryConsoleController;
import main.interfaces.console.controller.TravelConsoleController;
import main.interfaces.console.input.InputHandler;
import main.interfaces.console.input.InputParser;
import main.interfaces.console.util.RetryHandler;
import main.interfaces.console.view.TravelView;
import main.interfaces.console.view.ItineraryView;
import main.interfaces.console.view.MainView;
import main.interfaces.console.view.ExitView;
import main.common.domain.AtomicIdGenerator;
import main.common.domain.IdGenerator;
import main.itinerary.domain.ItineraryRepository;
import main.itinerary.infra.JsonItineraryRepository;
import main.itinerary.application.ItineraryService;
import main.itinerary.application.ItineraryServiceImpl;
import main.itinerary.application.ItineraryFactory;
import main.travel.application.TravelFactory;
import main.travel.application.TravelService;
import main.travel.application.TravelServiceImpl;
import main.travel.domain.Travel;
import main.travel.domain.TravelRepository;
import main.travel.infra.JsonTravelRepository;

public class AppConfig {
    private final TravelRepository travelRepository;
    private final IdGenerator idGenerator;
    private final TravelFactory travelFactory;
    private final TravelService travelService;
    private final ItineraryRepository itineraryRepository;
    private final ItineraryService itineraryService;
    private final ItineraryFactory itineraryFactory;
    private final InputParser inputParser;
    private final InputHandler inputHandler;
    private final TravelView travelView;
    private final ItineraryView itineraryView;
    private final TravelConsoleController travelConsoleController;
    private final ItineraryConsoleController itineraryConsoleController;
    private final MainConsoleController mainConsoleController;
    private final GlobalExceptionHandler globalExceptionHandler;
    private final RetryHandler retryHandler;

    public AppConfig() {
        this.travelRepository = new JsonTravelRepository("data");
        this.itineraryRepository = new JsonItineraryRepository("data");

        int seed = travelRepository.findAll().stream()
                .mapToInt(Travel::getId)
                .max()
                .orElse(0);
        this.idGenerator = new AtomicIdGenerator(seed);

        this.travelFactory = new TravelFactory(idGenerator);
        this.itineraryFactory = new ItineraryFactory(itineraryRepository);
        this.travelService = new TravelServiceImpl(travelRepository);
        this.itineraryService = new ItineraryServiceImpl(itineraryRepository, travelService);

        this.inputParser = new InputParser();
        this.inputHandler = new InputHandler(inputParser);
        this.globalExceptionHandler = new GlobalExceptionHandler();
        this.retryHandler = new RetryHandler(globalExceptionHandler);

        this.travelView = new TravelView(inputHandler, travelFactory, retryHandler);
        this.itineraryView = new ItineraryView(inputHandler, inputParser, retryHandler, itineraryFactory);

        this.travelConsoleController = new TravelConsoleController(travelService, travelView);
        this.itineraryConsoleController = new ItineraryConsoleController(itineraryService, itineraryView);

        this.mainConsoleController = new MainConsoleController(
                new MainView(inputHandler, retryHandler),
                new ExitView(),
                travelConsoleController,
                itineraryConsoleController
        );
    }

    public MainConsoleController mainConsoleController() {
        return mainConsoleController;
    }

    public ItineraryService itineraryService() {
        return itineraryService;
    }
}