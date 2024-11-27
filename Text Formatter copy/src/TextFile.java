import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextFile {
    private ArrayList<String> fileContent;
    private IFormat format;

    public TextFile() {
        fileContent = new ArrayList<>();
    }

    public TextFile(ArrayList<String> data) {
        fileContent = data;
    }

    public void setFormat(IFormat format) {
        this.format = format;
    }

    public void printFormatter() {
        format.format(fileContent); // Directly print to console
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : fileContent) {
                writer.write(line + "\n");
            }
            System.out.println("File saved as: " + filename);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
