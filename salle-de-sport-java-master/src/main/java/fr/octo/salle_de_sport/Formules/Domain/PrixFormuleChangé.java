package fr.octo.salle_de_sport.Formules.Domain;

public final class PrixFormuleChangĂ© {

    public final FormuleId formuleId;
    public final Prix ancienPrix;
    public final Prix nouveauPrix;

    public PrixFormuleChangĂ©(final FormuleId formuleId, final Prix ancienPrix, final Prix nouveauPrix) {
        this.formuleId = formuleId;
        this.ancienPrix = ancienPrix;
        this.nouveauPrix = nouveauPrix;
    }
}
