package advisor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    String choice;

    Boolean auth = false;

    Scanner sc = new Scanner(System.in);

    public void Actions(){

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

    public void handle(String choice){

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
                System.out.println("https://accounts.spotify.com/authorize?client_id=f8a586cd8fa2403fb773606be4f609ab&redirect_uri=http://localhost:8080&response_type=code\n" +
                        "---SUCCESS---");
                auth = true;
                break;
            case "exit":
                System.out.println("---GOODBYE!---");
                System.exit(0);
                break;
        }

    }

    private void printformatted(List<String> al){

        for(String string : al){

            System.out.println(string);

        }

    }

}
