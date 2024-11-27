import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


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
    public static synchronized Logger getInstance() {
        if (instance == null) {
            System.out.println("Creating Logger instance.");
            instance = new Logger();
        }
        System.out.println("Returning Logger instance.");
        return instance;
    }

    public synchronized void log(String severityLevel, String message) {
        String logMessage = "[" + severityLevel + "] " + message;

        System.out.println(logMessage);

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

    public void archiveLogs() {
        String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        String archiveFileName = "logs_archive_" + timestamp + ".log";

        try (BufferedWriter archiveWriter = new BufferedWriter(new FileWriter(archiveFileName))) {
            for (String log : logHistory) {
                archiveWriter.write(log + "\n");
            }
            System.out.println("Logs archived to: " + archiveFileName);
        } catch (IOException e) {
            System.out.println("Error archiving logs: " + e.getMessage());
        }
    }
}
