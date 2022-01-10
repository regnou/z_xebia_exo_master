package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.MaDate;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéId;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;

final class SouscrireAUnAbonnementCommand {

    final AbonnéId abonnéId;
    final FormuleId formuleId;
    final MaDate dateDeDébut;

    SouscrireAUnAbonnementCommand(final AbonnéId abonnéId, final FormuleId formuleId, final MaDate dateDeDébut) {
        this.abonnéId = abonnéId;
        this.formuleId = formuleId;
        this.dateDeDébut = dateDeDébut;
    }
}
