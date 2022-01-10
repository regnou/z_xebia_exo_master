package fr.octo.salle_de_sport.Abonnements.Domain;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class MaDateTest {

    @Test
    public void fromString() {
        var tested = new MaDate("2018-06-16");

        assertEquals("2018-06-16", tested.toString());
    }

    @Test
    public void aprèsOuEgale() {
        var tested = new MaDate("2018-06-15");

        assertTrue(tested.aprèsOuEgale(new MaDate("2018-06-15")));
    }

    @Test
    public void avant() {
        var tested = new MaDate("2018-06-16");

        assertTrue(tested.avant(new MaDate("2018-06-17")));
    }

    @Test
    public void plusXMois() {
        var tested = new MaDate("2018-06-16");

        assertEquals("2018-09-16", tested.plusXMois(3).toString());
    }

    @Test
    public void jourDAvant() {
        var tested = new MaDate("2018-06-01");

        assertEquals("2018-05-31", tested.jourDAvant().toString());
    }

    @Test
    public void jourSuivant() {
        var tested = new MaDate("2018-06-16");

        assertEquals("2018-06-17", tested.jourSuivant().toString());
    }
}
