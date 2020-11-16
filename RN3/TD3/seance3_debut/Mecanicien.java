
public class Mecanicien extends Personnel {

	private String specialite ;
	
	public void setSpecialite( String spec ) { this.specialite = spec ; }
	public String getSpecialite( ) { return this.specialite ; }

	public Mecanicien( String nom, int age, int numeroProfessionnel, String service, String specialite) {
		super(nom, age, numeroProfessionnel, service);
		this.setSpecialite( specialite) ;
	}
		
	public String toString() {
		String res = "Mecanicien[ " ;
		res += super.toString() + ", ";
		res += "specialite : " + this.getSpecialite() + "]" ;
		return res ;
	}
}




