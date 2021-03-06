package fr.octo.salle_de_sport.Formules.Command;

import fr.octo.salle_de_sport.Formules.Domain.FormuleRepository;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepositoryException;
import fr.octo.salle_de_sport.Formules.Domain.PrixFormuleChangĂ©;

final class ChangerLePrixDUneFormuleCommandHandler {

    private final FormuleRepository formuleRepository;

    ChangerLePrixDUneFormuleCommandHandler(FormuleRepository formuleRepository) {
        this.formuleRepository = formuleRepository;
    }

    PrixFormuleChangĂ© handle(final ChangerLePrixDUneFormuleCommand command) throws FormuleRepositoryException {

        var formule = formuleRepository.get(command.formuleId);

        var ancienPrix = formule.prixDeBase();

        formule.changeDePrix(command.nouveauPrix);

        formuleRepository.store(formule);

        return new PrixFormuleChangĂ©(
            formule.id(),
            ancienPrix,
            formule.prixDeBase()
        );
    }
}
