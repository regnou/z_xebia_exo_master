package fr.octo.salle_de_sport.Abonnés.Domain;

public interface Mailer {

    void sendEmail(String email, String message);
}
