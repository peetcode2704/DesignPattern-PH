public class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            System.out.println("Creating Logger instance.");
            instance = new Logger();
        }
        System.out.println("Returning Logger instance.");
        return instance;
    }

    private void log(String severityLevel, String message) {
        System.out.println("[" + severityLevel + "] " + message);
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
}

