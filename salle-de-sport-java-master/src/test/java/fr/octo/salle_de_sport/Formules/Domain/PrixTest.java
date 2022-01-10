package fr.octo.salle_de_sport.Formules.Domain;

import fr.octo.salle_de_sport.Abonnements.Domain.Réduction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PrixTest {

    @Test
    public void un_prix_a_un_montant() {

        var prix = new Prix(400);

        assertEquals("400.0", prix.toString());
    }

    @Test
    public void on_peut_appliquer_une_réduction() {

        var prix = new Prix(400);
        var réduction = new Réduction(0.25);

        var prixAprèsRéduction = prix.aprèsRéduction(réduction);

        assertEquals(new Prix(300), prixAprèsRéduction);
        assertNotEquals(prix, prixAprèsRéduction);
    }
}
