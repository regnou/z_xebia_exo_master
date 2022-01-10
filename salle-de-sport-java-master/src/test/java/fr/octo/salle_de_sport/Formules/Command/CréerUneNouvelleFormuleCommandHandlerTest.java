package fr.octo.salle_de_sport.Formules.Command;

import fr.octo.salle_de_sport.Formules.Domain.DuréeFormule;
import fr.octo.salle_de_sport.Formules.Domain.FormuleCréée;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import fr.octo.salle_de_sport.Formules.Infrastructure.Database.FormuleInMemoryRepository;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CréerUneNouvelleFormuleCommandHandlerTest {

    @Test
    public void creer_une_nouvelle_formule() {

        var tested = new CréerUneNouvelleFormuleCommandHandler(
            new FormuleInMemoryRepository()
        );

        var formuleCréée = tested.handle(
            new CréerUneNouvelleFormuleCommand(
                new Prix(300),
                DuréeFormule.MOIS
            )
        );

        assertTrue(formuleCréée instanceof FormuleCréée);
    }
}
