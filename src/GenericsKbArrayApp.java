import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

class GenericsKbArrayApp 
{
    GenericsKbArray ga = new GenericsKbArray();
    
    public void readInFile() {
        //Scanner scanner = new Scanner(System.in);

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter file name: ");
            String fileName = scanner.nextLine();
            
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                ga.add(new GenericsKb(line));
            }
            // String fileName = scanner.nextLine();
            // ga.add(new GenericsKb(fileName));
            System.out.println("Knowledge base loaded successfully.");
            ga.updateSize(); // Update the size of the array
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
           // e.printStackTrace();
        } /**finally {
            scanner.close();
          }*/

        System.out.println(ga.size);
    }

        
    public void userInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action from the menu:");
            System.out.println("1. Load a knowledge base from a file");
            System.out.println("2. Add a new statement to the knowledge base");
            System.out.println("3. Search for an item in the knowledge base by term");
            System.out.println("4. Search for an item in the knowledge base by term and sentence");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        // Implement functionality to display information from the knowledge base
                        // Scanner sc = new Scanner(System.in);
                        // System.out.print("Enter file name: ");
                        // String fileName = scanner.nextLine();
                        // ga.add(new GenericsKb(line));
                        readInFile();
                        // System.out.println("Knowledge base loaded successfully.");
                        break;
                    case 2:
                        System.out.print("Enter the term: ");
                        String term = scanner.nextLine();
                        System.out.print("Enter the statement: ");
                        String sentence = scanner.nextLine();
                        System.out.print("Enter the confidence score: ");
                        double confidenceScore = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        // ga.add(new GenericsKb(term, sentence, confidenceScore));
                        System.out.println("Statement for term " + term + " has been updated. ");
                        break;
                    case 3:
                        System.out.print("Enter the term to search: ");
                        String searchTerm = scanner.nextLine().trim();
                        GenericsKb foundStatement = ga.find(new GenericsKb(searchTerm));

                        if (foundStatement != null) {
                            System.out.println("Statement found: " + foundStatement.getSentence() + " (Confidence score: " + foundStatement.getConfidenceScore() + ")");
                        } else {
                            System.out.println("Statement not found in the knowledge base.");
                        }
                            break;

                    /**case 3:
                        System.out.print("Enter the term to search: ");
                        String searchTerm = scanner.nextLine();
                        GenericsKb foundStatement = ga.find(new GenericsKb(searchTerm));

                        if (foundStatement != null) {
                            System.out.println("Statement found: " + foundStatement.getSentence() + " (Confidence score: " + foundStatement.getConfidenceScore() + ")");
                        } else {
                            System.out.println("Statement not found in the knowledge base.");
                        }
                        break;*/
                    case 4:
                        // Implement functionality to search for an item in the knowledge base by term and sentence
                        System.out.print("Enter the term: ");
                        String terms = scanner.nextLine();
                        GenericsKb inp = new GenericsKb(terms);
                        // GenericsKb foundStatements = ga.find(input);
                        System.out.print("Enter the statement to search for: ");
                        String statements = scanner.nextLine();
                        GenericsKb inpu = new GenericsKb(statements);
                        // GenericsKb foundStatements = ga.find(inputs);
                        // Call the find method with the GenericsKb instance
                        // GenericsKb foundStatements = ga.find(searchStatement);
                        // Create a GenericsKbArray instance and load the knowledge base
                        // GenericsKbArray ga = new GenericsKbArray();
                        GenericsKb foundStatements = ga.find(inp);

                        if (foundStatements != null) {
                            System.out.println("The statement was found and has a confidence score of " + foundStatements.getConfidenceScore() + ".");
                        } else {
                            System.out.println("The statement was not found in the knowledge base.");
                        }
                        break;
                    case 5:
                        System.out.println("Exiting the application. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }	catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
            } catch (NoSuchElementException e) {
                    System.out.println("No input found. Exiting the program.");
                    break;
            } catch (Exception e) {
                System.out.println("An unexpected error occurred.");
                e.printStackTrace();
            }
            
        }	
    }
    

    
    
    public static void main (String [] args) 
    {
        // GenericsKb gen = new GenericsKb("Dog	dogs are barking	1.0");
        // System.out.println(gen.confidenceScore);
           
         GenericsKbArrayApp genApp = new GenericsKbArrayApp();
         // genApp.readInFile();
         genApp.userInterface();
         genApp.readInFile();        
    }
}