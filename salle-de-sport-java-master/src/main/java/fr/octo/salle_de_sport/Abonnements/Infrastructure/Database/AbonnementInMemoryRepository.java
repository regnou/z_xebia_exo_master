package fr.octo.salle_de_sport.Abonnements.Infrastructure.Database;

import fr.octo.salle_de_sport.Abonnements.Domain.*;

import java.util.ArrayList;
import java.util.Collection;

public final class AbonnementInMemoryRepository implements AbonnementRepository {

    private final Collection<Abonnement> abonnements = new ArrayList<>();

    @Override
    public void store(Abonnement abonnement) {
        abonnements.add(abonnement);
    }

    @Override
    public void storeAll(Collection<Abonnement> abonnements) {
        for (Abonnement abonnement : abonnements) {
            store(abonnement);
        }
    }

    @Override
    public Abonnement get(AbonnementId abonnementId) throws AbonnementRepositoryException {

        for (Abonnement abonnement : abonnements) {
            if (abonnement.id().equals(abonnementId)) {
                return abonnement;
            }
        }

        throw AbonnementRepositoryException.introuvable(abonnementId);
    }

    @Override
    public Collection<Abonnement> abonnementsEnCours(MaDate date) {

        Collection<Abonnement> abonnementsEnCours = new ArrayList<>();

        for (Abonnement abonnement : abonnements) {
            if (abonnement.estEnCours(date)) {
                abonnementsEnCours.add(abonnement);
            }
        }

        return abonnementsEnCours;
    }

    @Override
    public Collection<Abonnement> abonnementsFinisAPartirDe(MaDate date) {

        Collection<Abonnement> abonnementsFinisAPartirDe = new ArrayList<>();

        for (Abonnement abonnement : abonnements) {
            if (abonnement.seraFiniLe(date)) {
                abonnementsFinisAPartirDe.add(abonnement);
            }
        }

        return abonnementsFinisAPartirDe;
    }
}
