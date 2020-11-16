public class Personnel {
    private String nom ;
	private int    age ;
    private int    numeroProfessionnel ;
    private String service ;
    
    public Personnel(String nom, int age, int numero, String service){
        this.setNom(nom);
        this.setAge(age);
        this.setNumeroProfessionnel(numero);
        this.setService(service);
    }

    //==== Getter / Setter

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setNumeroProfessionnel(int numero){
        this.numeroProfessionnel = numero;
    }

    public void setService( String s ) { 
        this.service = s ; 
    }

    public String getNom( ) { return this.nom ; }
	public    int getAge( ) { return this.age ; }
	public    int getNumeroProfessionnel ( ) { return this.numeroProfessionnel ; }
	public String getService( ) { return this.service ; }
	
}
