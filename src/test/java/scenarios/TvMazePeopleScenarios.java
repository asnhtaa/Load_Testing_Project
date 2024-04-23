package scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;

import static chains.People.*;
import static chains.Search.*;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class TvMazePeopleScenarios {

    public static ScenarioBuilder searchShowAndRetrieveMainInformation = scenario("Search people by his name, then retrieve all primary information for the second person in results list")
            .exec(peopleSearch, personMainInformation);

    public static ScenarioBuilder searchShowAndRetrieveCastCredits = scenario("Search people by his name, then retrieve cast credits for the second person in results list")
            .exec(peopleSearch, personCastCredits);

    public static ScenarioBuilder searchShowAndRetrieveCrewCredits = scenario("Search people by his name, then retrieve crew credits for the second person in results list")
            .exec(peopleSearch, personCrewCredits);

    public static ScenarioBuilder searchShowAndRetrieveGuestCastCredits = scenario("Search people by his name, then retrieve guest cast credits for the first person in results list")
            .exec(peopleSearch, personGuestCastCredits);
}
