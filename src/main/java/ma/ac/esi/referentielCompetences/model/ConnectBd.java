package ma.ac.esi.referentielCompetences.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectBd {
    // URL de connexion à la base de données MySQL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/competency_framework";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // Méthode pour récupérer un objet User en connaissant son login et son password
    public User findUser(String login, String password) {
        User user = null;

        try {
            // Chargement du driver JDBC
            Class.forName("com.mysql.jdbc.Driver");

            // Établissement de la connexion
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Requête SQL pour récupérer un utilisateur par login et mot de passe
            String query = "SELECT * FROM users WHERE login=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            // Exécution de la requête
            ResultSet resultSet = preparedStatement.executeQuery();

            // Vérification si un utilisateur a été trouvé
            if (resultSet.next()) {
                user = new User(resultSet.getString("login"), resultSet.getString("password"));
            }

            // Fermeture des ressources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // À remplacer par une gestion appropriée des exceptions
        }

        return user;
    }
}
