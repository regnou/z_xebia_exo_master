package fr.octo.salle_de_sport.Abonnements.Domain;

import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéId;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;

public final class AbonnementSouscrit {

    public final AbonnéId abonnéId;
    public final FormuleId formuleId;
    public final AbonnementId abonnementId;

    public AbonnementSouscrit(final AbonnéId abonnéId, final FormuleId formuleId, final AbonnementId abonnementId) {
        this.abonnéId = abonnéId;
        this.formuleId = formuleId;
        this.abonnementId = abonnementId;
    }
}
