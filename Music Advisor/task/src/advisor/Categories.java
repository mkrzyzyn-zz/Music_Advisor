package advisor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Categories {

    private List<String> categories = Arrays.asList("Top Lists",
            "Pop",
            "Mood",
            "Latin");

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }



}
