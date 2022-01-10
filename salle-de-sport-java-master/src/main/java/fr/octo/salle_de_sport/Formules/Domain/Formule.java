package fr.octo.salle_de_sport.Formules.Domain;

public final class Formule {

    private final FormuleId formuleId;
    private Prix prixDeBase;
    private final Integer duréeEnMois;

    public Formule(Prix prixDeBase, DuréeFormule duréeEnMois) {
        this(
            new FormuleId(),
            prixDeBase,
            duréeEnMois
        );
    }

    private Formule(FormuleId formuleId, Prix prixDeBase, DuréeFormule duréeEnMois) {
        this.formuleId = formuleId;
        this.prixDeBase = prixDeBase;
        this.duréeEnMois = duréeEnMois.nbMois();
    }

    public static Formule nouvelleAuMois(Prix prixDeBase) {
        return new Formule(prixDeBase, DuréeFormule.MOIS);
    }

    public static Formule nouvelleAuMois(FormuleId formuleId, Prix prixDeBase) {
        return new Formule(formuleId, prixDeBase, DuréeFormule.MOIS);
    }

    public static Formule nouvelleALAnnée(Prix prixDeBase) {
        return new Formule(prixDeBase, DuréeFormule.ANNEE);
    }

    public static Formule nouvelleALAnnée(FormuleId formuleId, Prix prixDeBase) {
        return new Formule(formuleId, prixDeBase, DuréeFormule.ANNEE);
    }

    public FormuleId id() {
        return formuleId;
    }

    public Prix prixDeBase() {
        return prixDeBase;
    }

    public void changeDePrix(final Prix nouveauPrix) {
        prixDeBase = nouveauPrix;
    }

    public Integer duréeEnMois() {
        return duréeEnMois;
    }

    public Boolean estALannée() {
        return DuréeFormule.ANNEE.nbMois().equals(duréeEnMois);
    }

    public String description() {
        return "Formule "+duréeEnMois+" mois à "+prixDeBase+" euros";
    }
}
