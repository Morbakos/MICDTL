/**
 * Classe de test de la classe Vaisseau
 * @version 1.1
 * @author Guillaume Santini
 */


// définition d’une classe de Test pour un vaisseau
public class TestVaisseau
{
	public static void main(String [] args) {
		Vaisseau xwingT65 ;
		xwingT65 = new Vaisseau("Chasseur Léger", 2, 10000) ;
		Vaisseau stalker;
		stalker = new Vaisseau("Vaisseau Lourd", 46785, 1800000) ;
		Vaisseau surprise = xwingT65 ;

		System.out.println(stalker.getAltitude()) ;
		System.out.println(stalker.getNbMaxPassagers()) ; // SETTER
		System.out.println(surprise.getAltitude()) ;

		xwingT65.setAltitude(10) ;
		xwingT65.setNbMaxPassagers(1) ;                   // GETTER
		System.out.println(xwingT65.getNbMaxPassagers()) ;
		xwingT65= stalker ;
	}
}

