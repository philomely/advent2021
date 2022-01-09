import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventUtil {
    public static List<Integer> readIntInput(String file) {
        ArrayList<Integer> result = new ArrayList<>();
        try (Scanner s = new Scanner(new FileReader(file))) {
            while (s.hasNext()) {
                result.add(Integer.parseInt(s.nextLine()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> readStrInput(String file) {
        ArrayList<String> result = new ArrayList<>();
        try (Scanner s = new Scanner(new FileReader(file))) {
            while (s.hasNext()) {
                result.add(s.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
