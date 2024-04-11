package chains;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Search {

    public static ChainBuilder showSearch = exec(http("/search/shows")
            .get("/search/shows?q=girls")
            .check(jsonPath("$[0].show.id").saveAs("showId"))
            .check(jsonPath("$[0].show.externals.tvrage").saveAs("tvrage")));
    public static ChainBuilder showLookup = exec(http("/lookup/shows")
            .get("/lookup/shows?tvrage=${tvrage}")
            .check(status().is(301))
            .check(header("Location").isEL("https://api.tvmaze.com/shows/#{showId}")));
}
