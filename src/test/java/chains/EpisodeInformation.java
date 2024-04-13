package chains;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class EpisodeInformation {

    public static ChainBuilder episodeMainInformation = exec(http("/episodes/{episodeId}")
            .get("/episodes/${episodeId}")
            .check(status().is(200))
            .check(jsonPath("$.id").isEL("#{episodeId}"))
            .check(jsonPath("$.name").isEL("#{episodeName}")));

    public static ChainBuilder episodeGuestCast = exec(http("/episodes/{episodeId}/guestcast")
            .get("/episodes/${episodeId}/guestcast")
            .check(status().is(200))
            .check(jsonPath("$[*].person.name").notNull()));

    public static ChainBuilder episodeGuestCrew = exec(http("/episodes/{episodeId}/guestcrew")
            .get("/episodes/${episodeId}/guestcrew")
            .check(status().is(200))
            .check(jsonPath("$[*].person.name").notNull()));
}
