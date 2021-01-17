
/**
 * Implémente une statégie de comparaison des
 * Polygone au moyen de leurs barycentres
 * @version 1.0
 * @author Guillaume Santini
 */


public class ComparaisonBarycentre implements StratégieDeComparaison
{
	/**
	 * Compare 2 polygones sur la base de la distance à l'origine
 	 * de leurs barycentre
	 * @param p1 le premier Polygone de la comparaison
	 * @param p2 le deuxième Polygone de la comparaison
	 * @return -1, 0 ou +1 selon le résultat de la comparaison
	 */
	public int comparaison(Polygone p1, Polygone p2)
	{
		double bary1 = p1.barycentre().distanceAOrigine() ;	
		double bary2 = p2.barycentre().distanceAOrigine() ;	
		if ( bary1 < bary2 )
			return -1;
		if ( bary1 == bary2 )
			return 0;
		return 1;
	}
}

