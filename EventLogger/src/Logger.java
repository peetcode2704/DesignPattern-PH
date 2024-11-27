import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private List<String> logHistory;
    private BufferedWriter fileWriter;

    private Logger() {
        logHistory = new ArrayList<>();
        try {
            fileWriter = new BufferedWriter(new FileWriter("messages.log", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            System.out.println("Creating Logger instance.");
            instance = new Logger();
        }
        System.out.println("Returning Logger instance.");
        return instance;
    }

    private void log(String severityLevel, String message) {
        String logMessage = "[" + severityLevel + "] " + message;

        // Write to console
        System.out.println(logMessage);

        // Write to file
        try {
            if (fileWriter != null) {
                fileWriter.write(logMessage);
                fileWriter.newLine();
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        logHistory.add(logMessage);
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void debug(String message) {
        log("DEBUG", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    public List<String> getLogHistory() {
        return logHistory;
    }

    public void close() {
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
