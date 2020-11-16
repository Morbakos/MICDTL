
public class Pilote {

	private String nom ;
	private int    age ;
	private int    numéroProfessionnel ;
	private String service ;
	private int    nombreHeuresDeVol ;
	
	public void setNom( String n ) { this.nom = n ; }
	public void setAge(    int a ) { this.age = a ; }
	public void setNuméroProfessionnel ( int n ) { this.numéroProfessionnel = n ; }
	public void setService( String s ) { this.service = s ; }
	public void setNombreHeuresDeVol( int n ) { this.nombreHeuresDeVol = n ; }


	public String getNom( ) { return this.nom ; }
	public    int getAge( ) { return this.age ; }
	public    int getNuméroProfessionnel ( ) { return this.numéroProfessionnel ; }
	public String getService( ) { return this.service ; }
	public    int getNombreHeuresDeVol( ) { return this.nombreHeuresDeVol ; }

	public Pilote( String nom, int age, int numéroProfessionnel, String service , int nombreHeuresDeVol) {
		this.setNom( nom) ;
		this.setAge( age) ;
		this.setNuméroProfessionnel( numéroProfessionnel) ;
		this.setService( service );
		this.setNombreHeuresDeVol( nombreHeuresDeVol) ;
	}
	
	public String toString() {
		String res = "cwPiloteMécanicien[ " ;
		res += "nom : " + this.getNom() + ", ";
		res += "age : " + this.getAge() + ", ";
		res += "n° de professionnel : " + this.getNuméroProfessionnel() + ", ";
		res += "service : " + this.getService() + ", ";
		res += "# heures de vol : " + this.getNombreHeuresDeVol() + "]" ;
		return res ;
	}
}




