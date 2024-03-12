package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import ma.ac.esi.referentielCompetences.model.Skill;
import ma.ac.esi.referentielCompetences.model.SkillDAO; // Importez la classe SkillDAO
import java.util.List;

@WebServlet("/addSkillServlet")
public class AddSkillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddSkillServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SkillDAO skillDAO = new SkillDAO();
        List<Skill> skills = skillDAO.getAllSkills();

        // Ajouter la liste de compétences à la requête
        request.setAttribute("skills", skills);

        // Dispatcher vers la page JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("SkillCrud.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérez les paramètres du formulaire
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String domain = request.getParameter("domain");
        String level = request.getParameter("level");

        // Créez un objet Skill avec les paramètres récupérés
        Skill skill = new Skill(name, description, domain, level);

        // Créez une instance de SkillDAO
        SkillDAO skillDAO = new SkillDAO();

        // Ajoutez la compétence en utilisant la méthode addSkill
        boolean success = skillDAO.addSkill(skill);

        if (success) {
            // Si l'ajout réussit, mettez à jour la liste des compétences
            request.setAttribute("skills", skillDAO.getAllSkills());
            // Définissez un message de succès
            request.setAttribute("message", "La compétence a été ajoutée avec succès.");
        } else {
            // Si l'ajout échoue, définissez un message d'erreur
            request.setAttribute("erreur", "Erreur lors de l'ajout de la compétence.");
        }

        // Redirigez vers la page SkillCrud.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SkillCrud.jsp");
        dispatcher.forward(request, response);
    }

}
