package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Formules.Domain.Formule;

public final class Réduction {

    static final Double REDUC_ETUDIANT = 0.2;
    static final Double REDUC_ANNEE = 0.3;

    private final Double taux;

    public Réduction(Double taux) {
        this.taux = taux;
    }

    Réduction(final Abonné abonné, final Formule formule) {
        var tauxCalculé = 0.0;

        if (abonné.estEtudiant()) {
            tauxCalculé += REDUC_ETUDIANT;
        }

        if (formule.estALannée()) {
            tauxCalculé += REDUC_ANNEE;
        }

        this.taux = tauxCalculé;
    }

    public Double taux() {
        return taux;
    }
}
