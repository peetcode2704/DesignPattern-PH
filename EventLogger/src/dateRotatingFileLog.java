import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class dateRotatingFileLog implements LogOutput {
    private FileWriter fileWriter;
    private String currentDate;
    public dateRotatingFileLog() {
        currentDate = getCurrentDate();
        openNewLogFile();
    }
    private String getCurrentDate() {
        return new SimpleDateFormat("ddMMyyyy").format(new Date());
    }
    private void openNewLogFile() {
        try {
            String fileName = "log_" + currentDate;
            fileWriter = new FileWriter(fileName, true);
        } catch (IOException e) {
            throw new RuntimeException("Error initializing file writer: " + e);
        }
    }
    public void writeLog(String logMessage) {
        try {
            String newDate = getCurrentDate();
            if (!newDate.equals(currentDate)) {
                fileWriter.close();
                currentDate = newDate;
                openNewLogFile();
            }
            fileWriter.write(logMessage + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Error writing log file: " + e.getMessage());
        }
    }
    public void close() throws IOException {
        if (fileWriter != null) {
            fileWriter.close();
        }
    }
}