package abhilash.example.com.melonicious.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utility {

    public static List<String> getListFromCSV(String input) {
        List<String> list = new ArrayList<>(Arrays.asList(input.split(" , ")));
        return list;
    }

}
