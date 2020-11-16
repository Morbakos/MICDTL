/**
 * Décrit un triangle de l'espace cartésien à 2 dimesions
 * @version 1.1
 * @author Guillaume Santini
 */

public class Triangle {

	// -----------------------------------------------------------
	// Les attributs sont privés
	private PointPlan [] sommets ;
	
	// -----------------------------------------------------------
	// Constructeurs
	/**
	 * Constructeur champ à champ
	 */
	public Triangle( PointPlan [] sommets ) {
		if( sommets.length == 3 )
			this.setSommets( sommets ) ;
		else {
			this.setSommets( new PointPlan [3] ) ;
			for( int i = 0 ; i < 3 ; i++ )
				this.setSommet( i, new PointPlan()) ;
		}
	}

	/**
	 * Constructeur par défaut : les sommets du triangle sont 3
	 * instances de PointPlan par défaut
	 */
	public Triangle() {
		this( new PointPlan [3] );
		for( int i = 0 ; i < this.getSommets().length ; i++ )
			this.setSommet(i, new PointPlan()) ;
	}

	/**
	 * Constructeur par copie
	 */
	public Triangle( Triangle t ) {
		this.sommets = new PointPlan [3] ;
		for( int i = 0 ; i < this.sommets.length ; i++ )
			this.sommets[i] = new PointPlan( t.sommets[i] ) ;
	}
	
	// ----------------------------------------------------------
	// Accesseurs
	/**
	 * Fixe les sommets du triangle.
	 * @param sommets le tableau des sommets
	 */
	public void setSommets( PointPlan [] sommets ) {
		this.sommets = sommets ;
	}

	/**
	 * Retourne une référence vers le tableau de sommets du
	 * triangle
	 * @return le tableau des sommets
	 */
	public PointPlan [] getSommets() {
		return this.sommets ;
	}

	/**
	 * Fixe le sommet i du triangle
	 * @param i le numéro du sommet
	 * @param le point correspondant au nouveau sommet
	 */
	public void setSommet(int i, PointPlan p) {
		this.sommets[i] = p ;
	}

	/**
	 * Retourne le sommet numero i du triangle
	 * @param i le numéro du sommet
	 * @return la référence vers le sommet
	 */ 
	public PointPlan getSommet(int i) {
		return this.sommets[i] ;
	}
	
	// -----------------------------------------------------------
	// Autres méthodes
	/**
	 * Affichage du contenu de l’objet
	 * @return chaîne de caractère décrivant l'état courant de l'instance
	 */
	public String toString() {
		String s = "Triangle(" ;
		for( int i = 0 ; i < this.getSommets().length ; i++ )
			s = s + this.getSommet(i);
		s = s + ")" ;
		return s ;
	}






}

