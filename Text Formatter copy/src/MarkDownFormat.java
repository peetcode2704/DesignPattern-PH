import java.util.ArrayList;
import java.util.Random;

public class MarkDownFormat implements IFormat {
    public void format(ArrayList<String> fileContent) {
        String[] options = {"**", "#", "~~", "***", "_", "<sub>"};
        Random rng = new Random();

        System.out.print("# " + fileContent.get(0) + "\n");
        for (String line : fileContent) {
            String option = options[rng.nextInt(options.length)];
            System.out.print(option + line + option + "\n");
        }
    }
}