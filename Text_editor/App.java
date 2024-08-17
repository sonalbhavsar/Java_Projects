import java.util.Scanner;
import notepad.Notepad;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        Notepad notepad = new Notepad(100);

        do {
            System.out.println("choose your option");
            System.out.println("1. display the text");
            System.out.println("2. display the text from given lines");
            System.out.println("3. insert the text");
            System.out.println("4. delete the text");
            System.out.println("5. delete from given lines");
            System.out.println("6. copy the text");
            System.out.println("7. paste the text");
            System.out.println("8. undo your action");
            System.out.println("9. redo your action");
            System.out.println("10. exit");

            System.out.println("enter the chioce:");
            int choice = scn.nextInt();
            int lineNumber, startLine, endLine;

            switch (choice) {
                case 1:
                    notepad.display();
                    break;

                case 2:
                    System.out.println("enter the starting line annd ending line");
                    startLine = scn.nextInt();
                    endLine = scn.nextInt();
                    notepad.display(startLine, endLine);
                    break;

                case 3:
                    System.out.println("enter the text");
                    String text = scn.next();
                    System.out.println("enter the line number: ");
                    lineNumber = scn.nextInt();
                    notepad.insertLine(lineNumber, text);
                    break;

                case 4:
                    System.out.println("enter the line number: ");
                    lineNumber = scn.nextInt();
                    notepad.delete(lineNumber);
                    break;

                case 5:
                    System.out.println("enter the starting line and ending line value: ");
                    startLine = scn.nextInt();
                    endLine = scn.nextInt();
                    notepad.delete(startLine, endLine);
                    break;

                case 6:
                    System.out.println("enter the starting line and ending line value: ");
                    startLine = scn.nextInt();
                    endLine = scn.nextInt();
                    break;

                case 7:
                    System.out.println("enter the line number");
                    lineNumber = scn.nextInt();
                    notepad.paste(lineNumber);
                    break;

                case 8:
                    notepad.undo();
                    break;

                case 9:
                    notepad.redo();
                    break;

                case 10:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");

            }
        } while (true);
    }
}
