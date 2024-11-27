public class SMSNotification implements MainNotification {
    private String phoneNumber;

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void send(String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}
