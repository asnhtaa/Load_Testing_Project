package scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.scenario;

import static chains.Search.*;

public class TvMazeShowScenarios {
    public static ScenarioBuilder searchShowAndLookup = scenario("Search for a show based on characteristics and then lookup using the thetvdb ID")
            .exec(showSearch, showLookup);
}
