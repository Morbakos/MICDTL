/**
 * Decrit un Vaisseau
 * @version 1.1
 * @author Guillaume Santini
 */


// definition d’une classe pour un vaisseau
public class Vaisseau {
	
	// ---------------------------------------------------
	// Variables d'instance
	private int nbMaxPassagers; 	// Equipage + passager
	private String categorie; 	// Classe du vaisseau
	private double altitude; 		// altitude effective de vol

	// ---------------------------------------------------
	// Variable de classe
	private static int prochainNumeroDeChâssis = 0 ;

	// ---------------------------------------------------
	// Constantes d'instance
	private final int NUMeRO_DE_CHÂSSIS;

	// Constructeurs -------------------------------------
	/**
	 * Constructeur Champ à Champ : Initialise un nouveau
	 * Vaisseau
	 * @param cat la categorie du vaisseau
	 * @param nbPAss le nombre de passagers que peut emporter
	 *               la vaisseau
	 * @param alt l'altitude de vol du vaisseau
	 */
	public Vaisseau( String cat, int nbPass, double alt) {
		this.setCategorie( cat) ;
		this.setNbMaxPassagers( nbPass) ;
		this.setAltitude( alt) ;
		this.NUMeRO_DE_CHÂSSIS = Vaisseau.getProchainNumeroDeChâssis();
		Vaisseau.incrementeProchainNumeroDeChâssis();
	}
	
	/**
	 * Constructeur par defaut : Initialise un nouveau
	 * vaisseau ayant pour categorie "Vaisseau Leger"
	 * admettant 7 passagers et volant à une altitude 
	 * de 0 mètres.
	 */
	public Vaisseau() {
		this( "Vaisseau leger", 7, 0.);
	}
	
	/**
	 * Constreur par copie
	 * @param v le modèle de Vaisseau
	 */
	public Vaisseau( Vaisseau v ) {
		this.nbMaxPassagers = v.nbMaxPassagers ;
		this.categorie = v.categorie ;
		this.altitude = v.altitude ;
		this.NUMeRO_DE_CHÂSSIS = v.NUMeRO_DE_CHÂSSIS ;
		// on n'incremente surtout pas le prochain numero de châssis.
	}

	// Accesseur Getter/Setter  --------------------------
	/**
	 * Fixe la categorie du vaisseau
	 * @param cat nom de la categorie
	 */
	public void setCategorie( String cat) {
		this.categorie = cat;
	}

	/**
	 * Retourne la categorie du vaisseau
	 * @return la categorie du vaisseau
	*/
	public String getCategorie() {
		return this.categorie;
	}

	/**
	 * Fixe la capacite en nombre de passagers du vaisseau
	 * @param n nombre maximal de passagers 
	 */
	public void setNbMaxPassagers( int n) {
		this. nbMaxPassagers = n;
	}

	/**
	 * Retourne la capacite en nombre de passagers du vaisseau
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
	 * Retourne le nombre du châssis du Vaisseau
	 * @return le numero de châssis
	 */
	public int getNumeroDeChâssis()
	{
		return this.NUMeRO_DE_CHÂSSIS ;
	}
	
	/**
	 * Affiche le depart
	 */
	public void depart()
	{
		System.out.println("Je parts.");
	}

	// ---------------------------------------------------
	// Methode de classe

	// Methode d'accès privee (utilisee seulement dans le
	// constructeur) d'accès au prochain numero de châssis
	private static int getProchainNumeroDeChâssis()
	{
		return Vaisseau.prochainNumeroDeChâssis;
	}

	// Methode privee (sutilisee seulement dans le constructeur
	// d'incrementation du prochain numero de châssis
	private static void incrementeProchainNumeroDeChâssis()
	{
		Vaisseau.prochainNumeroDeChâssis ++;
	}

	// -----------------------------------------------------------
	// Redefinition de methodes
	
	/**
	 * Affichage du contenu de l’objet
	 * @return chaîne de caractère decrivant l'etat courant de l'instance
	 */
	public String toString()
	{
		String desc = "\n\n" ;
		desc += "		  /- Vaisseau - Châssis : " + getNumeroDeChâssis() + "\n" ;
		desc += "     -------------\n" ;
		desc += "  /  Capacite  = " + this.getNbMaxPassagers() + " passagers\n" ;
		desc += "<    Altitude  = " + this.getAltitude() + " mètres\n" ;
		desc += "  \\  Categorie = " + this.getCategorie() + "\n" ;
		desc += "     -------------\n" ;
		desc += "		  \\- Vaisseau - Châssis : " + getNumeroDeChâssis() + "\n" ;
		return desc ;
	}

	/**
	 * Comparaison de Vaisseau 
	 * @param o l'instance de Vaisseau à comparer à l'instance courante
	 */
	public boolean equals( Object o ) {
		if ( ! ( o instanceof Vaisseau ) ) 
			return false ;
		Vaisseau v = (Vaisseau) o ;
		// Attention les numeros de châssis ne peuvent
		// être les mêmes
		return (	this.getCategorie().equals(v.getCategorie()) &&
					this.getAltitude() == v.getAltitude() &&
					this.getNbMaxPassagers() == v.getNbMaxPassagers()) ;
	}
}

