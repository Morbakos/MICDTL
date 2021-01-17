
/**
 * Décrit un point du plan 2D
 * @version 1.0
 * @author Guillaume Santini
 */
public class PointPlan
{
	// ---------------------------------------------------
	// Variables d'instance
	private double abscisse ;
	private double ordonnée ;
	public final String NOM ;	

	// ---------------------------------------------------
	// Constructeurs
	
	/**
	 * Constructeur Champ à Champ : Initialise un nouveau
	 * point avec les coordonnées passées en paramètre
	 * @param x abscisse du point
	 * @param y ordonnée du point
	 * @param nom nom du point 
	 */
	public PointPlan( double x, double y, String nom)
	{
		this.abscisse = x ;
		this.ordonnée = y ;
		this.NOM = nom ;
	} 

	/**
	 * Constructeur par défaut : Initialise un nouveau point
	 * avec des coordonnées par défaut des coordonnées qui le
	 * place à l’origine du référentiel
	 */
	public PointPlan()
	{
		this( 0.f, 0.f, "M") ;
	}
	
	/**
	 * Cosntructeur permettant d'initialiser un point sans avoir
	 * à lui donner un nom. Le nom est "M" par défaut
	 * @param x abscisse du point
	 * @param y ordonnée du point
	 */
	public PointPlan(double x, double y)
	{
		this( x, y, "M") ;
	}
	
	/**
	 * Cosntructeur par copie
	 * @param p le point model
	 */
	public PointPlan( PointPlan p )
	{
		this( p.getAbscisse(), p.getOrdonnée(), p.NOM);
	}
	
	// ---------------------------------------------------
	// Accesseur Getter/Setter
	
	/**
	 *  Méthode publique d’accès en lecture a abscisse
	 * @return la valeur de l'abscisse
	 */
	public double getAbscisse() {
		return this.abscisse ;
	}

	/**
	 * Méthode publique d’accès en écriture a l'abscisse
	 * @param x la valeur de l'abscisse
	 */
	public void setAbscisse(double x) {
		this.abscisse = x ;
	}

	/**
	 *  Méthode publique d’accès en lecture a l'ordonnée
	 * @return la valeur de l'ordonnée
	 */
	// Méthode publique d’accès en lecture a ordonnée
	public double getOrdonnée() {
		return this.ordonnée ;
	}

	/**
	 * Méthode publique d’accès en écriture à l'ordonnée
	 * @param y la valeur de l'ordonnée
	 */
	public void setOrdonnée(double y) {
		this.ordonnée = y ;
	}

	// ---------------------------------------------------
	// Méthode décrivant le comportement de l’objet
	
	/**
	 * Translate un point
	 * @param δx translation selon l'axe des abscisses
	 * @param δy translation selon l'axe des ordonnées
	 */
	public void translate( double δx, double δy)
	{
		this.abscisse += δx ;
		this.ordonnée += δy ;
	}

	/**
	 * Distance entre le point courrant et le point passé
	 * en paramètre
	 * @param p le point par rapport auquel est calculé la
	 *			distance au point courrant.
	 * @return la distance entre les deux points
	 */
	public double distanceA(PointPlan p)
	{
		double x = this.getAbscisse() - p.getAbscisse() ;
		double y = this.getOrdonnée() - p.getOrdonnée() ;
		return Math.sqrt( x*x + y*y);
	}
	/**
	 * Distance entre le point et l’origine du repère
	 * @return la distance à l'origine du repère
	 */
	public double distanceAOrigine()
	{
		double dist ;
		dist = this.abscisse * this.abscisse + this.ordonnée * this.ordonnée ;
		return this.distanceA( new PointPlan( 0., 0.)) ;
	}
	
	/**
	 * Retourne un point symétrique à l’instance courrante
	 * @return le point symétrique par rapport à l'originie du repère
	 */
	public PointPlan symétrique() {
		return new PointPlan(-this.getAbscisse(),-this.getOrdonnée());
	}

	/**
	 * Les coordonnées polaires du point
	 * @return le point polaire correspondant au point euclidien
	 */
	public PointPolaire coorPolaires() {

		// calcul du module
		double module = Math.sqrt(
									this.getAbscisse() * this.getAbscisse() +
									this.getOrdonnée() * this.getOrdonnée()
								) ;
		
		// calcul de l’arguement
		double argument = Math.atan( this.getOrdonnée() / this.getAbscisse()) ;

		// Retour des résultats stockés dans un objet PointPlolaire 
		return new PointPolaire( module, argument) ;
	}

	// ---------------------------------------------------
	// Redéfinition des méthode de la classe Object

	/**
	 * Test si l'objet en paramètre est similaire au PointPlan courant
	 * ATTENTION: seules les coordonnées sont testées
	 * @param o l'object à comparer au PointPlan courrant
	 * @return true si l'objet passé en paramètre est un PointPlan
	 *			qui a les même coordonnées que le PointPlan courrant.
	 */
	public boolean equals( Object o)
	{
		if ( ! ( o instanceof PointPlan) )
			return false;
		PointPlan p = (PointPlan) o ;
		return ( this.getAbscisse() == p.getAbscisse() &&
				 this.getOrdonnée() == p.getOrdonnée() );
	}

	/**
	 * Renvoie une chaine formatée décrivant l'état du point
	 * @return la chaine décrivant le point
	 */
	public String toString()
	{
		return( this.NOM +
				" (x = " + this.getAbscisse() +
				", y = " + this.getOrdonnée() + ")" );
	}
}
