public class Personne2 {
    private String nom;
    private int age;

    public Personne2(String unNom, int unAge) {
        this.nom = unNom;
        this.age = unAge;
    }

    public String getNom() { return this.nom; };
    public int getAge() { return this.age; };

    public boolean equals(Personne2 p) {
        return (this.nom.equals(p.getNom()) && this.age == p.getAge());
    }
}