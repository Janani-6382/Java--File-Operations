
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "example.txt";
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n📂 File Operations Menu");
            System.out.println("1. Write to File (Overwrite)");
            System.out.println("2. Read from File");
            System.out.println("3. Append to File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    // Write to file
                    try {
                        FileWriter writer = new FileWriter(fileName);
                        System.out.println("✍️ Enter text to write (type 'exit' to stop):");
                        while (true) {
                            String input = scanner.nextLine();
                            if (input.equalsIgnoreCase("exit")) break;
                            writer.write(input + "\n");
                        }
                        writer.close();
                        System.out.println("✅ File written successfully.");
                    } catch (IOException e) {
                        System.out.println("❌ Error writing to file.");
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    // Read file
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        String line;
                        System.out.println("\n📄 File Content:");
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("❌ Error reading file.");
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    // Append to file
                    try {
                        FileWriter writer = new FileWriter(fileName, true); // append mode
                        System.out.println("➕ Enter text to append (type 'exit' to stop):");
                        while (true) {
                            String input = scanner.nextLine();
                            if (input.equalsIgnoreCase("exit")) break;
                            writer.write(input + "\n");
                        }
                        writer.close();
                        System.out.println("✅ Content appended successfully.");
                    } catch (IOException e) {
                        System.out.println("❌ Error appending to file.");
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    System.out.println("👋 Exiting program.");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
