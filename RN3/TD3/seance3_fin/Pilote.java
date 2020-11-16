
public class Pilote extends Personnel {

	private int    nombreHeuresDeVol ;
	
	public void setNombreHeuresDeVol( int n ) { this.nombreHeuresDeVol = n ; }

	public    int getNombreHeuresDeVol( ) { return this.nombreHeuresDeVol ; }

	public Pilote( String nom, int age, int numeroProfessionnel, String service , int nombreHeuresDeVol) {
		super( nom, age, numeroProfessionnel, service );
		this.setNombreHeuresDeVol( nombreHeuresDeVol) ;
	}
	
	public String toString() {
		String res = "Pilote[ " ;
		res += super.toString() + ", " ;
		res += "# heures de vol : " + this.getNombreHeuresDeVol() + "]" ;
		return res ;
	}
	
	public boolean equals( Object o ) {
		if ( ! ( o instanceof Pilote ) )
			return false ;
		Pilote p = (Pilote) o ;
		return ( super.equals( p ) &&
				( this.getNombreHeuresDeVol() == p.getNombreHeuresDeVol() ) );
	}
}




