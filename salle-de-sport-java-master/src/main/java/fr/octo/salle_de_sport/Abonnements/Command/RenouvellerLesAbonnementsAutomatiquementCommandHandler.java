package fr.octo.salle_de_sport.Abonnements.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.Abonnement;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementRepository;
import fr.octo.salle_de_sport.Abonnements.Domain.AbonnementsRenouvellésAutomatiquement;

final class RenouvellerLesAbonnementsAutomatiquementCommandHandler {

    private final AbonnementRepository abonnementRepository;

    RenouvellerLesAbonnementsAutomatiquementCommandHandler(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    AbonnementsRenouvellésAutomatiquement handle(final RenouvellerLesAbonnementsAutomatiquementCommand command) {

        var abonnementsFinisAPartirDe = abonnementRepository.abonnementsFinisAPartirDe(command.àPartirDe);

        for (Abonnement abonnement : abonnementsFinisAPartirDe) {
            abonnement.renouveller();
        }

        abonnementRepository.storeAll(abonnementsFinisAPartirDe);

        return new AbonnementsRenouvellésAutomatiquement();
    }
}
