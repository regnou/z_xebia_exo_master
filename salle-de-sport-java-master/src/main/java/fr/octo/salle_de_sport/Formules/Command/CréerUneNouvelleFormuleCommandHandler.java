package fr.octo.salle_de_sport.Formules.Command;

import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleCréée;
import fr.octo.salle_de_sport.Formules.Domain.FormuleRepository;

final class CréerUneNouvelleFormuleCommandHandler {

    private final FormuleRepository formuleRepository;

    CréerUneNouvelleFormuleCommandHandler(FormuleRepository formuleRepository) {
        this.formuleRepository = formuleRepository;
    }

    FormuleCréée handle(CréerUneNouvelleFormuleCommand command) {

        var formule = new Formule(
            command.prixDeBase,
            command.duréeFormule
        );

        formuleRepository.store(formule);

        return new FormuleCréée(formule.id());
    }
}
