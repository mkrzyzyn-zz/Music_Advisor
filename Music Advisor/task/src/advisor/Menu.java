package advisor;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    String choice;

    Boolean auth = false;

    Scanner sc = new Scanner(System.in);

    public void Actions() throws IOException {

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

    public void handle(String choice) throws IOException {

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
                createServer();
                System.out.println("https://accounts.spotify.com/authorize?client_id=f8a586cd8fa2403fb773606be4f609ab&redirect_uri=http://localhost:8090&response_type=code\n" +
                        "---SUCCESS---");
                auth = auth();
                break;
            case "exit":
                System.out.println("---GOODBYE!---");
                System.exit(0);
                break;
        }

    }

    private void createServer() throws IOException {

        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8090), 0);

        server.createContext("/",
                new HttpHandler() {
                    public void handle(HttpExchange exchange) throws IOException {
                        String query = exchange.getRequestURI().getQuery();
                        String hello = "hello, world";
                        exchange.sendResponseHeaders(200, hello.length());
                        exchange.getResponseBody().write(hello.getBytes());
                        exchange.getResponseBody().close();
                    }
                }
        );

        server.start();

    }

    private Boolean auth(){

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create("https://accounts.spotify.com/authorize?client_id=f8a586cd8fa2403fb773606be4f609ab&redirect_uri=" +
                        "http://localhost:8090&response_type=code"))
                .POST(HttpRequest.BodyPublishers.ofString("login=admin&password=admin"))
                .build();

        return true;

    }

    private void printformatted(List<String> al){

        for(String string : al){

            System.out.println(string);

        }

    }

}



