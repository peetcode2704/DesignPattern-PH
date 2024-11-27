public class RemoteServerLogDestination implements LogDestination {
    @Override
    public void logMessage(String message) {
        System.out.println("Sending log to remote server: " + message);  // Simulate sending to a remote server
    }
}