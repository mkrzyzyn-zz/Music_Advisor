package advisor;

import java.net.URI;

public class Credentials {
    public static String clientId = "";
    public static String clientSecret = "";
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
