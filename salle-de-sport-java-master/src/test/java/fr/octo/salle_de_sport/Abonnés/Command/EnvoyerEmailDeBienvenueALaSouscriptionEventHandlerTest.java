package fr.octo.salle_de_sport.Abonnés.Command;

import fr.octo.salle_de_sport.Abonnements.Domain.*;
import fr.octo.salle_de_sport.Abonnés.Domain.*;
import fr.octo.salle_de_sport.Formules.Domain.Formule;
import fr.octo.salle_de_sport.Formules.Domain.Prix;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class EnvoyerEmailDeBienvenueALaSouscriptionEventHandlerTest {

    @Test
    public void handle() throws AbonnementRepositoryException, AbonnéRepositoryException {
        var abonnéId = new AbonnéId();
        var abonnementId = new AbonnementId();

        var formule = Formule.nouvelleALAnnée(new Prix(500));

        var abonné = Abonné.nouveau(abonnéId, "bob@octo.com", "Bob");
        var abonnéRepository = mock(AbonnéRepository.class);
        when(abonnéRepository.get(abonnéId)).thenReturn(abonné);

        var abonnement = new Abonnement(
            abonnementId,
            abonné,
            formule,
            new MaDate()
        );
        var abonnementRepository = mock(AbonnementRepository.class);
        when(abonnementRepository.get(abonnementId)).thenReturn(abonnement);

        var mailer = mock(Mailer.class);

        var tested = new EnvoyerEmailDeBienvenueALaSouscriptionEventHandler(
            abonnéRepository,
            abonnementRepository,
            mailer
        );

        tested.handle(
            new AbonnementSouscrit(
                abonné.id(),
                formule.id(),
                abonnement.id()
            )
        );

        verify(mailer).sendEmail(anyString(), anyString());
    }
}
