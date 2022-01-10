package fr.octo.salle_de_sport.Formules.Domain;

import fr.octo.salle_de_sport.Abonnements.Domain.Réduction;

import java.util.Objects;

public final class Prix {

    private final Double montant;

    public Prix(Double montant) {
        this.montant = montant;
    }

    public Prix(Integer montant) {
        this.montant = montant.doubleValue();
    }

    public Prix aprèsRéduction(final Réduction réduction) {
        return new Prix(montant * (1 - réduction.taux()));
    }

    @Override
    public String toString() {
        return String.valueOf(montant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prix prix = (Prix) o;
        return Objects.equals(montant, prix.montant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(montant);
    }
}
