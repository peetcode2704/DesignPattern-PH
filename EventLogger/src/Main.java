// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();

        Logger logger2 = Logger.getInstance();

        System.out.println(logger1 == logger2);  // Output: true
    }
}