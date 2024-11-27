import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private List<String> logHistory;

    private Logger() {
        logHistory = new ArrayList<>();
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
        System.out.println(logMessage);
        logHistory.add(logMessage);
    }

    // Public methods for each log level
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
}
