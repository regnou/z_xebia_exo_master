package fr.octo.salle_de_sport.Formules.Domain;

public final class FormuleRepositoryException extends Exception {

    private FormuleRepositoryException(String message) {
        super(message);
    }

    public static FormuleRepositoryException introuvable(final FormuleId formuleId) {
        return new FormuleRepositoryException("Formule ["+formuleId+"] introuvable.");
    }
}
