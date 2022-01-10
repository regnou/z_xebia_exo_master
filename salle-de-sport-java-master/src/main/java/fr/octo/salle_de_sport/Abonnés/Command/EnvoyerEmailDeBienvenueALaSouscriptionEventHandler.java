package fr.octo.salle_de_sport.Abonnés.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepositoryException;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementSouscrit;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepository;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepositoryException;
import fr.octo.salle_de_sport.Abonnés.Domain.EmailDeBienvenueALaSouscriptionEnvoyé;
import fr.octo.salle_de_sport.Abonnés.Domain.Mailer;

final class EnvoyerEmailDeBienvenueALaSouscriptionEventHandler {

    private final AbonnéRepository abonnéRepository;
    private final AbonnementRepository abonnementRepository;
    private final Mailer mailer;

    EnvoyerEmailDeBienvenueALaSouscriptionEventHandler(AbonnéRepository abonnéRepository, AbonnementRepository abonnementRepository, Mailer mailer) {
        this.abonnéRepository = abonnéRepository;
        this.abonnementRepository = abonnementRepository;
        this.mailer = mailer;
    }

    EmailDeBienvenueALaSouscriptionEnvoyé handle(final AbonnementSouscrit event) throws AbonnéRepositoryException, AbonnementRepositoryException {

        var abonné = abonnéRepository.get(event.abonnéId);
        var abonnement = abonnementRepository.get(event.abonnementId);

        mailer.sendEmail(
            abonné.email(),
            "Bienvenu(e) chez CraftGym "+ abonné.prénom()+", profite bien de ton abonnement "+abonnement.descriptionFormuleChoisie()+"."
        );

        return new EmailDeBienvenueALaSouscriptionEnvoyé(
            abonné.email(),
            abonnement.id()
        );
    }
}
