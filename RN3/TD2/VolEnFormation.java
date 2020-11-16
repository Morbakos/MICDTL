public class VolEnFormation {

    private Vaisseau[] vaisseaux;
    private PointPlan position;
    private double altitudeVol;

    public VolEnFormation(Vaisseau[] vaisseaux, PointPlan position, double altitudeVol) {
        this.setTab(vaisseaux);
        this.setPosition(position);
        this.setAltitudeVol(altitudeVol);
    }

    public VolEnFormation(VolEnFormation volCopie) {

        position = new PointPlan(volCopie.position);
        altitudeVol = volCopie.altitudeVol;

        this.vaisseaux = new Vaisseau[volCopie.vaisseaux.length];
        for (int i = 0; i < volCopie.vaisseaux.length; i++) {
            vaisseaux[i] = new Vaisseau(volCopie.vaisseaux[i]);
        }
    }

    public void setTab(Vaisseau[] tab) {
        this.vaisseaux = tab;
    }

    public void setPosition(PointPlan position) {
        this.position = position;
    }

    public void setAltitudeVol(double altitudeVol) {
        this.altitudeVol = altitudeVol;
    }

    public Vaisseau[] getTab() {
        return this.vaisseaux;
    }

    public PointPlan getPosition() {
        return this.position;
    }

    public double getAltitudeVol() {
        return this.altitudeVol;
    }

    public int nbDeVaisseaux() {
        return this.vaisseaux.length;
    }

    public String toString() {
        String resultat = "Le vol en formation contient " + this.nbDeVaisseaux() + " vaisseaux, vole à " + this.getAltitudeVol()
                + "m d'altitudes, est situé en " + this.position.toString() + "et est composé de :\n";
        for (int i = 0; i < this.nbDeVaisseaux(); i++) {
            resultat = resultat + this.vaisseaux[i].toString() + "\n";
        }

        return resultat;
    }

    private boolean altitudeValide(double alt) {
        if (alt > 0) {
            return true;
        } else {
            return false;
        }

    }

    public void appliqueAltitudeDeVol (double alt){
        if (this.altitudeValide(alt)) {
            this.altitudeVol = alt;
            for (int i = 0; i < this.vaisseaux.length; i++) {
                vaisseaux[i].setAltitude(alt);
            }
        }
    }

    public double[] altitudesDesVaisseaux(){
        double[] altitudes = new double[this.vaisseaux.length];
        for (int i = 0; i < this.vaisseaux.length; i++) {
            altitudes[i] = this.vaisseaux[i].getAltitude();
        }
        return altitudes;
    }

}