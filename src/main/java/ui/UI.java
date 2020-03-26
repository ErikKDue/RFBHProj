package ui;

import businesslayer.BusinessLayer;
import businesslayer.Child;
import businesslayer.Employee;
import businesslayer.Parent;

import java.io.IOException;
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
                    System.out.println("Opret ansat");
                    opretAnsatte();
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

        } catch (InputMismatchException | IOException e) {
            System.out.println("Ukendt valg, prøv igen");
            adskiller();
            menuOverAnsatte();
        }
    }

    public static void displayBørn() throws IOException {
        BusinessLayer businessLayer = new BusinessLayer();
        System.out.println(businessLayer.displayChildren());
        adskiller();
        menuOverBørn();
    }

    public static void opretBørn()
    {

        String navn = "tom";
        String efterNavn = "tom";
        String addresse = "tom";
        int alder = 0;
        Parent[] parents = new Parent[2];

        while(true) {
            System.out.println("Vælg hvilken en af dataerne at redigere, udfyld de tomme felter og tryk derefter på opret");

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
                        BusinessLayer businessLayer = new BusinessLayer();
                        Child child = new Child(navn, efterNavn, addresse, alder, parents);

                        businessLayer.saveIStorageObject(child);
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

            } catch (InputMismatchException | IOException e) {
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

    public static void opretAnsatte()
    {

        String navn = "tom";
        String efterNavn = "tom";
        String addresse = "tom";
        boolean adminRight = false;
        Parent[] parents = new Parent[2];

        while(true) {
            System.out.println("Vælg hvilken en af dataerne at redigerer, udfyld de tomme felter og tryk derefter på opret");

            //ArrayList<String> parents = new ArrayList<>();



            System.out.println("1. navn = " + navn);
            System.out.println("2. lastName = " + efterNavn);
            System.out.println("3. adress = " + addresse);
            System.out.println("4. Admin rettigheder = " + adminRight);
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
                        System.out.println("Tryk på 1 for at give admin rettigheder, og 2 for ingen admin rettigheder");

                            try
                            {
                                switch (scanner.nextInt()) {
                                    case 1:
                                        adminRight = true;
                                        break;
                                    case 2:
                                        adminRight = false;
                                        break;
                                    default:
                                        System.out.println("Ukendt valg, prøv igen");
                                        break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Ukendt valg, prøv igen");
                                adskiller();
                            }

                    case 5:
                        BusinessLayer businessLayer = new BusinessLayer();
                        Employee employee = new Employee(navn, efterNavn, addresse, adminRight, new ArrayList<String>());

                        businessLayer.saveIStorageObject(employee);
                        adskiller();

                    case 0:
                        adskiller();
                        break;
                    default:
                        System.out.println("Ukendt valg, prøv igen");
                        adskiller();
                        break;
                }

            } catch (InputMismatchException | IOException e) {
                System.out.println("Ukendt valg, prøv igen");
                adskiller();
            }

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