import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class PersonReader {
    public static void main(String[] args)
        Scanner fileReader;
        File selectedFile;
        JFileChooser chooser = new JFileChooser();
        String line;

        try {
            File workingDirectory = new File(System.getProperty("user.dir")); // Set default directory to the project folder
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();  // this is a File object not a String filename
                fileReader = new Scanner(selectedFile);  // Open the file for reading

                System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\n", "First Name", "Last Name", "Age", "Email");
                System.out.print("=======================================================");
                // Now process the file.  Here we just dump it line by line to the console
                line = fileReader.nextLine(); // ignore first Line
                while (fileReader.hasNextLine()) {
                    line = fileReader.nextLine();
                    String[] lineSplit = line.split(",");
                    // Show the file on the console
                    System.out.printf("\n%-10s\t%-10s\t%-10s\t%-10s", lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3]);

                }
                System.out.println("");

                fileReader.close();
            } else { // they didn't select a file so exit...
                JOptionPane.showMessageDialog(null, "Cancelled by User.  Exiting...");
                System.exit(0);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found error!");
        }
    }
}
import java.util.ArrayList;
        import java.util.Scanner;

public class PortfolioGenerator {
    public static void main(String[] args) {
        // Write your code here ... ⬇
        String name;
        String email;
        String personalBackground;
        ArrayList<String> programmingLanguages;
        ArrayList<String> achievements;

        Scanner in = new Scanner(System.in);
        name = SafeInput.getString(in, "What is your name? ");
        email = SafeInput.getEmail(in, "What is your email? ");
        personalBackground = SafeInput.getString(in, "a Few sentences of personal Background: ");
        programmingLanguages = SafeInput.getArrayOfStrings(in, "What programming languages do you know? ");
        achievements = SafeInput.getArrayOfStrings(in, "What achievements have you made, or things you'd like to share with us? ");

        printHeader(name);

        System.out.println("\n\nemail: "+ email+"\n");

        printSectionHeader("Personal Background");
        System.out.println(personalBackground);
        System.out.println();

        printSectionHeader("Programming Language");
        for (int counter =0; counter < programmingLanguages.size() ;counter++) {
            System.out.println(counter+1 + ". "+ programmingLanguages.get(counter));
        }
        System.out.println();

        printSectionHeader("Achievements and Things I would like to share");
        for (String achievement: achievements) {
            System.out.println("- "+ achievement);
        }
        System.out.println();
    }

    private static void printHeader(String name) {
        int REPORT_LINE_LENGTH = 50;
        int NUMBER_OF_ASTERISKS_AROUND_NAME = 4;
        int SPACES_AROUND_THE_NAME = (REPORT_LINE_LENGTH - NUMBER_OF_ASTERISKS_AROUND_NAME - name.length()) / 2;

        printReportLine(REPORT_LINE_LENGTH);

        System.out.print("\n**");
        printSpacesAroundName(SPACES_AROUND_THE_NAME);
        System.out.print(name);
        printSpacesAroundName(SPACES_AROUND_THE_NAME);
        System.out.println("**");

        printReportLine(REPORT_LINE_LENGTH);
    }

    private static void printReportLine(int REPORT_LINE_LENGTH) {
        for (int i = 0; i <= REPORT_LINE_LENGTH; i++) {
            System.out.print('*');
        }
    }

    private static void printSpacesAroundName(int SPACES_AROUND_THE_NAME) {
        for (int i = 0; i < SPACES_AROUND_THE_NAME; i++) {
            System.out.print(" ");
        }
    }

    private static void printSectionHeader(String sectionName) {
        String sectionTitle = "** " + sectionName+ ": ";
        System.out.println(sectionTitle);
        for (char letter: sectionTitle.toCharArray()) {
            System.out.print('-');
        }
        System.out.println();
    }

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


    public class SafeInput {

        public static int getRangedInt(Scanner console, String prompt, int low, int high) {
            int retVal = 0;
            String trash = "";
            boolean done = false;

            do {
                System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
                if (console.hasNextInt()) {
                    retVal = console.nextInt();
                    console.nextLine();
                    if (retVal >= low && retVal <= high) {
                        done = true;
                    } else {
                        System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                    }
                } else {
                    trash = console.nextLine();
                    System.out.println("You must enter an int: " + trash);
                }
            } while (!done);

            return retVal;
        }


        public static double getRangedDouble(Scanner console, String prompt, int low, int high) {
            double retVal = 0;
            String trash = "";
            boolean done = false;

            do {
                System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
                if (console.hasNextDouble()) {
                    retVal = console.nextDouble();
                    console.nextLine();
                    if (retVal >= low && retVal <= high) {
                        done = true;
                    } else {
                        System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                    }
                } else {
                    trash = console.nextLine();
                    System.out.println("You must enter a double: " + trash);
                }
            } while (!done);

            return retVal;
        }

        public static String getString(Scanner console, String prompt) {
            String retval = "";
            System.out.println("\n" + prompt + ": ");
            if (console.hasNext()) {
                retval = console.nextLine();
            }
            return retval;
        }

