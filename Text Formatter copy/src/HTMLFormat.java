import java.util.ArrayList;

public class HTMLFormat implements IFormat {
    public void format(ArrayList<String> fileContent) {
        System.out.print("<html dir=\"ltr\" lang=\"en\">\n<head>\n");
        for (String line : fileContent) {
            System.out.print("<p>" + line + "</p>\n");
        }
        System.out.print("</head>\n</html>");
    }
}