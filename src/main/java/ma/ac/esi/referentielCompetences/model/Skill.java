package ma.ac.esi.referentielCompetences.model;

public class Skill {
    private int id;
    private String name;
    private String description;
    private String domain;
    private String level;

    public Skill() {
    }

    public Skill(String name, String description, String domain, String level) {
        this.name = name;
        this.description = description;
        this.domain = domain;
        this.level = level;
    }

    // Ajout du constructeur avec tous les champs
    public Skill(int id, String name, String description, String domain, String level) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.domain = domain;
        this.level = level;
    }

    // Getters et Setters pour tous les champs
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", domain='" + domain + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
