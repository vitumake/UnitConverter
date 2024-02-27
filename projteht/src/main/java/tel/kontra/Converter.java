package tel.kontra;

public class Converter {
    
    public static double FarToCel(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double KelToCel(double kelvin) {
        return kelvin - 273.15;
    }
}
