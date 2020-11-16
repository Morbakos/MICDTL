public class TestVolEnFormation {
    public static void main(String[] args) {
        Vaisseau v1 = new Vaisseau("Croiseur", 4, 6800);
        Vaisseau v2 = new Vaisseau("Destroyer", 10, 15000);
        Vaisseau v3 = new Vaisseau("Transport", 6000, 5400);

        Vaisseau[] listeVaisseaux = new Vaisseau[3];
        listeVaisseaux[0] = v1;
        listeVaisseaux[1] = v2;
        listeVaisseaux[2] = v3;

        PointPlan position = new PointPlan();

        VolEnFormation formation = new VolEnFormation(listeVaisseaux, position, 1600);

        for (int i = 0; i < listeVaisseaux.length; i++) {
            System.out.println(listeVaisseaux[i].toString());
        }

        formation.appliqueAltitudeDeVol(167000);
        double[] altitudesVaisseaux = formation.altitudesDesVaisseaux();

        for (int i = 0; i < altitudesVaisseaux.length; i++) {
            if (altitudesVaisseaux[i] != 167000) {
                System.out.println("Correction de l'altitude pour le vaisseau " + i);
                listeVaisseaux[i].setAltitude(167000);
            } else {
                System.out.println("Altitude OK pour le vaisseau " + i);
            }
        }

        v3.setCatégorie("Super Carrier");

        System.out.println(formation.toString());
    }
}
