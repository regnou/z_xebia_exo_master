package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbonnementTest {

    @Test
    public void prix_de_base_pour_une_souscription_d_un_mois() {
        var abonnementSansRéduc = new Abonnement(
            Abonné.nouveau("bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(new Prix(300)),
            cinqJuin()
        );

        assertEquals(new Prix(300), abonnementSansRéduc.prix());
    }

    @Test
    public void moins_30_pourcent_pour_une_souscription_à_l_année() {
        var abonnementAvecRéducAnnée = new Abonnement(
            Abonné.nouveau("bob@octo.com", "Bob"),
            Formule.nouvelleALAnnée(new Prix(100)),
            cinqJuin()
        );

        assertEquals(new Prix(70), abonnementAvecRéducAnnée.prix());
    }

    @Test
    public void moins_20_pourcent_pour_la_souscription_d_un_étudiant() {
        var abonnementEtudiantAuMois = new Abonnement(
            Abonné.étudiant("bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(new Prix(100)),
            cinqJuin()
        );
        assertEquals(new Prix(80), abonnementEtudiantAuMois.prix());

        var abonnementEtudiantAnnée = new Abonnement(
            Abonné.étudiant("bob@octo.com", "Bob"),
            Formule.nouvelleALAnnée(new Prix(100)),
            cinqJuin()
        );
        assertEquals(new Prix(50), abonnementEtudiantAnnée.prix());
    }

    @Test
    public void un_abonnement_peut_être_en_cours() {
        var abonnementEnCours = new Abonnement(
            Abonné.nouveau("bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(new Prix(100)),
            cinqJuin()
        );

        var dateCourantJuin = new MaDate("2018-06-19");

        assertTrue(abonnementEnCours.estEnCours(dateCourantJuin));
    }

    @Test
    public void permet_de_déterminer_s_il_sera_fini_à_une_date() {
        var abonnementFiniFinJuin = new Abonnement(
            Abonné.nouveau("bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(new Prix(100)),
            cinqJuin()
        );

        assertFalse(abonnementFiniFinJuin.seraFiniLe(new MaDate("2018-07-04")));
        assertTrue(abonnementFiniFinJuin.seraFiniLe(new MaDate("2018-07-05")));
    }

    @Test
    public void peut_être_renouvellé() {
        var abonnement = new Abonnement(
            Abonné.nouveau("bob@octo.com", "Bob"),
            Formule.nouvelleAuMois(new Prix(100)),
            cinqJuin()
        );

        assertFalse(abonnement.seraFiniLe(new MaDate("2018-07-04")));
        assertTrue(abonnement.seraFiniLe(new MaDate("2018-07-05")));

        abonnement.renouveller();

        assertFalse(abonnement.seraFiniLe(new MaDate("2018-08-04")));
        assertTrue(abonnement.seraFiniLe(new MaDate("2018-08-05")));
    }

    private MaDate cinqJuin() {
        return new MaDate("2018-06-05");
    }
}
