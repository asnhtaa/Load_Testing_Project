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
            .get("/shows/${showId}/alternatelists")
            .check(status().is(200))
            .check((bodyBytes().exists())));

    public static ChainBuilder episodeByNumber = exec(http("/shows/{showId}/episodebynumber?season=:season&number=:number")
            .get("/shows/${showId}/episodebynumber?season=1&number=1")
            .check(status().is(200))
            .check(jsonPath("$.id").exists())
            .check(jsonPath("$.name").exists())
            .check(jsonPath("$.season").is("1"))
            .check(jsonPath("$.number").is("1")));

    public static ChainBuilder episodeByDate = exec(http("/shows/:id/episodesbydate?date=:date")
            .get("/shows/${showId}/episodesbydate?date=2013-10-22")
            .check(status().is(200))
            .check(jsonPath("$[0].id").exists())
            .check(jsonPath("$[0].name").exists())
            .check(jsonPath("$[0].season").exists())
            .check(jsonPath("$[0].number").exists())
            .check(jsonPath("$[0].airdate").is("2013-10-22"))
            .check(jsonPath("$[0].id").saveAs("episodeId")));

    public static ChainBuilder seasonEpisodes = exec(http("/seasons/{showId}/episodes")
            .get("/seasons/${showId}/episodes")
            .check(status().is(200))
            .check(jsonPath("$[*].id").notNull())
            .check(jsonPath("$[*].name").notNull())
            .check(jsonPath("$[*].season").notNull())
            .check(jsonPath("$[*].number").notNull())
            .check(jsonPath("$[5].id").saveAs("episodeId"))
            .check(jsonPath("$[5].name").saveAs("episodeName")));

    public static ChainBuilder showSeasons = exec(http("/shows/{showId}/seasons")
            .get("/shows/${showId}/seasons")
            .check(status().is(200))
            .check(jsonPath("$[*].id").notNull())
            .check(jsonPath("$[*].premiereDate").notNull())
            .check(jsonPath("$[*].endDate").notNull())
            .check(jsonPath("$[*].number").notNull()));

    public static ChainBuilder showCast = exec(http("/shows/{showId}/cast")
            .get("/shows/${showId}/cast")
            .check(status().is(200))
            .check(jsonPath("$[*].person.name").notNull())
            .check(jsonPath("$[*].character.name").notNull()));

    public static ChainBuilder showCrew = exec(http("/shows/{showId}/crew")
            .get("/shows/${showId}/crew")
            .check(status().is(200))
            .check(jsonPath("$[*].person.name").notNull())
            .check(jsonPath("$[*].type").notNull()));

    public static ChainBuilder showAliases = exec(http("/shows/{showId}/akas")
            .get("/shows/${showId}/akas")
            .check(status().is(200))
            .check(jsonPath("$[*].name").notNull())
            .check(jsonPath("$[*].country.name").notNull()));

    public static ChainBuilder showImages = exec(http("/shows/{showId}/images")
            .get("/shows/${showId}/images")
            .check(status().is(200))
            .check(jsonPath("$[*].resolutions.original.url").notNull())
            .check(jsonPath("$[*].resolutions.original.width").notNull())
            .check(jsonPath("$[*].resolutions.original.height").notNull()));
}
