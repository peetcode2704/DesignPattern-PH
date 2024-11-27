import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.info("This is an info message.");
        logger.debug("This is a debug message.");
        logger.error("This is an error message.");

        List<String> history = logger.getLogHistory();
        System.out.println("Log History:");
        for (String log : history) {
            System.out.println(log);
        }

        Logger logger2 = Logger.getInstance();
        logger2.info("Another info message.");

        System.out.println(logger == logger2);
    }
}
