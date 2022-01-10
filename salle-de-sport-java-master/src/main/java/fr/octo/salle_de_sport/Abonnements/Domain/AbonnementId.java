package fr.octo.salle_de_sport.Abonnements.Domain;

import java.util.Objects;
import java.util.UUID;

public final class AbonnementId {

    private final String id;

    public AbonnementId() {
        this.id = UUID.randomUUID().toString();
    }

    public AbonnementId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbonnementId that = (AbonnementId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
