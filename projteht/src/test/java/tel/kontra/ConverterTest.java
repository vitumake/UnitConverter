package tel.kontra;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterTest {

    @Test
    void testFarToCel() {
        assertEquals(0, Converter.FarToCel(32), 0.001); // freezing point
        assertEquals(100, Converter.FarToCel(212), 0.001); // boiling point
        assertEquals(-17.7778, Converter.FarToCel(0), 0.001); // zero degrees Fahrenheit
    }

    @Test
    void testKelToCel() {
        assertEquals(-273.15, Converter.KelToCel(0), 0.001); // absolute zero
        assertEquals(0, Converter.KelToCel(273.15), 0.001); // freezing point
        assertEquals(100, Converter.KelToCel(373.15), 0.001); // boiling point
    }

    @Test
    void testCelToFar() {
        assertEquals(32, Converter.CelToFar(0), 0.001); // freezing point
        assertEquals(212, Converter.CelToFar(100), 0.001); // boiling point
    }

    @Test
    void testCelToKel() {
        assertEquals(273.15, Converter.CelToKel(0), 0.001); // freezing point
        assertEquals(373.15, Converter.CelToKel(100), 0.001); // boiling point
    }

    @Test
    void testFarToKel() {
        assertEquals(255.372, Converter.FarToKel(0), 0.001); // zero degrees Fahrenheit
        assertEquals(273.15, Converter.FarToKel(32), 0.001); // freezing point
        assertEquals(373.15, Converter.FarToKel(212), 0.001); // boiling point
    }
}