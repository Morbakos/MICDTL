public class Personne {
    private String nom ;
    private int    age ;
    
    public Personne (String nom, int age){
        this.setNom(nom);
        this.setAge(age);
    }

    public void setNom(String nom){ this.nom = nom; }
    public void setAge(int age){ this.age = age; }

    public String getNom( ) { return this.nom ; }
    public    int getAge( ) { return this.age ; }
    
    public String toString() {
		String res = "Personne[ " ;
		res += "nom : " + this.getNom() + ", ";
		res += "age : " + this.getAge() +  "]" ;
		return res ;
    }
    
    public boolean equals(Object obj) {
        if (! (obj instanceof Personne)) { return false; }

        Personne p = (Personne) obj;
        return (
            (this.getNom().equals(p.getNom())) &&
            this.getAge() == p.getAge()
        );
    }
}
