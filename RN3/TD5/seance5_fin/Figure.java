public class Figure {

	// ---------------------------------------------------
	// Variables d'instance
	private int niveauGris ;
	
	// ---------------------------------------------------
	// Constructeurs
	/**
	 * Constructeur champ à champs
	 * @param n le nibeau de gris
	 */
	public Figure(int n)
	{
		this.niveauGris = n ;
	}

	// ---------------------------------------------------
	// Accesseur Getter/Setter

	/**
	 * Accesseur: revoie le niveau de grais (couleur) de la
	 * figure
	 * @return le niveau de gris
	 */
	public int getNiveauGris()
	{
		return niveauGris;
	}
	
	/**
	 * Accesseur: Fixe le niveau de gris de la figure
	 * @param niveauGris le niveau de gris (compris entre 0 et 255)
	 */
	public void setNiveauGris(int niveauGris)
	{
		this.niveauGris = niveauGris;
	}
	
	/** 
	 * Test si la figure n'est pas trop clair (vers le blanc) ou
	 * trop foncée (vers le noir)
	 * @return true si le gris n'est pas trop clair ou trop foncé
	 */
	public boolean estGris()
	{
		return (this.niveauGris<32 && (niveauGris>=224)) ;
	}
	
	// ---------------------------------------------------
	// Redéfinition des méthode de la classe Object

	/**
	 * Test si l'objet en paramètre est similaire à la Figure courante
	 * @param o l'object à comparer au Figure courrante
	 * @return true si l'objet passé en paramètre est une Figure
	 *			qui a un niveau de Gris identiques à la Figure courrante.
	 *
	 */
	public boolean equals( Object o)
	{
		if ( ! ( o instanceof Figure ) ) 
			return false;
		Figure f = (Figure) o ;
		return this.niveauGris == f.niveauGris ;
	}

	/**
	 * Chaîne de caractère décrivant le Polygone
	 * @return la chaîne de caractère formatée
	 */
	public String toString()
	{
		return ("Figure[ Niveau de Gris = "+this.getNiveauGris()+" ]");
	}
}	
