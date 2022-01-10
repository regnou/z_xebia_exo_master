package fr.octo.salle_de_sport.Formules.Command;

import fr.octo.salle_de_sport.Formules.Domain.DuréeFormule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;

final class CréerUneNouvelleFormuleCommand {

    final Prix prixDeBase;
    final DuréeFormule duréeFormule;

    CréerUneNouvelleFormuleCommand(final Prix prixDeBase, final DuréeFormule duréeFormule) {
        this.prixDeBase = prixDeBase;
        this.duréeFormule = duréeFormule;
    }
}
