package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Formules.Domain.Formule;

final class FormuleChoisie {

    final String descriptionFormule;

    FormuleChoisie(Formule formule) {
        this.descriptionFormule = formule.description();
    }
}
