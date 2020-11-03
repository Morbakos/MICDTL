public class Droid
{
    private String modele;
    private int taille;

    public Droid (){
        /*this.setModele("Modèle par défaut");
        this.setTaille(0);*/
        this("Modèle par défaut", 0);
    }

    public Droid (String mod, int t){
        this.setModele(mod);
        this.setTaille(t);
    }

    public void setModele(String modele){
        this.modele = modele;
    }
    public String getModele(){
        return this.modele ;
    }
    public void setTaille(int taille){
        this.taille = taille;
    }
    public int getTaille(){
        return this.taille ;
    }
}
