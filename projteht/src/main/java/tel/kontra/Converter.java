package tel.kontra;

public class Converter {
    
    public static double FarToCel(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double KelToCel(double kelvin) {
        return kelvin - 273.15;
    }

    public static double CelToFar(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static double CelToKel(double celsius) {
        return celsius + 273.15;
    }

    public static double FarToKel(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }
}
