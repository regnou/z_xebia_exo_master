package fr.octo.salle_de_sport.Formules.Command;

import fr.octo.salle_de_sport.Formules.Domain.FormuleId;
import fr.octo.salle_de_sport.Formules.Domain.Prix;

final class ChangerLePrixDUneFormuleCommand {

    final FormuleId formuleId;
    final Prix nouveauPrix;

    ChangerLePrixDUneFormuleCommand(final FormuleId formuleId, final Prix nouveauPrix) {
        this.formuleId = formuleId;
        this.nouveauPrix = nouveauPrix;
    }
}
