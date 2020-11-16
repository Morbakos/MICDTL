public class TestPersonne {
    public static void main(String[] args) {
        Passager p1 = new Passager("Gavin", 24, 5);
        Passager p2 = new Passager("Juan", 53, 9);

        System.out.println(p1);
        System.out.println(p2);

        // changement numero billet
        p2.setNumeroDeBillet(66);

        // Changement age
        p1.setAge(34);

        System.out.println(p1);
        System.out.println(p2);

        //=========================================================================

        Mecanicien m1 = new Mecanicien("Will", 33, 44, "Mobilite", "Moteur");
        Mecanicien m2 = new Mecanicien("Richard", 53, 9, "Integrite", "Blindage");

        System.out.println(m1);
        System.out.println(m2);

        // changement service
        m1.setService("Peinture");

        // Changement age
        p1.setAge(68);

        System.out.println(m1);
        System.out.println(m2);


        //=========================================================================

        Pilote pi1 = new Pilote("Sullyvan", 33, 44, "Mobilite", 22);
        Pilote pi2 = new Pilote("Thomas", 53, 9, "Integrite", 44);

        System.out.println(pi1);
        System.out.println(pi2);

        // ajout heure vol
        pi1.setNombreHeuresDeVol(24);

        // Changement age
        pi2.setAge(68);

        System.out.println(pi1);
        System.out.println(pi2);
    }
}
