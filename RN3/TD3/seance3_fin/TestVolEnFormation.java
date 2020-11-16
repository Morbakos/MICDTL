/**
 * Classe de test de la classe VolEnFormation
 * @version 1.1
 * @author Guillaume Santini
 */

public class TestVolEnFormation
{
	public static void main(String [] args)
	{
		Vaisseau [] vaisseaux = new Vaisseau [3] ;
		vaisseaux[0] = new Vaisseau("Chasseur Leger", 2,10000);
		vaisseaux[1] = new Vaisseau("Chasseur Leger", 2,10);
		vaisseaux[2] = new Vaisseau("Vaisseau Lourd", 46785, 1800000) ;
		VolEnFormation liberty = new VolEnFormation( vaisseaux, 10, 13, 0.);
		liberty.setAltitudeFixee( 167000.);
		System.out.println( liberty);
		
		double [] altitudes = liberty.altitudesDesVaisseaux();
		
		int i = 0 ;
		while( i < altitudes.length && altitudes[i] == liberty.getAltitudeFixee() )
			i++ ;
		if ( i != altitudes.length )
		{
			System.out.println( "Ajustement des altitudes\n" );
			liberty.appliqueAltitudeDeVol();
		}
		System.out.println( liberty);
		
		VolEnFormation phantom = new VolEnFormation( liberty ) ;
		phantom.setVaisseau( 0 , new Vaisseau( phantom.getVaisseau( 0 ) ) ) ;
		phantom.setAltitudeFixee( 0.) ;
		phantom.appliqueAltitudeDeVol();
		
		System.out.println( " Comparaison des vols en formation (test des constructeurs par copiei\n" ) ;
		System.out.println( "Vol en formation liberty: \n\n" + liberty );
		System.out.println( "Vol en formation phantom: \n\n" + phantom );
	}
}




