
/**
 * Implémente une statégie de comparaison des
 * Polygone au moyen de leurs périmètres
 * @version 1.0
 * @author Guillaume Santini
 */


public class ComparaisonPérimètre implements StratégieDeComparaison
{
	/**
	 * Compare 2 polygones sur la base de la distance à l'origine
 	 * de leurs périmètres
	 * @param p1 le premier Polygone de la comparaison
	 * @param p2 le deuxième Polygone de la comparaison
	 * @return -1, 0 ou +1 selon le résultat de la comparaison
	 */
	public int comparaison(Polygone p1, Polygone p2)
	{
		double per1 = p1.périmètre() ;
		double per2 = p2.périmètre() ;
		if ( per1 < per2 )
			return -1;
		if ( per1 == per2 )
			return 0;
		return 1;
	}
}

