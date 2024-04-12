package chains;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Search {

    public static ChainBuilder showSearch = exec(http("/search/shows")
            .get("/search/shows?q=fire")
            .check(jsonPath("$[1].show.id").saveAs("showId"))
            .check(jsonPath("$[1].show.externals.thetvdb").saveAs("thetvdb")));

    public static ChainBuilder showLookup = exec(http("/lookup/shows")
            .get("/lookup/shows?thetvdb=${thetvdb}")
            .check(status().is(301))
            .check(header("Location").isEL("https://api.tvmaze.com/shows/#{showId}")));
}
