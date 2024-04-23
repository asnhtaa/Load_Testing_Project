package chains;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Search {

    public static ChainBuilder showSearch = exec(http("/search/shows")
            .get("/search/shows?q=fire")
            .check(status().is(200))
            .check(jsonPath("$[1].show.id").saveAs("showId"))
            .check(jsonPath("$[1].show.externals.thetvdb").saveAs("thetvdb")));

    public static ChainBuilder showLookup = exec(http("/lookup/shows")
            .get("/lookup/shows?thetvdb=${thetvdb}")
            .check(status().is(301))
            .check(header("Location").isEL("https://api.tvmaze.com/shows/#{showId}")));
    public static ChainBuilder peopleSearch = exec(http("/search/people")
            .get("/search/people?q=natalia")
            .check(status().is(200))
            .check(jsonPath("$[1].person.id").saveAs("personId"))
            .check(jsonPath("$[0].person.id").saveAs("firstPersonId")));

}
