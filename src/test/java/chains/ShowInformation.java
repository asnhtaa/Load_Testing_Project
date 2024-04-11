package chains;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class ShowInformation {
    public static ChainBuilder showEpisodeList = exec(http("/shows/{showId}/episodes")
            .get("/shows/${showId}/episodes")
            .check(status().is(200))
            .check(jsonPath("$[0].id").exists())
            .check(jsonPath("$[0].name").exists())
            .check(jsonPath("$[0].season").exists())
            .check(jsonPath("$[0].number").exists())
            .check(jsonPath("$[0].url").exists()));

    public static ChainBuilder showMainInformation = exec(http("/shows/{showId}")
            .get("/shows/${showId}")
            .check(status().is(200))
            .check(jsonPath("$.id").isEL("#{showId}"))
            .check(jsonPath("$.url").exists())
            .check(jsonPath("$.name").exists())
            .check(jsonPath("$.language").exists())
            .check(jsonPath("$.status").exists()));

    public static ChainBuilder showAlternateList = exec(http("/shows/{showId}/alternatelists")
            .get("/shows/${showId}/alternatelists"));

    public static ChainBuilder episodeByNumber = exec(http("/shows/{showId}/episodebynumber?season=:season&number=:number")
            .get("/shows/${showId}/episodebynumber?season=1&number=1"));

    public static ChainBuilder episodeByDate = exec(http("/shows/:id/episodesbydate?date=:date")
            .get("/shows/${showId}/episodesbydate?date=2013-02-24"));

    public static ChainBuilder showSeasons = exec(http("/seasons/{showId}/episodes")
            .get("/seasons/${showId}/episodes"));

    public static ChainBuilder seasonEpisodes = exec(http("/seasons/{showId}/episodes")
            .get("/seasons/${showId}/episodes"));

    public static ChainBuilder showCast = exec(http("/shows/{showId}/cast")
            .get("/shows/${showId}/cast"));

    public static ChainBuilder showCrew = exec(http("/shows/{showId}/crew")
            .get("/shows/${showId}/crew"));

    public static ChainBuilder showAliases = exec(http("/shows/{showId}/akas")
            .get("/shows/${showId}/akas"));
}
