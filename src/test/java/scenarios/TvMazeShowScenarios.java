package scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;

import static chains.ShowInformation.*;
import static io.gatling.javaapi.core.CoreDsl.scenario;

import static chains.Search.*;

public class TvMazeShowScenarios {
    public static ScenarioBuilder searchShowAndLookup = scenario("Search show by characteristics, then lookup the first show using the thetvdb ID")
            .exec(showSearch, showLookup);

    public static ScenarioBuilder searchShowAndEpisodeCheck = scenario("Search show by characteristics, then retrieve episodes list for the first show found")
            .exec(showSearch, showEpisodeList);

    public static ScenarioBuilder searchShowAndCheckMainInformation = scenario("Search show by characteristics, then retrieve all primary information for a given show")
            .exec(showSearch, showMainInformation);

    public static ScenarioBuilder searchShowAndAlternateLists = scenario("Search show by characteristics, then alternate episode lists for this show")
            .exec(showSearch, showAlternateList);

    public static ScenarioBuilder searchShowAndRetrieveEpisode = scenario("Search show by characteristics, then retrieve episode from the first show")
            .exec(showSearch, episodeByNumber);

    public static ScenarioBuilder searchShowAndRetrieveEpisodeByDate = scenario("Search show by characteristics, then retrieve episode from the first show by date")
            .exec(showSearch, episodeByDate);

    public static ScenarioBuilder searchShowAndShowSeasons = scenario("Search show by characteristics, then retrieve list of seasons for the first show")
            .exec(showSearch, showSeasons);

    public static ScenarioBuilder searchShowAndGetEpisodesInSeason = scenario("Search show by characteristics, then retrieve list of episodes in season for the first show")
            .exec(showSearch, seasonEpisodes);

    public static ScenarioBuilder searchShowAndRetrieveCast = scenario("Search show by characteristics, then retrieve main cast for the first show")
            .exec(showSearch, showCast);

    public static ScenarioBuilder searchShowAndRetrieveCrew = scenario("Search show by characteristics, then retrieve crew for the first show")
            .exec(showSearch, showCrew);

    public static ScenarioBuilder searchShowAndRetrieveAliases = scenario("Search show by characteristics, then retrieve aliases for the first show")
            .exec(showSearch, showAliases);
}
