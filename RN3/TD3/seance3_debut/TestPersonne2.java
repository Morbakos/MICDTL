public class TestPersonne2 {
    public static void main(String[] args) {
        Personne2 p1 = new Personne2("Toto", 30);
        Personne2 p2 = new Personne2("Toto", 30);
        if (p1.equals(p2))
            System.out.println("EGALES");
        else
            System.out.println("DIFFERENTES");
    }
}