public class EmailNotification implements MainNotification {
    private final MainNotification EmailNoti;
    public EmailNotification(MainNotification notification) {
        this.EmailNoti = notification;
    }
    public void send(String message) {
        EmailNoti.send(message);
        System.out.println("Email Notification: Sending from'" + message + "' by Email.");
    }
}