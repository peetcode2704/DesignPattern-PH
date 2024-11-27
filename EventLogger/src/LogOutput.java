import java.io.IOException;

public interface LogOutput {
    void writeLog(String logMessage);
    void close() throws IOException;
}