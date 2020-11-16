
public class Passager {

	private String nom ;
	private int age ;
	private int numéroDeBillet ;
	
	public void setNom( String n ) { this.nom = n ; }
	public void setAge(    int a ) { this.age = a ; }
	public void setNuméroDeBillet ( int n ) { this.numéroDeBillet = n ; }


	public String getNom( ) { return this.nom ; }
	public    int getAge( ) { return this.age ; }
	public    int getNuméroDeBillet ( ) { return this.numéroDeBillet ; }

	public Passager( String nom, int age, int numéroDeBillet) {
		this.setNom( nom) ;
		this.setAge( age) ;
		this.setNuméroDeBillet( numéroDeBillet) ;
	}
	
	public String toString() {
		String res = "Passager[ " ;
		res += "nom : " + this.getNom() + ", ";
		res += "age : " + this.getAge() + ", ";
		res += "n° de billet : " + this.getNuméroDeBillet() + "]";
		return res ;
	}
}




