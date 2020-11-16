
public class Personnel extends Personne {

	private int    numeroProfessionnel ;
	private String service ;
	
	public void setNumeroProfessionnel ( int n ) { this.numeroProfessionnel = n ; }
	public void setService( String s ) { this.service = s ; }


	public    int getNumeroProfessionnel ( ) { return this.numeroProfessionnel ; }
	public String getService( ) { return this.service ; }

	public Personnel( String nom, int age, int numeroProfessionnel, String service) {
		super( nom, age) ;
		this.setNumeroProfessionnel( numeroProfessionnel) ;
		this.setService( service );
	}
		
	public String toString() {
		String res = "Personnel[ " ;
		res += super.toString() + ", ";
		res += "n° de professionnel : " + this.getNumeroProfessionnel() + ", ";
		res += "service : " + this.getService() + "]" ;
		return res ;
	}

	public boolean equals( Object o ) {
		if ( ! ( o instanceof Personnel ) ) 
			return false ;
		Personnel p = (Personnel) o ;
		return ( super.equals( p ) && 
				 (this.getNumeroProfessionnel() == p.getNumeroProfessionnel() ) &&
				 (this.getService().equals( p.getService() ) ) ) ;
	}
}




