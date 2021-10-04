package advisor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    String choice;

    Scanner sc = new Scanner(System.in);

    public void Actions(){

    while(true) {

        choice = sc.nextLine();

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
            case "playlists":
                System.out.println("---MOOD PLAYLISTS---");
                printformatted(new Playlists().getPlaylists());
                break;
            case "exit":
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
