



public interface StratégieDeComparaison
{
	/**
	 * Compare deux polygone et renvoie -1 si p1{@literal <}p2,
	 * à 0 si p1==p2 et +1 si p1{@literal >}p2.
	 * @param p1 le premier polygone de la comaraison
	 * @param p2 le second polygone de la comparaison
	 * @return -1, 0 ou +1 selon le résultat de la comparaison. 
	 */
	public int comparaison( Polygone p1, Polygone p2) ;
}
