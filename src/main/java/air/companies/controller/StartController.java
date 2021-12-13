package air.companies.controller;

import air.companies.model.AirCompany;
import air.companies.model.Airplane;
import air.companies.model.Flight;
import air.companies.model.Status;
import air.companies.service.AirCompanyService;
import air.companies.service.AirplaneService;
import air.companies.service.FlightService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StartController {
    private final AirCompanyService airCompanyService;
    private final AirplaneService airplaneService;
    private final FlightService flightService;

    public StartController(AirCompanyService airCompanyService,
                           AirplaneService airplaneService, FlightService flightService) {
        this.airCompanyService = airCompanyService;
        this.airplaneService = airplaneService;
        this.flightService = flightService;
    }

    @GetMapping
    public String giveAnInstructions() {
        return "To inject default data enter the endpoint /inject";
    }

    @GetMapping("/inject")
    public String injectData() {
        AirCompany deltaAirLines = new AirCompany();
        deltaAirLines.setName("Delta-Air-Lines");
        deltaAirLines.setCompanyType("Military");
        deltaAirLines.setFoundedAt(LocalDate.of(1997, 8,21));

        AirCompany expressJetAirlines = new AirCompany();
        expressJetAirlines.setName("ExpressJet-airlines");
        expressJetAirlines.setCompanyType("Transport");
        expressJetAirlines.setFoundedAt(LocalDate.of(1994, 5,12));

        AirCompany frontierAirlines = new AirCompany();
        frontierAirlines.setName("Frontier-Airlines");
        frontierAirlines.setCompanyType("Transport");
        frontierAirlines.setFoundedAt(LocalDate.of(2001, 3, 11));

        airCompanyService.save(deltaAirLines);
        airCompanyService.save(expressJetAirlines);
        airCompanyService.save(frontierAirlines);

        Airplane hawkerHurricane = new Airplane();
        hawkerHurricane.setName("Hawker-Hurricane");
        hawkerHurricane.setAirCompanyId(2L);
        hawkerHurricane.setNumberOfFlights(10);
        hawkerHurricane.setFlightDistance(10_000);
        hawkerHurricane.setFuelCapacity(12_000);
        hawkerHurricane.setType("passenger");
        hawkerHurricane.setCreatedAt(LocalDate.of(2010, 11, 10));

        Airplane b52Stratofortress = new Airplane();
        b52Stratofortress.setName("B-Stratofortress");
        b52Stratofortress.setAirCompanyId(3L);
        b52Stratofortress.setNumberOfFlights(7);
        b52Stratofortress.setFlightDistance(15_000);
        b52Stratofortress.setFuelCapacity(17_000);
        b52Stratofortress.setType("passenger");
        b52Stratofortress.setCreatedAt(LocalDate.of(2009, 7, 13));

        Airplane dassaultBreguetMirage = new Airplane();
        dassaultBreguetMirage.setName("Dassault-Mirage");
        dassaultBreguetMirage.setAirCompanyId(1L);
        dassaultBreguetMirage.setNumberOfFlights(20);
        dassaultBreguetMirage.setFlightDistance(17_000);
        dassaultBreguetMirage.setFuelCapacity(14_000);
        dassaultBreguetMirage.setType("military");
        dassaultBreguetMirage.setCreatedAt(LocalDate.of(2012, 4, 18));

        airplaneService.save(hawkerHurricane);
        airplaneService.save(b52Stratofortress);
        airplaneService.save(dassaultBreguetMirage);

        Flight one = new Flight();
        one.setFlightStatus(Status.COMPLETED);
        one.setAirCompanyId(1L);
        one.setAirplaneId(1L);
        one.setDepartureCountry("USA");
        one.setDestinationCountry("UK");
        one.setDistance(6826.837);
        one.setEstimatedFlightTime(LocalTime.of(3,40));
        one.setEndedAt(LocalDateTime.of(2021, 11,30, 22,40));

        Flight two = new Flight();
        two.setFlightStatus(Status.ACTIVE);
        two.setAirCompanyId(2L);
        two.setAirplaneId(2L);
        two.setDepartureCountry("Russia");
        two.setDestinationCountry("Ukraine");
        two.setDistance(4523.25);
        two.setEstimatedFlightTime(LocalTime.of(2,20));
        two.setCreatedAt(LocalDateTime.of(2021, 12,15, 15,30));

        Flight three = new Flight();
        three.setFlightStatus(Status.PENDING);
        three.setAirCompanyId(3L);
        three.setAirplaneId(3L);
        three.setDepartureCountry("France");
        three.setDestinationCountry("Germany");
        three.setDistance(3646.15);
        three.setEstimatedFlightTime(LocalTime.of(1,50));
        three.setCreatedAt(LocalDateTime.of(2021, 12,25, 14,30));

        flightService.save(one);
        flightService.save(two);
        flightService.save(three);

        return "Data was added!";
    }
}
