package advisor;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;
import static advisor.Credentials.*;

public class Menu {

    public Menu(String[] args) {
        this.args = args;
    }

    String[] args = new String[2];

    String choice;

    Boolean auth = false;

    Boolean isServerCreated = false;

    Scanner sc = new Scanner(System.in);

    String apiAdress="https://accounts.spotify.com";

    public void Actions() throws IOException, InterruptedException {



        if(args.length != 0 && args[0].equals("-access")) {
            apiAdress = args[1];
        }

    while(true) {

        choice = sc.nextLine();

        if (auth == false && !choice.equals("auth")) {
                System.out.println("Please, provide access for application.");
            if (choice.equals("exit")){
                System.exit(0);
                break;
            }
                continue;
        }

        handle(choice);
    }

    }

    public void handle(String choice) throws IOException, InterruptedException {


        switch(choice){
            case "new":
                    System.out.println("---NEW RELEASES---");
                    printformatted(new Records().getNewRecords());
                break;
            case "featured":
                System.out.println("---FEATURED---");
                printformatted(new Records().getFeaturedRecords());
                break;
            case "categories":
                System.out.println("---CATEGORIES---");
                printformatted(new Categories().getCategories());
                break;
            case "playlists Mood":
                System.out.println("---MOOD PLAYLISTS---");
                printformatted(new Playlists().getPlaylists());
                break;
            case "auth":

                System.out.println("use this link to request the access code:");
                if (!isServerCreated) { createServer();}
                System.out.println("waiting for code...");


                break;
            case "exit":
                System.out.println("---GOODBYE!---");
                System.exit(0);

                break;
        }

    }

    private void createServer() throws IOException, InterruptedException {

        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8090), 0);

        server.createContext("/",
                new HttpHandler() {
                    public void handle(HttpExchange exchange) throws IOException {
                        String query = exchange.getRequestURI().getQuery();
                        String text;
                        if (query == null || query.contains("error")) {
                            text = "Authorization code not found. Try again.";
                            exchange.sendResponseHeaders(200, text.length());
                            exchange.getResponseBody().write(text.getBytes());
                            exchange.getResponseBody().close();
                        }
                        else if (query.contains("code")) {
                            System.out.println("code received");
                            code = query;

                            try {
                                auth = getToken();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            text = "Got the code. Return back to your program.";
                            exchange.sendResponseHeaders(200, text.length());
                            exchange.getResponseBody().write(text.getBytes());
                            exchange.getResponseBody().close();
                            server.stop(10);
                        }


                    }
                }
        );

        server.setExecutor(null);
        server.start();

        System.out.println(spotifyAuthorizationPage);
        
        isServerCreated = true;

    }

    private void getCode() throws IOException, InterruptedException {

        HttpClient client1 = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri((spotifyAuthorizationPage))
                .GET()
                .build();

        HttpResponse<String> response1 = client1.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response1.statusCode());

    }

    private Boolean getToken() throws IOException, InterruptedException {


        HttpClient client2 = HttpClient.newBuilder().build();

        HttpRequest postRequestToSpotify = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(apiAdress + "/api/token"))
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=" + grantType
                        + "&" + code
                        + "&redirect_uri=" + redirectURI
                        + "&client_id=" + clientId
                        + "&client_secret=" + clientSecret))
                .build();

        System.out.println("making http request for access_token...");

        HttpResponse<String> response2 = client2
                .send(postRequestToSpotify, HttpResponse.BodyHandlers.ofString());
        System.out.println("response:");
        System.out.println(response2.body());

        if (response2.body().contains("access_token")) {
            System.out.println("---SUCCESS---");
            return true;
        }
        return false;


    }

    private void printformatted(List<String> al){

        for(String string : al){

            System.out.println(string);

        }

    }

}



