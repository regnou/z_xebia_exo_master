package fr.octo.salle_de_sport.Abonnements.Domain;

public final class AbonnementRepositoryException extends Throwable {

    private AbonnementRepositoryException(String message) {
        super(message);
    }

    public static AbonnementRepositoryException introuvable(final AbonnementId abonnementId) {
        return new AbonnementRepositoryException("Abonnement ["+abonnementId+"] introuvable.");
    }
}
