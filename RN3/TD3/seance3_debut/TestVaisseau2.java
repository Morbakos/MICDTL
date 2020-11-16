public class TestVaisseau2 {
	public static void main(String[] args) {

		Vaisseau v1 ;
		v1 = new Vaisseau() ;
		v1.depart() ;
		v1.percute() ;
		v1 = new VaisseauDeLEspace() ;
		v1.depart() ;
		v1.percute() ;

		VaisseauDeLEspace v2 = new VaisseauDeLEspace() ;
		v2.depart() ;
		v2.percute() ;
		v2 = new Vaisseau() ;
		v2.depart() ;
		v2.percute() ;

		v1 = (Vaisseau)( v2 ) ;
		v1.depart() ;
		v1.percute() ;

		v2 = (VaisseauDeLEspace)( v1 ) ;
		v2.depart() ;
		v2.percute() ;

		Vaisseau [] flotte=new Vaisseau [3];
		flotte[0] = new VaisseauDeLEspace();
		flotte[1] = new Vaisseau();
		flotte[2] = new VaisseauAVoile();

		for (int i = 0 ; i < flotte.length; i++)
			flotte[i].depart();
	
	}
}

