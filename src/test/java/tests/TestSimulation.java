package tests;

import io.gatling.javaapi.core.Simulation;

import static io.gatling.javaapi.core.CoreDsl.*;
import static protocols.Protocol.httpProtocol;
import static scenarios.TvMazeEpisodeScenarios.*;
import static scenarios.TvMazePeopleScenarios.*;
import static scenarios.TvMazeShowScenarios.*;

public class TestSimulation extends Simulation {
    {
        double maxUsers = 400d;

        setUp(
                searchShowAndLookup
                        .injectOpen(incrementUsersPerSec(30)
                                .times(10)
                                .eachLevelLasting(10)
                                .separatedByRampsLasting(20)
                                .startingFrom(1))
                        .protocols(httpProtocol)
                        .andThen(
                                searchShowAndCheckMainInformation
                                        .injectOpen(incrementUsersPerSec(30)
                                                .times(10)
                                                .eachLevelLasting(10)
                                                .separatedByRampsLasting(20)
                                                .startingFrom(1))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndAlternateLists
                                        .injectOpen(incrementUsersPerSec(30)
                                                .times(10)
                                                .eachLevelLasting(10)
                                                .separatedByRampsLasting(20)
                                                .startingFrom(1))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveEpisodeByDate
                                        .injectOpen(incrementUsersPerSec(30)
                                                .times(10)
                                                .eachLevelLasting(10)
                                                .separatedByRampsLasting(20)
                                                .startingFrom(1))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndShowSeasons
                                        .injectOpen(incrementUsersPerSec(30)
                                                .times(10)
                                                .eachLevelLasting(10)
                                                .separatedByRampsLasting(20)
                                                .startingFrom(1))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndGetEpisodesInSeason
                                        .injectOpen(incrementUsersPerSec(30)
                                                .times(10)
                                                .eachLevelLasting(10)
                                                .separatedByRampsLasting(20)
                                                .startingFrom(1))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveCast
                                        .injectOpen(incrementUsersPerSec(30)
                                                .times(10)
                                                .eachLevelLasting(10)
                                                .separatedByRampsLasting(20)
                                                .startingFrom(1))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveCrew
                                        .injectOpen(incrementUsersPerSec(30)
                                                .times(10)
                                                .eachLevelLasting(10)
                                                .separatedByRampsLasting(20)
                                                .startingFrom(1))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveAliases
                                        .injectOpen(incrementUsersPerSec(30)
                                                .times(10)
                                                .eachLevelLasting(10)
                                                .separatedByRampsLasting(20)
                                                .startingFrom(1))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndEpisodeCheck
                                        .injectOpen(incrementUsersPerSec(30)
                                                .times(10)
                                                .eachLevelLasting(10)
                                                .separatedByRampsLasting(20)
                                                .startingFrom(1))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveImagesFromShow
                                        .injectOpen(incrementUsersPerSec(30)
                                                .times(10)
                                                .eachLevelLasting(10)
                                                .separatedByRampsLasting(20)
                                                .startingFrom(1))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveEpisodeInformation
                                        .injectOpen(
                                                rampUsersPerSec(1).to(maxUsers).during(10),
                                                constantUsersPerSec(maxUsers).during(30))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveEpisodeGuestCast
                                        .injectOpen(
                                                rampUsersPerSec(1).to(maxUsers).during(10),
                                                constantUsersPerSec(maxUsers).during(30))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveEpisodeGuestCrew
                                        .injectOpen(
                                                rampUsersPerSec(1).to(maxUsers).during(10),
                                                constantUsersPerSec(maxUsers).during(30))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveEpisode
                                        .injectOpen(incrementUsersPerSec(30)
                                                .times(10)
                                                .eachLevelLasting(10)
                                                .separatedByRampsLasting(20)
                                                .startingFrom(1))
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveMainInformation
                                        .injectOpen(
                                                constantUsersPerSec(1).during(10),
                                                rampUsersPerSec(1).to(maxUsers).during(15),
                                                rampUsersPerSec(maxUsers).to(10).during(15),
                                                rampUsersPerSec(10).to(maxUsers).during(15),
                                                rampUsersPerSec(maxUsers).to(1).during(15)
                                        )
                                        .protocols(httpProtocol)
                        ).andThen(

                                searchShowAndRetrieveCastCredits
                                        .injectOpen(
                                                constantUsersPerSec(1).during(10),
                                                rampUsersPerSec(1).to(maxUsers).during(15),
                                                rampUsersPerSec(maxUsers).to(10).during(15),
                                                rampUsersPerSec(10).to(maxUsers).during(15),
                                                rampUsersPerSec(maxUsers).to(1).during(15)
                                        )
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveCrewCredits
                                        .injectOpen(
                                                constantUsersPerSec(1).during(10),
                                                rampUsersPerSec(1).to(maxUsers).during(15),
                                                rampUsersPerSec(maxUsers).to(10).during(15),
                                                rampUsersPerSec(10).to(maxUsers).during(15),
                                                rampUsersPerSec(maxUsers).to(1).during(15)
                                        )
                                        .protocols(httpProtocol)
                        ).andThen(
                                searchShowAndRetrieveGuestCastCredits
                                        .injectOpen(
                                                constantUsersPerSec(1).during(10),
                                                rampUsersPerSec(1).to(maxUsers).during(15),
                                                rampUsersPerSec(maxUsers).to(10).during(15),
                                                rampUsersPerSec(10).to(maxUsers).during(15),
                                                rampUsersPerSec(maxUsers).to(1).during(15)
                                        )
                                        .protocols(httpProtocol)))
                .assertions(forAll().successfulRequests().percent().lte(90.0), forAll().responseTime().max().lt(500));
    }
}


