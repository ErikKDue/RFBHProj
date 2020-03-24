package ui;

import java.util.Scanner;


public class UI
{

    public static void main(String[]args)
    {
        Startup();
    }


    public static void Startup()
    {
        System.out.println("Skriv dit brugernavn og derfeter adgangskode for at fortsætte");

        Scanner scanner = new Scanner(System.in);


        //placeholder login system...

        String Accountname = scanner.nextLine();
        String Password = scanner.nextLine();

        EnterLogin(Accountname, Password);

    }

    public static void EnterLogin(String Accountname, String Password)
    {

        // placeholder login osv...
        if (Accountname.equals("admin") && Password.equals("admin"))
        {
            System.out.println("Velkommen, " + Accountname);
            Menu();
        }

        else
        {
            System.out.println("Forkert adgangskode, prøv igen.");
            Startup();
        }

    }

    // Det generelle display vindue man kommer til efter login.

    public static void Menu()
    {
        DisplayMenu();

        Scanner scanner = new Scanner(System.in);
        int DisplayValg = scanner.nextInt();

        switch (DisplayValg)
        {
            case 1:
                System.out.println("vis ansatte");
                break;
            case 2:
                System.out.println("vis børn");
                break;
            case 0:
                System.out.println("Afslutter programmet");
            default:
                System.out.println("Ukendt valg, prøv igen");
                Menu();
                break;
        }


    }

    public static void DisplayMenu()
    {
        System.out.println("Tryk på følgende tast, og derefter enter for at se følgende -");
        System.out.println("1. Vis ansatte");
        System.out.println("2. Vis børn");
        System.out.println("...");
    }

    public static void DisplayAnsatte()
    {
        System.out.println("tesad");
    }

    public static void DisplayBørn()
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