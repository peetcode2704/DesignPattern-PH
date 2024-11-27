import java.util.ArrayList;

public class PlainTextFormat implements IFormat {
    public void format(ArrayList<String> fileContent) {
        for (String line : fileContent) {
            System.out.print(line + "\n");
        }
    }
}
