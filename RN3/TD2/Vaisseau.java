// définition d’une classe pour un vaisseau
public class Vaisseau {
    private int nbMaxPassagers; // Equipage + passager
    private String catégorie; // Classe du vaisseau
    private double altitude; // altitude effective de vol
    // Constructeurs -------------------------------------

    /**
     * Constructeur champ à champ
     */
    public Vaisseau(String cat, int nbPass, double alt) {
        this.setNbMaxPassagers(nbPass);
        this.setCatégorie(cat);
        this.altitude = alt;
    }

    public Vaisseau (Vaisseau vais){
        this.nbMaxPassagers = vais.nbMaxPassagers ;
        this.catégorie = vais.catégorie ;
        this.altitude = vais.altitude ;
    }

    // Accesseur Getter/Setter --------------------------
    /**
     * Fixe la catégorie du vaisseau
     * 
     * @param cat nom de la catégorie
     */
    public void setCatégorie(String cat) {
        this.catégorie = cat;
    }

    /**
     * Retourne la catégorie du vaisseau
     * 
     * @return la catégorie du vaisseau
     */
    public String getCatégorie() {
        return this.catégorie;
    }

    /**
     * Fixe la capacité en nombre de passagers du vaisseau
     * 
     * @param n nombre maximal de passagers
     */
    public void setNbMaxPassagers(int n) {
        this.nbMaxPassagers = n;
    }

    /**
     * Retourne la capacité en nombre de passagers du vaisseau
     * 
     * @return nombre maximal de passagers
     */
    public int getNbMaxPassagers() {
        return this.nbMaxPassagers;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String toString() {
        return "Vaisseau de type " + this.getCatégorie() + " pouvant transporter " + this.getNbMaxPassagers()
                + " et volant à " + this.getAltitude() + "m";
    }
}