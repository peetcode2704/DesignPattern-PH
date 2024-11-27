public class SlackNotification implements MainNotification {
    private final MainNotification slackNoti;
    public SlackNotification(MainNotification notification) {
        this.slackNoti = notification;
    }
    @Override
    public void send(String message) {
        slackNoti.send(message);
        System.out.println("Slack Notification: Sending from '" + message + "' to Slack.");
    }
}