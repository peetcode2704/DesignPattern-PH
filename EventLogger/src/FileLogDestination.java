import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogDestination implements LogDestination {
    private BufferedWriter writer;

    public FileLogDestination(String fileName) throws IOException {
        writer = new BufferedWriter(new FileWriter(fileName, true));  // Append mode
    }

    @Override
    public void logMessage(String message) {
        try {
            writer.write(message);
            writer.newLine();  // Newline after each log message
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void close() throws IOException {
        writer.close();
    }
}
