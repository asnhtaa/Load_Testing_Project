package tests;

import io.gatling.javaapi.core.Simulation;

import static io.gatling.javaapi.core.CoreDsl.*;
import static protocols.Protocol.httpProtocol;
import static scenarios.TvMazeEpisodeScenarios.*;
import static scenarios.TvMazeShowScenarios.*;

public class TestSimulation extends Simulation {
    {
        setUp(
                searchShowAndLookup
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndCheckMainInformation
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndAlternateLists
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndRetrieveEpisodeByDate
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndShowSeasons
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndGetEpisodesInSeason
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndRetrieveCast
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndRetrieveCrew
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndRetrieveAliases
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndEpisodeCheck
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndRetrieveImagesFromShow
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndRetrieveEpisodeInformation
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndRetrieveEpisodeGuestCast
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol),

                searchShowAndRetrieveEpisodeGuestCrew
                        .injectOpen(incrementUsersPerSec(1)
                                .times(2)
                                .eachLevelLasting(1)
                                .separatedByRampsLasting(1)
                                .startingFrom(1))
                        .protocols(httpProtocol));
    }
}


