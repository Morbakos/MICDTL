/**
 * Decrit un Vaisseau
 * 
 * @version 1.1
 * @author Guillaume Santini
 */

// definition d’une classe pour un vaisseau
public class Vaisseau {
	private int nbMaxPassagers; // Equipage + passager
	private String categorie; // Classe du vaisseau
	private double altitude; // altitude effective de vol
	private final int NUMERO_DE_CHASSIS; // Numero de châssis inchangeable
	private static int prochainNumeroDeChassis;

	// Constructeurs -------------------------------------
	/**
	 * Constructeur Champ à Champ : Initialise un nouveau Vaisseau
	 * 
	 * @param cat    la categorie du vaisseau
	 * @param nbPAss le nombre de passagers que peut emporter la vaisseau
	 * @param alt    l'altitude de vol du vaisseau
	 */
	public Vaisseau(String cat, int nbPass, double alt) {
		this.setCategorie(cat);
		this.setNbMaxPassagers(nbPass);
		this.setAltitude(alt);
		this.NUMERO_DE_CHASSIS = this.getProchainNumeroDeChassis();
		this.incrementeProchainNumeroDeChâssis();
	}

	/**
	 * Constructeur par defaut : Initialise un nouveau vaisseau ayant pour categorie
	 * "Vaisseau Leger" admettant 7 passagers et volant à une altitude de 0 mètres.
	 */
	public Vaisseau() {
		this("Vaisseau leger", 7, 0.);
	}

	/**
	 * Constreur par copie
	 * 
	 * @param v le modèle de Vaisseau
	 */
	public Vaisseau(Vaisseau v) {
		this.nbMaxPassagers = v.nbMaxPassagers;
		this.categorie = v.categorie;
		this.altitude = v.altitude;
		this.NUMERO_DE_CHASSIS = this.getProchainNumeroDeChassis();
		this.incrementeProchainNumeroDeChâssis();
	}

	// Accesseur Getter/Setter --------------------------
	/**
	 * Fixe la categorie du vaisseau
	 * 
	 * @param cat nom de la categorie
	 */
	public void setCategorie(String cat) {
		this.categorie = cat;
	}

	/**
	 * Retourne la categorie du vaisseau
	 * 
	 * @return la categorie du vaisseau
	 */
	public String getCategorie() {
		return this.categorie;
	}

	/**
	 * Fixe la capacite en nombre de passagers du vaisseau
	 * 
	 * @param n nombre maximal de passagers
	 */
	public void setNbMaxPassagers(int n) {
		this.nbMaxPassagers = n;
	}

	/**
	 * Retourne la capacite en nombre de passagers du vaisseau
	 * 
	 * @return nombre maximal de passagers
	 */
	public int getNbMaxPassagers() {
		return this.nbMaxPassagers;
	}

	/**
	 * Fixe l'altitude de vol du vaisseau
	 * 
	 * @param alt altitude de vol
	 */
	public void setAltitude(double alt) {
		this.altitude = alt;
	}

	/**
	 * Retourne le nombre de passagers du vaisseau
	 * 
	 * @return l'altitude du vaisseau
	 */
	public double getAltitude() {
		return this.altitude;
	}

	/**
	 * Affiche le depart
	 */
	public void depart() {
		System.out.println("Je parts.");
	}

	/**
	 * Incremente le numero de châssis
	 */
	public void incrementeProchainNumeroDeChâssis() {
		Vaisseau.prochainNumeroDeChassis++;
	}

	/**
	 * Retourne le prochain numero de châssis
	 */
	public int getProchainNumeroDeChassis() {
		return Vaisseau.prochainNumeroDeChassis;
	}

	/**
	 * Retourne le numero de châssis
	 */
	public int getNumeroChassis() {
		return this.NUMERO_DE_CHASSIS;
	}

	// -----------------------------------------------------------
	// Redefinition de methodes

	/**
	 * Affichage du contenu de l’objet
	 * 
	 * @return chaîne de caractère decrivant l'etat courant de l'instance
	 */
	public String toString() {
		String desc = "\n\n";
		desc += "                  /--------- Vaisseau\n";
		desc += "     -------------\n";
		desc += "  /  Capacite  = " + this.getNbMaxPassagers() + " passagers\n";
		desc += "<    Altitude  = " + this.getAltitude() + " mètres\n";
		desc += "  \\  Categorie = " + this.getCategorie() + "\n";
		desc += "    \\  Numero de châssis = " + this.getNumeroChassis() + "\n";
		desc += "      -------------\n";
		desc += "                   \\--------- Vaisseau\n";
		return desc;
	}

}
