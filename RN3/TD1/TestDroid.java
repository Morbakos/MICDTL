public class TestDroid
{
    public static void main(String [] args){
        Droid r2 = new Droid ("Série R2", 96);
        Droid po = new Droid ();
        
        // avec getter
        System.out.println(r2.getModele());
        System.out.println(po.getModele());

        // Throw une erreur
        // System.out.println(r2.modele);
        // System.out.println(po.modele);

        //avec getter
        System.out.println(r2.getTaille());
        System.out.println(po.getTaille());

        // Throw une erreur
        // System.out.println(r2.taille);
        // System.out.println(po.taille);
    }
}
