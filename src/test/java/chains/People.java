package chains;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class People {

    public static ChainBuilder personMainInformation = exec(http("/people/{personId}")
            .get("/people/${personId}")
            .check(status().is(200))
            .check(jsonPath("$.id").isEL("#{personId}"))
            .check(jsonPath("$.name").is("Natalia"))
            .check(jsonPath("$.gender").is("Female"))
            .check(jsonPath("$.country").exists())
            .check(jsonPath("$.birthday").exists()));

    public static ChainBuilder personCastCredits = exec(http("/people/{personId}/castcredits")
            .get("/people/${firstPersonId}/castcredits")
            .check(status().is(200))
            .check(jsonPath("$[*]._links.show").exists())
            .check(jsonPath("$[*]._links.character").exists()));


    public static ChainBuilder personCrewCredits = exec(http("/people/{personId}/crewcredits")
            .get("/people/${personId}/crewcredits")
            .check(status().is(200))
            .check(jsonPath("$[*]._links.show").exists())
            .check(jsonPath("$[*].type").exists()));

    public static ChainBuilder personGuestCastCredits = exec(http("/people/{personId}/guestcastcredits")
            .get("/people/${firstPersonId}/guestcastcredits")
            .check(status().is(200))
            .check(jsonPath("$[*]._links.episode").exists())
            .check(jsonPath("$[*]._links.character").exists()));
}
