package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;

import java.util.ArrayList;
import java.util.List;

public final class Abonnement {

    private final AbonnementId id;
    private final FormuleChoisie formuleChoisie;
    private final Prix prix;
    private final List<Période> périodes = new ArrayList<>();

    public Abonnement(Abonné abonné, Formule formule, MaDate dateDeDébut) {
        this(
            new AbonnementId(),
            abonné,
            formule,
            dateDeDébut
        );
    }

    public Abonnement(final AbonnementId abonnementId, final Abonné abonné, final Formule formule, final MaDate dateDeDébut) {

        this.id = abonnementId;

        this.formuleChoisie = new FormuleChoisie(formule);

        var réduction = new Réduction(abonné, formule);
        this.prix = formule.prixDeBase().aprèsRéduction(réduction);

        this.périodes.add(
            new Période(dateDeDébut, formule.duréeEnMois())
        );
    }

    public AbonnementId id() {
        return id;
    }

    public String descriptionFormuleChoisie() {
        return formuleChoisie.descriptionFormule;
    }

    Prix prix() {
        return prix;
    }

    public Double restantDu() {
        return Double.valueOf(prix.toString());
    }

    private Période dernièrePériode() {
        return périodes.get(périodes.size() - 1);
    }

    public Boolean estEnCours(final MaDate date) {
        return dernièrePériode().contient(date);
    }

    public Boolean seraFiniLe(final MaDate date) {
        return dernièrePériode().avantLaDate(date);
    }

    public void renouveller() {
        périodes.add(
            dernièrePériode().suivante()
        );
    }
}
