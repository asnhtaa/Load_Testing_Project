package protocols;

import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;



public class Protocol {

    public static HttpProtocolBuilder httpProtocol = HttpDsl
            .http.baseUrl("https://api.tvmaze.com")
            .contentTypeHeader("application/json; charset=UTF-8")
            .acceptHeader("application/json")
            .acceptLanguageHeader("ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
            .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
}