import java.util.ArrayList;

public class XMLFormat implements IFormat {
    public void format(ArrayList<String> fileContent) {
        System.out.println("<document>");
        for (String line : fileContent) {
            System.out.println("  <line>" + line + "</line>");
        }
        System.out.println("</document>");
    }
}
