package fr.octo.salle_de_sport.Abonn√©s.Domain;

import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementId;

public final class EmailDeBienvenueALaSouscriptionEnvoy√© {

    public final String email;
    public final AbonnementId abonnementId;

    public EmailDeBienvenueALaSouscriptionEnvoy√©(final String email, final AbonnementId abonnementId) {
        this.email = email;
        this.abonnementId = abonnementId;
    }
}
