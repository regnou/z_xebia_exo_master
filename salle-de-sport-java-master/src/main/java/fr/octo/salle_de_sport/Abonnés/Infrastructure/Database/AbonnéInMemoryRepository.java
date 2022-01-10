package fr.octo.salle_de_sport.Abonnés.Infrastructure.Database;

import fr.octo.salle_de_sport.Abonnés.Domain.Abonné;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéId;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepository;
import fr.octo.salle_de_sport.Abonnés.Domain.AbonnéRepositoryException;

import java.util.ArrayList;
import java.util.Collection;

public final class AbonnéInMemoryRepository implements AbonnéRepository {

    private final Collection<Abonné> abonnés = new ArrayList<>();

    @Override
    public void store(Abonné abonné) {
        abonnés.add(abonné);
    }

    @Override
    public Abonné get(AbonnéId abonnéId) throws AbonnéRepositoryException {
        for (Abonné abonné : abonnés) {
            if (abonné.id().equals(abonnéId)) {
                return abonné;
            }
        }

        throw AbonnéRepositoryException.introuvable(abonnéId);
    }
}
