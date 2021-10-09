package advisor;

import java.net.URI;

public class Credentials {
    public static String clientId = "f8a586cd8fa2403fb773606be4f609ab";
    public static String clientSecret = "96fd4bf58c1e412ebe7ff83f26c37308";
    public static String redirectURI = "http://127.0.0.1:8091";
    public static String grantType = "authorization_code";
    public static String code = "";
    public static String token = "";
    public static String apiAuthAdressDef = "https://accounts.spotify.com";
    public static String apiResAdressDef = "https://api.spotify.com";

    public static URI spotifyAuthorizationPage = URI.create(apiAuthAdressDef + "/authorize?client_id="
            + clientId + "&redirect_uri="
            + redirectURI + "&response_type=code");


}