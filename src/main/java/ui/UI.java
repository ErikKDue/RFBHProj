package ui;

import java.util.Scanner;


public class UI
{

    public static void main(String[]args)
    {
        menu();
    }


    public static void startUp()
    {
        System.out.println("Skriv dit brugernavn og derfeter adgangskode for at fortsætte");

        Scanner scanner = new Scanner(System.in);


        //placeholder login system...

        String Accountname = scanner.nextLine();
        String Password = scanner.nextLine();

        enterLogin(Accountname, Password);

    }

    public static void enterLogin(String Accountname, String Password)
    {

        // placeholder login osv...
        if (Accountname.equals("admin") && Password.equals("admin"))
        {
            System.out.println("Velkommen, " + Accountname);
            menu();
        }

        else
        {
            System.out.println("Forkert adgangskode, prøv igen.");
            startUp();
        }

    }

    // Det generelle display vindue man kommer til efter login.

    // Tænker at der vil være 2 menuer, en for lederen og en for normale ansatte, hvor de normale ansatte kun kan se børn og ansatte osv... Og kun lederen kan redigerer.

    public static void menu()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valgmuligheder \n --------------------");
        System.out.println("1. For at se/redigerer ansatte.");
        System.out.println("2. Vis børn.");
        System.out.println("0. Afslut program.");

        int DisplayValg = scanner.nextInt();

        switch (DisplayValg)
        {
            case 1:
                menuOverAnsatte();
                break;
            case 2:
                System.out.println("vis børn");
                break;
            case 0:
                System.out.println("Afslutter programmet...\n --------------------");
                break;
            default:
                System.out.println("Ukendt valg, prøv igen \n --------------------");
                menu();
                break;
        }

    }


    public static void menuOverAnsatte()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valgmuligheder \n --------------------");
        System.out.println("1. Vis ansatte");
        System.out.println("2. Rediger ansatte");
        System.out.println("3. Tilbage til menuen");
        System.out.println("0. Afslut program");

        int DisplayValg = scanner.nextInt();

        switch (DisplayValg)
        {
            case 1:
                System.out.println("Viser ansatte...");
                break;
            case 2:
                System.out.println("Redigerer ansatte...");
                break;
            case 3:
                menu();
                break;
            case 4:
                System.out.println("Afslutter programmet...\n --------------------");
                break;
            default:
                System.out.println("Ukendt valg, prøv igen \n --------------------");
                menu();
                break;
        }

    }

    public static void displayBørn()
    {
        System.out.println("tes");
    }

    public static void Edit()
    {

    }

    public static void DisplayUserOptions()
    {

    }

}