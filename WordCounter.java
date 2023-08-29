package codsoft;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter 'text' to input text manually or 'file' to provide a file path: ");
        String inputType = scanner.nextLine();
        
        String text = "";
        
        if (inputType.equalsIgnoreCase("text")) {
            System.out.print("Enter the text: ");
            text = scanner.nextLine();
        } else if (inputType.equalsIgnoreCase("file")) {
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                text = readFile(filePath);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
                System.exit(1);
            }
        } else {
            System.out.println("Invalid input type.");
            System.exit(1);
        }
        
        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;
        
        System.out.println("Total word count: " + wordCount);
        
        // Additional features could be added here
        
        scanner.close();
    }
    
    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        Scanner fileScanner = new Scanner(new File(filePath));
        while (fileScanner.hasNextLine()) {
            content.append(fileScanner.nextLine()).append("\n");
        }
        fileScanner.close();
        return content.toString();
    }
}
