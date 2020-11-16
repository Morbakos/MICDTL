
public class Mecanicien extends Personnel {

	private String specialite ;
	
	public void setSpecialite( String spec ) { this.specialite = spec ; }

	public String getSpecialite( ) { return this.specialite ; }

	public Mecanicien( String nom, int age, int numeroProfessionnel, String service, String specialite) {
		super( nom, age, numeroProfessionnel, service );
		this.setSpecialite( specialite) ;
	}
		
	public String toString() {
		String res = "Mecanicien[ " ;
		res += super.toString() + ", ";
		res += "specialite : " + this.getSpecialite() + "]" ;
		return res ;
	}

	public boolean equals( Object o ) {
		if ( ! ( o instanceof Mecanicien ) ) 
			return false ;
		Mecanicien m = (Mecanicien) o ;
		return ( super.equals( m ) && this.getSpecialite().equals(  m.getSpecialite() ) ) ;
	}
}




