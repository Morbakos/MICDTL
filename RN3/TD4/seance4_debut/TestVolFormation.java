import java.util.Scanner;

public class TestVolFormation {
    public static void main(String[] args) {
        Vaisseau[] tabVaisseaux = new Vaisseau[10];

        for (int i = 0; i < tabVaisseaux.length; i++) {
            tabVaisseaux[i] = new Vaisseau();
            tabVaisseaux[i].initRandom();
        }

        PointPlan positionFormation = new PointPlan();

        VolEnFormation volFormation = new VolEnFormation(tabVaisseaux, positionFormation, 4600);

        System.out.println(volFormation);

        Vaisseau vRandom = new Vaisseau();
        vRandom.initRandom();

        Scanner sc = new Scanner(System.in);
        int posVaisseau = sc.nextInt();

        tabVaisseaux[posVaisseau] = vRandom;
    }
}