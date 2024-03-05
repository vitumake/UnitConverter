package tel.kontra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Boolean isRunning = true;

        while (isRunning) {
            
            // Print menu
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Kelvin to Celsius");
            System.out.println("3. Celsius to Fahrenheit");
            System.out.println("4. Celsius to Kelvin");
            System.out.println("5. Fahrenheit to Kelvin");
            System.out.println("0. Exit");

            // Get user input
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            // Process user input
            switch (option) {
                case 1:
                    System.out.print("Enter Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    System.out.println("Celsius: " + Converter.FarToCel(fahrenheit));
                    break;
                case 2:
                    System.out.print("Enter Kelvin: ");
                    double kelvin = scanner.nextDouble();
                    System.out.println("Celsius: " + Converter.KelToCel(kelvin));
                    break;
                case 3:
                    System.out.print("Enter Celsius: ");
                    double celsius = scanner.nextDouble();
                    System.out.println("Fahrenheit: " + Converter.CelToFar(celsius));
                    break;
                case 4:
                    System.out.print("Enter Celsius: ");
                    celsius = scanner.nextDouble();
                    System.out.println("Kelvin: " + Converter.CelToKel(celsius));
                    break;
                case 5:
                    System.out.print("Enter Fahrenheit: ");
                    fahrenheit = scanner.nextDouble();
                    System.out.println("Kelvin: " + Converter.FarToKel(fahrenheit));
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
}