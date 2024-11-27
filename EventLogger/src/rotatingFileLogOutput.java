import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
public class rotatingFileLogOutput implements LogOutput {
    private FileWriter fileWriter;
    private int fileIndex;
    private File currentLogFile;
    private static final long MAX_FILE_SIZE = 1024 * 1024;
    public rotatingFileLogOutput() {
        fileIndex = 0;
        openNewLogFile();
    }
    private void openNewLogFile() {
        try {
            String fileName = "log_" + fileIndex;
            currentLogFile = new File(fileName);
            fileWriter = new FileWriter(currentLogFile, true);
            fileIndex++;
        } catch (IOException e) {
            throw new RuntimeException("Error initializing file writer: " + e);
        }
    }
    public void writeLog(String logMessage) {
        try {
            if (currentLogFile.length() >= MAX_FILE_SIZE) {
                fileWriter.close();
                openNewLogFile();
            }
            fileWriter.write(logMessage + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Error writing log file: " + e.getMessage());
        }
    }
    public void close() throws IOException {
        if (fileWriter != null) {
            fileWriter.close();
        }
    }
}