package fr.octo.salle_de_sport.Abonnements.Domain;

import java.time.Period;

final class Période {

    private static final String AU = " au ";

    private final MaDate dateDeDébut;
    private final MaDate dateDeFin;

    Période(MaDate dateDeDébut, Integer nbMois) {
        this.dateDeDébut = dateDeDébut;
        this.dateDeFin = dateDeDébut.plusXMois(nbMois).jourDAvant();
    }

    Période(String période) {
        this(
            new MaDate(période.split(AU)[0]),
            new MaDate(période.split(AU)[1])
        );
    }

    private Période(MaDate dateDeDébut, MaDate dateDeFin) {
        this.dateDeDébut = dateDeDébut;
        this.dateDeFin = dateDeFin;
    }

    Boolean contient(final MaDate date) {
        return date.aprèsOuEgale(dateDeDébut) && date.avant(dateDeFin);
    }

    Boolean avantLaDate(final MaDate date) {
        return date.après(dateDeFin);
    }

    Période suivante() {
        var nbMoisPériodeCourante = Period.between(dateDeDébut.toLocalDate(), dateDeFin.jourSuivant().toLocalDate()).getMonths();

        return new Période(
            dateDeFin.jourSuivant(),
            nbMoisPériodeCourante
        );
    }

    @Override
    public String toString() {
        return dateDeDébut + AU + dateDeFin;
    }
}
