public class ConsoleLogDestination implements LogDestination {
    @Override
    public void logMessage(String message) {
        System.out.println(message);  // Output to console
    }
}