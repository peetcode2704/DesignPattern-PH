public class BasicNotification implements MainNotification {
    public void send(String message) {
        System.out.println("Basic Notification: " + message);
    }
}