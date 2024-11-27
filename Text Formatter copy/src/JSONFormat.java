import java.util.ArrayList;

public class JSONFormat implements IFormat {
    public void format(ArrayList<String> fileContent) {
        System.out.println("{");
        System.out.println("\"content\": [");
        for (int i = 0; i < fileContent.size(); i++) {
            System.out.print("  \"" + fileContent.get(i) + "\"");
            if (i < fileContent.size() - 1) {
                System.out.print(",");
            }
            System.out.println();
        }
        System.out.println("]");
        System.out.println("}");
    }
}
