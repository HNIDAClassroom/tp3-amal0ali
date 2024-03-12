package ma.ac.esi.referentielCompetences.model;

public class User {
    private String login;
    private String password;

    // Constructeur avec paramètres
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Getters et Setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
