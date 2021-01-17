
/**
 * Décrit un polygone dans le plan 2D
 * 
 * @version 1.0
 * @author Guillaume Santini
 */
public class Polygone extends Figure implements Comparable {
	// ---------------------------------------------------
	// Variables d'instance

	private PointPlan[] sommets;

	// ---------------------------------------------------
	// Constructeurs

	/**
	 * Constructeur champs à champs
	 * 
	 * @param listeDePoints une tableau de points qui constitueront les sommets du
	 *                      polygone
	 * @param niveau        un niveau de gris compris entre 32 et 224
	 */
	public Polygone(PointPlan[] listeDePoints, int niveau) {
		super(niveau);
		this.sommets = listeDePoints;
	}

	// ---------------------------------------------------
	// Accesseur Getter/Setter

	/**
	 * Constructeur par copie
	 * 
	 * @param p le polygone qui sert de modèle
	 */
	public Polygone(Polygone p) {
		super(p.getNiveauGris());
		this.sommets = new PointPlan[p.nbDeSommets()];
		for (int i = 0; i < this.nbDeSommets(); i++)
			this.setSommet(i, new PointPlan(p.getSommet(i)));
	}

	/**
	 * Accesseur: Renvoie le point correspondant à un des sommets du Polygone.
	 * 
	 * @param i le numéro du sommets.
	 * @return le i-eme sommet du polygone
	 */
	public PointPlan getSommet(int i) {
		return this.sommets[i];
	}

	/**
	 * Accesseur: Définit le point correspondant à un des sommets du Polygone.
	 * 
	 * @param i le numéro du sommets.
	 * @param p le point qui formera le i-eme sommet
	 */
	public void setSommet(int i, PointPlan p) {
		this.sommets[i] = p;
	}

	/**
	 * Renvoie le nombre de sommets constitutant le Polygone
	 * 
	 * @return le nombre de sommets du polygone
	 */
	public int nbDeSommets() {
		return this.sommets.length;
	}

	// ---------------------------------------------------
	// Méthode décrivant le comportement de l’objet

	/**
	 * Translate le Polygone (et donc l'ensemble de ses sommets) d'un vecteur (x, y)
	 * 
	 * @param dx l'abscisse du vecteur de translation
	 * @param dy l'ordonnée du vecteur de translation
	 */
	public void translate(double dx, double dy) {
		for (int i = 0; i < this.nbDeSommets(); i++)
			this.getSommet(i).translate(dx, dy);
	}

	/**
	 * Retourne le Polygone translaté le Polygone d'un vecteur (x, y)
	 * 
	 * @param dx l'abscisse du vecteur de translation
	 * @param dy l'ordonnée du vecteur de translation
	 * @return le Polygone translaté
	 */
	public Polygone translaté(double dx, double dy) {
		Polygone p = new Polygone(this);
		p.translate(dx, dy);
		return p;
	}

	/**
	 * Renvoie le périmètre du Polygone
	 * 
	 * @return le périmètre
	 */
	public double périmètre() {
		double per = 0.;
		for (int i = 0; i < this.nbDeSommets(); i++) {
			if (i == this.nbDeSommets() - 1)
				per += this.getSommet(i).distanceA(this.getSommet(0));
			else
				per += this.getSommet(i).distanceA(this.getSommet(i + 1));
		}
		return per;
	}

	/**
	 * Renvoie le point barycentre des sommets du polygone
	 * 
	 * @return le point barycentre
	 */
	public PointPlan barycentre() {
		double x = 0.;
		double y = 0.;
		for (int i = 0; i < this.nbDeSommets(); i++) {
			x += this.getSommet(i).getAbscisse();
			y += this.getSommet(i).getOrdonnée();
		}
		return new PointPlan(x, y);
	}

	// ---------------------------------------------------
	// Redéfinition des méthode de la classe Object

	/**
	 * Test si l'objet en paramètre est similaire au Polygone courant ATTENTION:
	 * seules les points formant les sommets doivent être donnés dans le même ordre
	 * dans les 2 Polygones
	 * 
	 * @param o l'object à comparer au Polygone courrant
	 * @return true si l'objet passé en paramètre est un Polygone qui a des points
	 *         identiques au Polygone courrant.
	 */
	public boolean equals(Object o) {
		super.equals(o);
		if (!(o instanceof Polygone))
			return false;
		Polygone p = (Polygone) o;
		if (p.nbDeSommets() != this.nbDeSommets())
			return false;
		for (int i = 0; i < this.nbDeSommets(); i++)
			if (!(this.getSommet(i).equals(p.getSommet(i))))
				return false;
		return true;
	}

	/**
	 * Chaîne de caractère décrivant le Polygone
	 * 
	 * @return la chaîne de caractère formatée
	 */
	public String toString() {
		if (this.nbDeSommets() < 1)
			return super.toString() + " P[]";
		else if (this.nbDeSommets() == 1)
			return super.toString() + " P[ " + this.getSommet(0) + "]";
		else {
			String s = super.toString() + " P[";
			for (int i = 0; i < this.nbDeSommets() - 1; i++)
				s += this.getSommet(i) + ", ";
			s += this.getSommet(this.nbDeSommets() - 1) + "]";
			return s;
		}
	}

	public int compareTo(Object o) {
		double bary1 = this.barycentre().distanceAOrigine();
		double bary2 = ((Polygone) o).barycentre().distanceAOrigine();
		if (bary1 < bary2)
			return -1;
		if (bary1 == bary2)
			return 0;
		return 1;
	}
}
