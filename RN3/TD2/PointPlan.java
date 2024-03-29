/**
 * Décrit un point du plan
 * @version 1.1
 * @author Guillaume Santini
 */


public class PointPlan
{
	// -----------------------------------------------------------
	// Les attributs sont privés

	private double abscisse ;
	private double ordonnée ;
	private String nom ;

	// -----------------------------------------------------------
	// Constructeurs

	/**
	 * Constructeur champ à champ
	 */
	public PointPlan( double x, double y, String nom) {
		this.setAbscisse(x) ;
		this.setOrdonnée(y) ;
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
     */
    public PointPlan (PointPlan pp){
        this.abscisse = pp.abscisse;
        this.ordonnée = pp.ordonnée;
        this.nom = pp.nom;
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
	 * Retourne l'ordonnée du point
	 * @return l'ordonnée
	 */
	public double getOrdonnée() {
		return this.ordonnée ;
	}

	/**
	 * Fixe l'ordonnée du point
	 * @param y l'ordonnée
	 */
	public void setOrdonnée(double y) {
		this.ordonnée = y ;
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
	// Autres méthodes

	/**
	 * Translate le point selon le vecteur de coordonnées ( dx, dy)
	 * @param dx distance de translation selon l'axe des abscisses
	 * @param dy distance de translation selon l'axe des ordonnées
	 */  
	public void translate( double dx, double dy){
		this.setAbscisse( this.getAbscisse() + dx) ;
		this.setOrdonnée( this.getOrdonnée() + dy) ;
	}

	/**
	 * Retourne la distance séparant le point de l'orirgine du repère
	 * @return la distance à l'origine
	 */
	private double distAOrigine() {
		return Math.sqrt(	Math.pow(this.getAbscisse(), 2) +
							Math.pow(this.getOrdonnée (), 2)  );
	}

}

