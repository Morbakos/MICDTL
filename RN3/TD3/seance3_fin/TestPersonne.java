


public class TestPersonne {
	public static void main( String [] args ) {

		// -------------------------------------------------------
		// Les passagers
	
		Passager passa1 = new Passager("John", 48, 45736 ) ;
		Passager passa2 = new Passager("Doe",  47, 45743 ) ;
		
		System.out.println( passa1 );
		System.out.println( passa2 );
		
		passa1.setNumeroDeBillet( 45744 ) ;
		passa2.setAge( 43 );

		System.out.println( passa1 );
		System.out.println( passa2 );
	
		// -------------------------------------------------------
		// Les mecaniciens
	
		Mecanicien meca1 = new Mecanicien("Newton", 48, 1100187736, "Maintenance", "Fluide") ;
		Mecanicien meca2 = new Mecanicien("Isaac", 29, 110675423, "Maintenance", "Façonage" ) ;
		
		System.out.println( meca1 );
		System.out.println( meca2 );
		
		meca1.setService( "Pont d'envol" ) ;
		meca2.setAge( 43 );

		System.out.println( meca1 );
		System.out.println( meca2 );
	
		// -------------------------------------------------------
		// Les pilotes

		Pilote pilote1 = new Pilote("Isaac", 67, 110675423, "Flibuste", 12567 ) ;
		Pilote pilote2 = new Pilote("Newton", 22, 1100187736, "Flotte", 554) ;
		
		System.out.println( pilote1 );
		System.out.println( pilote2 );
		
		pilote2.setNombreHeuresDeVol( 2 + pilote2.getNombreHeuresDeVol() );
		pilote1.setAge( 29 ) ;

		System.out.println( pilote1 );
		System.out.println( pilote2 );
	}
}
