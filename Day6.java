import javax.xml.stream.events.Characters;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Day6 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Tyler\\OneDrive\\Desktop\\Advent.txt");
        BufferedReader input = new BufferedReader(new FileReader(file));

        String line;
        while ((line = input.readLine()) != null) {
            ArrayList<String> marker = new ArrayList<>();
            int count = 0;
            int total = 0;

            // load into line array
            while (total != line.length()) {
                String check = "";
                for (int i = count; i < 14; i++) {
                    marker.add(count, String.valueOf(line.charAt(i)));
                    count++;
                    total++;
                }
                //loop through when array is full and rebuild
                for (int i = 0; i < marker.size(); i++) {
                    for (int j = 0; j < marker.size(); j++) {
                        if (isDouble(marker)) {
                            marker.remove(0);
                            marker.add(String.valueOf(line.charAt(total)));
                            total++;
                            i = 0;
                            break;
                        }
                        else if (!isDouble(marker)) {
                            System.out.println(total);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static boolean isDouble(ArrayList<String> marker) {
        for (int i = 0; i < marker.size();i++) {
            String check = marker.remove(i);

                if (marker.contains(String.valueOf(check))) {
                    marker.add(i,check);
                    return true;
                } else {
                    marker.add(i,check);
                    if(i == marker.size()){
                        return false;
                    }
                }
        }
        return false;
    }
}


