package advisor;

import java.net.URI;

public class Credentials {
    public static String clientId = "";
    public static String clientSecret = "";
    public static String redirectURI = "http://127.0.0.1:8090";
    public static String grantType = "authorization_code";
    public static String code = "";

    public static URI spotifyAuthorizationPage = URI.create("https://accounts.spotify.com/authorize?client_id="
            + clientId + "&redirect_uri="
            + redirectURI + "&response_type=code");


}
