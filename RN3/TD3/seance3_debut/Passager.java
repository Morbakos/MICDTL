
public class Passager {

	private String nom ;
	private int age ;
	private int numeroDeBillet ;
	
	public void setNom( String n ) { this.nom = n ; }
	public void setAge(    int a ) { this.age = a ; }
	public void setNumeroDeBillet ( int n ) { this.numeroDeBillet = n ; }


	public String getNom( ) { return this.nom ; }
	public    int getAge( ) { return this.age ; }
	public    int getNumeroDeBillet ( ) { return this.numeroDeBillet ; }

	public Passager( String nom, int age, int numeroDeBillet) {
		this.setNom( nom) ;
		this.setAge( age) ;
		this.setNumeroDeBillet( numeroDeBillet) ;
	}
	
	public String toString() {
		String res = "Passager[ " ;
		res += "nom : " + this.getNom() + ", ";
		res += "age : " + this.getAge() + ", ";
		res += "n° de billet : " + this.getNumeroDeBillet() + "]";
		return res ;
	}
}




