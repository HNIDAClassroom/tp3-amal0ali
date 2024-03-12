package ma.ac.esi.referentielCompetences.controleur;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.ConnectBd;
import ma.ac.esi.referentielCompetences.model.User;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des paramètres du formulaire
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // Vérification des paramètres non nuls
        if (login != null && password != null) {
            // Appel de la classe du modèle pour vérifier si l'utilisateur existe
            ConnectBd connectBd = new ConnectBd();
            User user = connectBd.findUser(login, password);

            // Traitement du résultat
            if (user != null) {
                // Affichage du message de bienvenue
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head><title>Connexion réussie</title></head>");
                out.println("<body>");
                out.println("<h2>Bienvenue, " + user.getLogin() + "!</h2>");
                out.println("</body>");
                out.println("</html>");
            } else {
                // Affichage du message d'échec de connexion
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head><title>Échec de la connexion</title></head>");
                out.println("<body>");
                out.println("<h2>Identifiants incorrects. Veuillez réessayer.</h2>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            // Gestion du cas où les paramètres sont nuls
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Les paramètres ne doivent pas être nuls.");
        }
    }
}
