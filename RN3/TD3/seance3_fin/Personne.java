
public class Personne {

	private String nom ;
	private int    age ;
	
	public void setNom( String n ) { this.nom = n ; }
	public void setAge(    int a ) { this.age = a ; }

	public String getNom( ) { return this.nom ; }
	public    int getAge( ) { return this.age ; }

	public Personne( String nom, int age) {
		this.setNom( nom) ;
		this.setAge( age) ;
	}
		
	public String toString() {
		String res = "Personne[ " ;
		res += "nom : " + this.getNom() + ", ";
		res += "age : " + this.getAge() + "]";
		return res ;
	}

	public boolean equals( Object o ) {
		if ( ! ( o instanceof Personne ) ) 
			return false ;
		Personne p = (Personne) o ;
		return ( this.getNom().equals( p.getNom() ) && this.getAge() == p.getAge() ) ;
	} 
}




