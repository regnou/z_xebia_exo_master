package fr.octo.salle_de_sport.Formules.Domain;

import java.util.Objects;
import java.util.UUID;

public final class FormuleId {

    private final String id;

    public FormuleId() {
        this.id = UUID.randomUUID().toString();
    }

    public FormuleId(String id) {
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
        FormuleId formuleId = (FormuleId) o;
        return Objects.equals(id, formuleId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
