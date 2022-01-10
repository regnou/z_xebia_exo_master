package fr.octo.salle_de_sport.Abonnés.Domain;

import java.util.Objects;
import java.util.UUID;

public final class AbonnéId {

    private final String id;

    public AbonnéId() {
        this.id = UUID.randomUUID().toString();
    }

    public AbonnéId(String id) {
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
        AbonnéId that = (AbonnéId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
