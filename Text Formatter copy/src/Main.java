import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        data.add("Hello There");
        data.add("This is a test");
        data.add("Boohoo");
        data.add("Bomboclat");

        TextFile file = new TextFile(data);

        Map<Integer, IFormat> formats = new HashMap<>();
        formats.put(0, new PlainTextFormat());
        formats.put(1, new HTMLFormat());
        formats.put(2, new MarkDownFormat());
        formats.put(3, new JSONFormat());
        formats.put(4, new XMLFormat());

        System.out.println("Choose a formatting style:");
        for (Map.Entry<Integer, IFormat> entry : formats.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getClass().getSimpleName());
        }

        // User selects format
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                option = Integer.parseInt(scanner.nextLine());
                if (formats.containsKey(option)) break;
                else System.out.println("Please choose a valid option.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }

        file.setFormat(formats.get(option));
        System.out.println("\nFormatted Output:");
        file.printFormatter();

        System.out.print("\nEnter the filename to save: ");
        String filename = scanner.nextLine();
        file.saveToFile(filename);

        scanner.close();
    }
}
