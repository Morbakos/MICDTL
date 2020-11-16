
public class Pilote extends Personnel {

	private String service ;
	private int    nombreHeuresDeVol ;
	
	public void setNombreHeuresDeVol( int n ) { this.nombreHeuresDeVol = n ; }
	public    int getNombreHeuresDeVol( ) { return this.nombreHeuresDeVol ; }

	public Pilote( String nom, int age, int numeroProfessionnel, String service , int nombreHeuresDeVol) {
		super(nom, age, numeroProfessionnel, service);
		this.setNombreHeuresDeVol( nombreHeuresDeVol) ;
	}
	
	public String toString() {
		String res = "cwPiloteMecanicien[ " ;
		res += "nom : " + super.getNom() + ", ";
		res += "age : " + super.getAge() + ", ";
		res += "n° de professionnel : " + super.getNumeroProfessionnel() + ", ";
		res += "service : " + super.getService() + ", ";
		res += "# heures de vol : " + this.getNombreHeuresDeVol() + "]" ;
		return res ;
	}
}




