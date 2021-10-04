package advisor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Playlists {

    public List<String> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<String> playlists) {
        this.playlists = playlists;
    }

    private List<String> playlists = Arrays.asList("Walk Like A Badass",
            "Rage Beats",
            "Arab Mood Booster",
            "Sunday Stroll");
}
