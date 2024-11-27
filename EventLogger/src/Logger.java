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

    public void logMessage(String message) {
        System.out.println("LOG: " + message);
    }
}
