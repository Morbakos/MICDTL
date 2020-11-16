/**
 * Decrit un point du plan decrit par des coordonnees cartesiennes
 * @version 1.1
 * @author Guillaume Santini
 */


public class PointPlan
{
	// -----------------------------------------------------------
	// Les attributs sont prives

	private double abscisse ;
	private double ordonnee ;
	private String nom ;

	// -----------------------------------------------------------
	// Constructeurs

	/**
	 * Constructeur champ à champ
	 */
	public PointPlan( double x, double y, String nom) {
		this.setAbscisse(x) ;
		this.setOrdonnee(y) ;
		this.setNom( nom );
	}

	/**
	 * Constructeur par defaut: le point est à l'origine et a pour nom `M`
	 */
	public PointPlan() {
		this(0., 0., "M") ;
	}

	/**
	 * Constructeur par copie
	 * @param le modèle de PointPlan
	 */
	public PointPlan(PointPlan p) {
		this.abscisse = p.abscisse ;
		this.ordonnee = p.ordonnee ;
		this.nom = new String( p.nom ) ;
	}
	
	// ----------------------------------------------------------
	// Accesseurs
	
	/**
	 * Retourne l'abscisse du point
	 * @return l'abscisse
	 */
	public double getAbscisse() {
		return this.abscisse ;
	}

	/**
	 * Fixe l'abscisse du point
	 * @param x l'abscisse
	 */
	public void setAbscisse(double x) {
		this.abscisse = x ;
	} 

	/**
	 * Retourne l'ordonnee du point
	 * @return l'ordonnee
	 */
	public double getOrdonnee() {
		return this.ordonnee ;
	}

	/**
	 * Fixe l'ordonnee du point
	 * @param y l'ordonnee
	 */
	public void setOrdonnee(double y) {
		this.ordonnee = y ;
	} 

	/**
	 * Retourne l'nom du point
	 * @return l'nom
	 */
	public String getNom() {
		return this.nom ;
	}

	/**
	 * Fixe l'nom du point
	 * @param nom le nom
	 */
	public void setNom(String nom) {
		this.nom = nom ;
	} 

	// -----------------------------------------------------------
	// Autres methodes

	/**
	 * Translate le point selon le vecteur de coordonnees ( dx, dy)
	 * @param dx distance de translation selon l'axe des abscisses
	 * @param dy distance de translation selon l'axe des ordonnees
	 */  
	public void translate( double dx, double dy){
		this.setAbscisse( this.getAbscisse() + dx) ;
		this.setOrdonnee( this.getOrdonnee() + dy) ;
	}

	/**
	 * Retourne la distance separant le point de l'orirgine du repère
	 * @return la distance à l'origine
	 */
	private double distAOrigine(){
		return Math.sqrt(Math.pow(this.getAbscisse(), 2) +
						Math.pow(this.getOrdonnee (), 2)  );
	}

	/**
	 * Retourne la distance à l’origine du point ainsi que
	 * l’angle que forme ce point avec l’axe des abscisses dans
	 * une PointPolaire
	 * @return le point polaire dont le module est la distance à l'origine du point
	 *			dont l'argument est l'angke que forme le point avec l'axe des
	 * 			abscisses.
	 */ 
	public PointPolaire coorPolaires() {
		// calcul du module
		double module = this.distAOrigine();

		// calcul de l’arguement
		double argument = Math.atan(this.getOrdonnee() / this.getAbscisse()) ;

		// Retour des resultats stockes dans un objet PointPlolaire 
		return new PointPolaire( module, argument, this.getNom()+"") ;
	}
	
	/**
	 * Retourne le point symetrique (par symetrie centrale relatif à l'origine
	 * du repère. Le nom donne au symetrique est celui du point courant 
	 * augmente de "sym"
	 * @return le point symetrique
	 */
	public PointPlan symetrique() {
		return new PointPlan(-this.getAbscisse(),-this.getOrdonnee(), this.getNom()+"sym");
	}

	// -----------------------------------------------------------
	// Redefinition de methodes
	
	/**
	 * Affichage du contenu de l’objet
	 * @return chaîne de caractère decrivant l'etat courant de l'instance
	 */
	public String toString() { 
		return( "x = " + this.getAbscisse() + ", y = " + this.getOrdonnee()) ;
	}


}

