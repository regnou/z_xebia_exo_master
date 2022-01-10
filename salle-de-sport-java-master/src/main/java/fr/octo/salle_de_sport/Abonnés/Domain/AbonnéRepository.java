package fr.octo.salle_de_sport.Abonnés.Domain;

public interface AbonnéRepository {

    void store(Abonné abonné);

    Abonné get(AbonnéId abonnéId) throws AbonnéRepositoryException;
}
