
public class Passager extends Personne {

	private int numeroDeBillet ;
	
	public void setNumeroDeBillet ( int n ) { this.numeroDeBillet = n ; }

	public    int getNumeroDeBillet ( ) { return this.numeroDeBillet ; }

	public Passager( String nom, int age, int numeroDeBillet) {
		super( nom, age) ;
		this.setNumeroDeBillet( numeroDeBillet) ;
	}
	
	public String toString() {
		String res = "Passager[ " ;
		res += super.toString() + ", ";
		res += "n° de billet : " + this.getNumeroDeBillet() + "]";
		return res ;
	}
	
	public boolean equals( Object o ) {
		if ( ! ( o instanceof Passager ) ) 
			return false ;
		Passager p = (Passager) o ;
		return ( super.equals( p ) && this.getNumeroDeBillet() == p.getNumeroDeBillet() ) ;
	}
}




