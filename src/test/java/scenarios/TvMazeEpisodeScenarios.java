package scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;

import static chains.EpisodeInformation.*;
import static chains.Search.*;
import static chains.ShowInformation.*;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class TvMazeEpisodeScenarios {

    public static ScenarioBuilder searchShowAndRetrieveEpisodeInformation = scenario("Search show by characteristics, then check the episode and retrieve episode main information")
            .exec(showSearch, seasonEpisodes, episodeMainInformation);

    public static ScenarioBuilder searchShowAndRetrieveEpisodeGuestCast = scenario("Search show by characteristics, then check the episode and retrieve episode guest cast")
            .exec(showSearch, seasonEpisodes, episodeGuestCast);

    public static ScenarioBuilder searchShowAndRetrieveEpisodeGuestCrew = scenario("Search show by characteristics, then check the episode by date and retrieve episode guest crew")
            .exec(showSearch, episodeByDate, episodeGuestCrew);
}
