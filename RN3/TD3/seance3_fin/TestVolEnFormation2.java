public class TestVolEnFormation2
{
	public static void main( String [] args)
	{
		Vaisseau [] formation = new Vaisseau [4];
		formation[0] = new Vaisseau() ;
		formation[1] = new Vaisseau() ;
		formation[2] = new VaisseauDeLEspace();
		formation[3] = new VaisseauAVoile();

		VolEnFormation vol = new VolEnFormation( formation, 0., 0., 100000.) ;

		for ( int i = 0; i < vol.getFormation().length; i++)
		{
			vol.getVaisseau(i).depart();
		}
	/*
		for ( int i = 0; i < vol.getFormation().length; i++)
		{
			vol.getVaisseau(i).percute();
		}
	*/
		VolEnFormation vol2 = new VolEnFormation( vol ) ;
		vol2.setVaisseau( 3, new VaisseauAVoile() ) ;

		System.out.println( vol  ) ;
		System.out.println( vol2 ) ;
	
		System.out.println( vol.equals( vol2 ) ) ;
		System.out.println( vol.getVaisseau(3).equals( vol2.getVaisseau(3) ) ) ;
	}
}

