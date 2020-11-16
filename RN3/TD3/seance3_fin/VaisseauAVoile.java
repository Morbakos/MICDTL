/**
 * Decrit un vaisseau a voile
 * @version 1.0
 * @author Guillaume Santini
 */
public class VaisseauAVoile extends Vaisseau
{
	/**
	 * Affiche le depart
	 */
	public void depart()
	{
		System.out.println("Je mets les voiles.");
	}

	/**
	 * Affiche la percution
	 */
	public void percute()
	{
		System.out.println("Je coule.");
	}


	// ---------------------------------------------------
	// Redefinition des methodes de la classe Object

	public boolean equals( Object o)
	{
		if ( ! ( o instanceof VaisseauAVoile))
			return false;
		VaisseauAVoile v = (VaisseauAVoile) o ;
		return (	super.equals(v));
	}

}




