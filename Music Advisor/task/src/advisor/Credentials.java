package advisor;
import java.net.URI;

public class Credentials {
    public static String clientId = "377e7402efea4b2181d93d91cd531ec8";
    public static String clientSecret = "d533cbb7ae1845118aff4265fc8eee1a";
    public static String redirectURI = "http://localhost:8080";
    public static String grantType = "authorization_code";
    public static String code = "";

    public static URI spotifyAuthorizationPage = URI.create("https://accounts.spotify.com/authorize?client_id="
            + clientId + "&redirect_uri="
            + redirectURI + "&response_type=code");
}