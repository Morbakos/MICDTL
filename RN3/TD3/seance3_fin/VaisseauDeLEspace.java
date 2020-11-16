/**
 * Decrit un vaisseau de l'espace
 * @version 1.0
 * @author Guillaume Santini
 */
public class VaisseauDeLEspace extends Vaisseau
{
	/**
	 * Affiche le depart
	 */
	public void depart()
	{
		System.out.println("Je lance les moteurs a fusion.");
	}

	/**
	 * Affiche la percution
	 */
	public void percute()
	{
		System.out.println("Je depressurise.");
	}
	
	// ---------------------------------------------------
	// Redefinition des methodes de la classe Object

	public boolean equals( Object o)
	{
		if ( ! ( o instanceof VaisseauDeLEspace))
			return false ;
		VaisseauDeLEspace v = (VaisseauDeLEspace) o ;
		return (	super.equals(v));
	}

}




