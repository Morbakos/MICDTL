/**
 * Décrit un Vaisseau
 * @version 1.1
 * @author Guillaume Santini
 */


// définition d’une classe pour un vaisseau
public class Vaisseau {
	private int nbMaxPassagers; 	// Equipage + passager
	private String catégorie; 	// Classe du vaisseau
	private double altitude; 		// altitude effective de vol
	private final int NUMERO_DE_CHASSIS ; // Numéro de châssis inchangeable
	private static int prochainNumeroDeChassis ;

	// Constructeurs -------------------------------------
	/**
	 * Constructeur Champ à Champ : Initialise un nouveau
	 * Vaisseau
	 * @param cat la catégorie du vaisseau
	 * @param nbPAss le nombre de passagers que peut emporter
	 *               la vaisseau
	 * @param alt l'altitude de vol du vaisseau
	 */
	public Vaisseau( String cat, int nbPass, double alt) {
		this.setCatégorie( cat) ;
		this.setNbMaxPassagers( nbPass) ;
		this.setAltitude( alt) ;
		this.NUMERO_DE_CHASSIS = this.getProchainNumeroDeChassis();
		this.incrémenteProchainNuméroDeChâssis();
	}
	
	/**
	 * Constructeur par défaut : Initialise un nouveau
	 * vaisseau ayant pour catégorie "Vaisseau Léger"
	 * admettant 7 passagers et volant à une altitude 
	 * de 0 mètres.
	 */
	public Vaisseau() {
		this( "Vaisseau léger", 7, 0.);
	}
	
	/**
	 * Constreur par copie
	 * @param v le modèle de Vaisseau
	 */
	public Vaisseau( Vaisseau v ) {
		this.nbMaxPassagers = v.nbMaxPassagers ;
		this.catégorie = v.catégorie ;
		this.altitude = v.altitude ;
		this.NUMERO_DE_CHASSIS = this.getProchainNumeroDeChassis();
		this.incrémenteProchainNuméroDeChâssis();
	}

	// Accesseur Getter/Setter  --------------------------
	/**
	 * Fixe la catégorie du vaisseau
	 * @param cat nom de la catégorie
	 */
	public void setCatégorie( String cat) {
		this.catégorie = cat;
	}

	/**
	 * Retourne la catégorie du vaisseau
	 * @return la catégorie du vaisseau
	*/
	public String getCatégorie() {
		return this.catégorie;
	}

	/**
	 * Fixe la capacité en nombre de passagers du vaisseau
	 * @param n nombre maximal de passagers 
	 */
	public void setNbMaxPassagers( int n) {
		this. nbMaxPassagers = n;
	}

	/**
	 * Retourne la capacité en nombre de passagers du vaisseau
	 * @return nombre maximal de passagers 
 	*/
	public int getNbMaxPassagers() {
		return this.nbMaxPassagers;
	}

	/**
	 * Fixe l'altitude de vol du vaisseau
	 * @param alt altitude de vol
	 */
	public void setAltitude( double alt) {
		this.altitude = alt;
	}

	/**
	 * Retourne le nombre de passagers du vaisseau
	 * @return l'altitude du vaisseau
	 */
	public double getAltitude() {
		return this.altitude;
	}

	/**
	 * Affiche le départ
	 */
	public void départ()
	{
		System.out.println("Je parts.");
	}

	/**
	 * Incrémente le numéro de châssis
	 */
	public void incrémenteProchainNuméroDeChâssis()
	{
		Vaisseau.prochainNumeroDeChassis ++;
	}

	/**
	 * Retourne le prochain numéro de châssis
	 */
	public int getProchainNumeroDeChassis()
	{
		return Vaisseau.prochainNumeroDeChassis;
	}

	/**
	 * Retourne le numéro de châssis
	 */
	public int getNumeroChassis()
	{
		return this.NUMERO_DE_CHASSIS;
	}

	// -----------------------------------------------------------
	// Redéfinition de méthodes
	
	/**
	 * Affichage du contenu de l’objet
	 * @return chaîne de caractère décrivant l'état courant de l'instance
	 */
	public String toString()
	{
		String desc = "\n\n" ;
		desc += "                  /--------- Vaisseau\n" ;
		desc += "     -------------\n" ;
		desc += "  /  Capacité  = " + this.getNbMaxPassagers() + " passagers\n" ;
		desc += "<    Altitude  = " + this.getAltitude() + " mètres\n" ;
		desc += "  \\  Catégorie = " + this.getCatégorie() + "\n" ;
		desc += "    \\  Numéro de châssis = " + this.getNumeroChassis() + "\n" ;
		desc += "      -------------\n" ;
		desc += "                   \\--------- Vaisseau\n" ;
	return desc ;
}

}

