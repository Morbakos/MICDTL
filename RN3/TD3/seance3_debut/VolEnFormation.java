/**
 * Decrit un Vol en formation compose de plusieurs Vaisseau
 * @version 1.1
 * @author Guillaume Santini
 */

public class VolEnFormation {

	// Variables d'instance
	private Vaisseau [] formation ;
	private PointPlan position ;
	private double altitudeFixee ;

	// Constructeurs -------------------------------------
	/**
	 * Constructeur champ à champ
	 * @param formation le tableau des vaisseaux de la formation
	 * @param posX l'abscisse de la position de la formation
	 * @param posY l'ordonnee de la position de la formation
	 * @param altitude l'altitude fixee pour la formation 
	 */
	public VolEnFormation( Vaisseau [] formation, double posX, double posY, double altitude) {
		this.formation = formation ;
		this.position = new PointPlan( posX, posY, "Position") ;
		this.altitudeFixee = altitude ;
	}
	
	/**
	 * Constructeur par copie
	 * @param vol le modèle de VolEnFormation
	 */
	public VolEnFormation( VolEnFormation vol) {
		this.formation = new Vaisseau [ vol.formation.length ];
		for( int i = 0 ; i < this.formation.length ; i++ )
			this.formation[i] = new Vaisseau( vol.formation[i] ) ;
		this.position = new PointPlan( vol.position ) ;
		this.altitudeFixee = vol.altitudeFixee ;
	}

	// Accesseur Getter/Setter  --------------------------
	/**
	 * Retourne le tableau contenant les Vaisseau de la formation
	 * @return le tableau de Vaisseau
	 */
	public Vaisseau [] getFormation() {
		return this.formation ;
	}
	
	/**
	 * Fixe le tableau contenant les Vaisseau de la formation
	 * @param formation le tableau de Vaisseau
	 */
	public void setFormation( Vaisseau [] formation ) {
		this.formation = formation ;
	}

	/**
	 * Retourne le ième Vaisseau de la formation et null si i depasse la taille du tableau
	 * @param i le numero du Vaisseau
	 * @return le Vaisseau numero i
	 */
	public Vaisseau getVaisseau(int i) {
		if ( i < this.getFormation().length )
			return this.formation[i] ;
		else
			return null;
	}
	
	/**
	 * Fixe le ième Vaisseau de la formation
	 * @param i le numero du Vaisseau que l'on souhaite fixer
	 * @param newV le nouveau Vaisseau
	 */
	public void setVaisseau( int i, Vaisseau newV ) {
		this.formation[i] = newV ;
	}
	
	/**
	 * Retourne l'abscisse de la position de la formation
	 * @return l'abscisse de la position de la formation
	 */
	public double getAbscisse() {
		return this.position.getAbscisse();
	}

	/**
	 * Retourne l'ordonnee de la position de la formation
	 * @return l'ordonnee de la position de la formation
	 */
	public double getOrdonnee() {
		return this.position.getOrdonnee();
	}

	/**
	 * Fixe l'abscisse de la position de la formation
	 * @param newX l'abscisse de la position de la formaiton
	 */
	public void setAbscisse( double newX) {
		this.position.setAbscisse( newX );
	}
	
	/**
	 * Fixe l'ordonnee de la position de la formation
	 * @param newY l'ordonnee de la position de la formaiton
	 */
	public void setOrdonnee( double newY) {
		this.position.setOrdonnee( newY );
	}
	
	/**
	 * Retourne l'altitude fixee pour la formation
	 *  @return l'altitude fixee pour la formation
	 */
	public double getAltitudeFixee() {
		return this.altitudeFixee;
	}
	
	/**
	 * Fixe l'altitude de la formation
	 * @param newAlt l'altitude fixee
	 */
	public void setAltitudeFixee( double newAlt ) {
		this.altitudeFixee = newAlt ;
		if ( ! this.altitudeValide() )
			this.setAltitudeFixee( 1000. );
	}  

	// -----------------------------------------------------------
	// Autres methodes
	/**
	 * Retourne le nombre de Vaisseau constituant la formation
	 * @return le nombre de Vaisseau de la formation
	 **/
	public int nbDeVaisseaux() {
		return this.getFormation().length;
	}

	/**
	 * Methode publique de test de l'altitude. Permet de
	 * savoir si l'altitude de vol prevue pour la formation
	 * est au dessus du sol!
	 * @return true si l'altitde de la formation est au
	 *         dessus de l'altitude 0.
	 */
	public boolean altitudeValide() {
		return ( 0. < this.getAltitudeFixee());
	}

	/**
	 * Repercute l'altitude de vol (transmet) aux
	 * vaisseaux qui composent la formation de vol
	 **/
	public void appliqueAltitudeDeVol() {
		for( int i = 0 ; i < this.nbDeVaisseaux(); i++)
			this.getVaisseau( i ).setAltitude(this.getAltitudeFixee()) ;
	}
	
	/**
	 * Retourne le tableau des altitudes de chaque vaisseau
	 * composant la formation
	 * @return un tableau d''altitudes
	 */
	public double [] altitudesDesVaisseaux() {
		double [] tab = new double [ this.nbDeVaisseaux() ] ;
		for( int i = 0 ; i < tab.length ; i++ )
			tab[i] = this.getVaisseau(i).getAltitude();
		return tab ;
	}
	
	/**
	 * Deplace la formation.
	 * @param dx valeur du deplacement selon l'axe des abscisses
	 * @param dy valeur du deplacement selon l'axe des ordonnees
	**/
	void deplacement( double dx, double dy ) {
		this.setAbscisse( this.getAbscisse() + dx );
		this.setOrdonnee( this.getOrdonnee() + dy );
	}
	
	/**
	 * 
	 **/
	void destruction( int position) {
		this.setVaisseau( position, null );
	}

	// -----------------------------------------------------------
	// Redefinition de mc String toString()
	/**
	 * Affichage du contenu de l’objet
	 * @return chaîne de caractère decrivant l'etat courant de l'instance
	 */
	public String toString() {
		String desc = "";
		desc += "--------------------------------------\n";
		desc += "+- Vol En Formation\n";
		desc += "   |- Altitude : " + this.getAltitudeFixee() + "\n" ;
		desc += "   |- Position : (" + this.getAbscisse() + "," + this.getOrdonnee() + ")\n" ;
		for (int i = 0; i < this.nbDeVaisseaux(); i++) {
			desc += "   |- Vaisseau " + i + " : " + "\n" ;
			desc += this.getVaisseau(i) + "\n";
		}
		desc += "+- Vol En Formation\n";
		desc += "--------------------------------------\n";
		return desc ;
	}
	
}










