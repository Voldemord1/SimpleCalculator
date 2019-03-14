import java.util.Scanner;

public class MainMenu
{
    public static void main(String[] args)
    {
        System.out.println("ARABIC and ROMAN NUMBERS CALCULATOR (+, - , * , /)");
        String choice;
        Scanner scan = new Scanner(System.in);
        printMenu();
        System.out.print("\n");
        ArabicExpression arabicExpression = new ArabicExpression();
        RomanExpression romanExpression = new RomanExpression();
        do {
            System.out.print("Enter the command for Main menu: ");

            choice = scan.next();

            switch (choice) {
                case "1":
                    arabicExpression.run();
                    break;
                case "2":
                    romanExpression.run();
                    break;
                case "3":
                    printMenu();
                    break;
                case "0":
                    System.out.print("The program is completed");
                    break;
                default:
                    System.out.print("Invalid command entered!\n");
        }
        System.out.print("\n");
    } while (!choice.equals("0"));
}

    private static void printMenu()
    {
        System.out.println("What numbers do you want to use?");
        System.out.println("1 Arabic numbers");
        System.out.println("2 Roman numbers");
        System.out.println("3 Repeat menu");
        System.out.println("0 Exit program");
    }
}
