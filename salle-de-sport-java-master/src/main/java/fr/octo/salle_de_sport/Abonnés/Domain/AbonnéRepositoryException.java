package fr.octo.salle_de_sport.Abonnés.Domain;

public final class AbonnéRepositoryException extends Throwable {

    private AbonnéRepositoryException(String message) {
        super(message);
    }

    public static AbonnéRepositoryException introuvable(final AbonnéId abonnéId) {
        return new AbonnéRepositoryException("Abonné ["+ abonnéId +"] introuvable.");
    }
}
