public class Personnel extends Personne {
    
    private int    numeroProfessionnel ;
    private String service ;
    
    public Personnel(String nom, int age, int numero, String service){
        super(nom, age);
        this.setNumeroProfessionnel(numero);
        this.setService(service);
    }

    //==== Getter / Setter


    public void setNumeroProfessionnel(int numero){
        this.numeroProfessionnel = numero;
    }

    public void setService( String s ) { 
        this.service = s ; 
    }

	public    int getNumeroProfessionnel ( ) { return this.numeroProfessionnel ; }
	public String getService( ) { return this.service ; }
    
    public String toString() {
        String res = "Personnel[ " ;
        res += super.toString() + ", ";
        res += "Numero pro : " + this.getNumeroProfessionnel() + ", ";
		res += "Service : " + this.getService() + "]" ;
		return res ;
	}
}
