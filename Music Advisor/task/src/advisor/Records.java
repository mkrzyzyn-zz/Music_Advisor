package advisor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Records {

    private List<String> newRecords = Arrays.asList("Mountains [Sia, Diplo, Labrinth]",
            "Runaway [Lil Peep]", "The Greatest Show [Panic! At The Disco]",
            "All Out Life [Slipknot]");

    private List<String> featuredRecords = new ArrayList<>(Arrays.asList("Mellow Morning","Wake Up and Smell the Coffee",
            "Monday Motivation",
            "Songs to Sing in the Shower"));

    public List<String> getNewRecords() {
        return newRecords;
    }

    public void setNewRecords(List<String> newRecords) {
        this.newRecords = newRecords;
    }

    public List<String> getFeaturedRecords() {
        return featuredRecords;
    }

    public void setFeaturedRecords(List<String> featured) {
        this.featuredRecords = featured;
    }

}
