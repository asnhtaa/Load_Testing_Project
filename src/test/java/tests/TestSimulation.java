package tests;

import io.gatling.javaapi.core.Simulation;

import static io.gatling.javaapi.core.CoreDsl.*;
import static protocols.Protocol.httpProtocol;
import static scenarios.TvMazeShowScenarios.searchShowAndLookup;

public class TestSimulation extends Simulation {
    {
        setUp(
                searchShowAndLookup
                        .injectOpen(incrementUsersPerSec(1)
                                .times(99)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol));
    }
}


