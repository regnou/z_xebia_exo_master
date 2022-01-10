package fr.octo.salle_de_sport.Formules.Infrastructure.Database;

import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleId;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepository;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepositoryException;

import java.util.ArrayList;
import java.util.Collection;

public final class FormuleInMemoryRepository implements FormuleRepository {

    private final Collection<Formule> formules = new ArrayList<>();

    @Override
    public void store(Formule formule) {
        formules.add(formule);
    }

    @Override
    public Formule get(FormuleId formuleId) throws FormuleRepositoryException {
        for (Formule formule : formules) {
            if (formule.id().equals(formuleId)) {
                return formule;
            }
        }

        throw FormuleRepositoryException.introuvable(formuleId);
    }
}
