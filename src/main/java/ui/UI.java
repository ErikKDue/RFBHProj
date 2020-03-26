package ui;

import businesslayer.Child;
import businesslayer.Parent;
import filehandler.FileHandler;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

        System.out.println("Valgmuligheder");
        System.out.println("1. For at se/redigerer ansatte.");
        System.out.println("2. For at se/redigerer børn.");
        System.out.println("0. Afslut program.");


        try
        {
            int menuValg = scanner.nextInt();

            switch (menuValg) {
                case 1:
                    adskiller();
                    menuOverAnsatte();
                    break;
                case 2:
                    menuOverBørn();
                    adskiller();
                    break;
                case 0:
                    System.out.println("Afslutter programmet...");
                    adskiller();
                    break;
                default:
                    System.out.println("Ukendt valg, prøv igen");
                    adskiller();
                    menu();
                    break;
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Ukendt valg, prøv igen");
            adskiller();
            menu();
        }

    }


    public static void menuOverAnsatte()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valgmuligheder");
        System.out.println("1. Vis ansatte");
        System.out.println("2. Rediger ansatte");
        System.out.println("3. Tilbage");
        System.out.println("0. Afslut program");

        try {

            int menuOverAnsatteValg = scanner.nextInt();

            switch (menuOverAnsatteValg) {
                case 1:
                    adskiller();
                    System.out.println("Viser ansatte...");
                    displayAnsatte();
                    break;
                case 2:
                    adskiller();
                    System.out.println("Redigerer ansatte...");
                    redigerAnsatte();
                    break;
                case 3:
                    menu();
                    adskiller();
                    break;
                case 0:
                    System.out.println("Afslutter programmet...");
                    adskiller();
                    break;
                default:
                    System.out.println("Ukendt valg, prøv igen");
                    adskiller();
                    menuOverAnsatte();
                    break;
            }

        }
        catch (InputMismatchException e)
        {
            System.out.println("Ukendt valg, prøv igen");
            adskiller();
            menuOverAnsatte();
        }
    }

    public static void menuOverBørn()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valgmuligheder");
        System.out.println("1. Vis Børn");
        System.out.println("2. Opret Børn");
        System.out.println("3. Tilbage");
        System.out.println("0. Afslut program");

        try {

            int menuOverAnsatteValg = scanner.nextInt();

            switch (menuOverAnsatteValg) {
                case 1:
                    adskiller();
                    System.out.println("Viser Børn...");
                    displayBørn();
                    break;
                case 2:
                    adskiller();
                    System.out.println("Opret barn");
                    opretBørn();
                    break;
                case 3:
                    menu();
                    adskiller();
                    break;
                case 0:
                    System.out.println("Afslutter programmet...");
                    adskiller();
                    break;
                default:
                    System.out.println("Ukendt valg, prøv igen");
                    adskiller();
                    menuOverAnsatte();
                    break;
            }

        }
        catch (InputMismatchException e)
        {
            System.out.println("Ukendt valg, prøv igen");
            adskiller();
            menuOverAnsatte();
        }
    }

    public static void displayBørn()
    {

    }

    public static void opretBørn()
    {

        String navn = "tom";
        String efterNavn = "tom";
        String addresse = "tom";
        int alder = 0;
        Parent[] parents = new Parent[2];

        while(true) {
            System.out.println("Vælg hvilken en af dataerne at redigerer, udfyld de tomme felter");

            //ArrayList<String> parents = new ArrayList<>();



            System.out.println("1. navn = " + navn);
            System.out.println("2. lastName = " + efterNavn);
            System.out.println("3. adress = " + addresse);
            System.out.println("4. year = " + alder);
            System.out.println("5. Opret!");
            System.out.println("0. Tilbage");

            Scanner scanner = new Scanner(System.in);

            try {

                switch (scanner.nextInt()) {
                    case 1:
                        adskiller();
                        navn = scanner.next();
                        break;
                    case 2:
                        adskiller();
                        efterNavn = scanner.next();
                        break;
                    case 3:
                        adskiller();
                        addresse = scanner.next();
                        break;
                    case 4:
                        adskiller();
                        alder = scanner.nextInt();
                        break;
                    case 5:
                        FileHandler fileHandler = new FileHandler();
                        Child child = new Child(navn, efterNavn, addresse, alder, parents);

                        fileHandler.WriteToNewFile(child, "Child");
                        adskiller();

                    case 0:
                        menuOverBørn();
                        adskiller();
                        break;
                    default:
                        System.out.println("Ukendt valg, prøv igen");
                        adskiller();
                        opretBørn();
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ukendt valg, prøv igen");
                adskiller();
                opretBørn();
            }

        }
    }

    public static void displayAnsatte()
    {
        // Her skal man kunne se alle ansatte
    }

    public static void redigerAnsatte()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valgmuligheder");
        System.out.println("1. Fjern ansat");
        System.out.println("2. Opret ansat");
        System.out.println("3. Rediger ansat");
        System.out.println("4. Tilbage");
        System.out.println("0. Afslut program");

        try {

            int menuOverAnsatteValg = scanner.nextInt();

            switch (menuOverAnsatteValg) {
                case 1:
                    System.out.println("Viser ansatte...");
                    displayAnsatte();
                    break;
                case 2:
                    System.out.println("Redigerer ansatte...");
                    redigerAnsatte();
                    break;
                case 3:
                    menu();
                    break;
                case 4:
                    menuOverAnsatte();
                    adskiller();
                    break;
                case 0:
                    System.out.println("Afslutter programmet...");
                    adskiller();
                    break;
                default:
                    System.out.println("Ukendt valg, prøv igen");
                    adskiller();
                    menuOverAnsatte();
                    break;
            }

        }
        catch (InputMismatchException e)
        {
            System.out.println("Ukendt valg, prøv igen");
            adskiller();
            menuOverAnsatte();
        }
    }

    public static void Edit()
    {

    }

    public static void DisplayUserOptions()
    {

    }

    public static void adskiller()
    {
        System.out.println("\n --------------------");
    }

}