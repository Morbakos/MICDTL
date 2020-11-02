import java.util.Hashtable;

public class Banque
{
	
	private Hashtable<String, Compte> hashtable;

	public Banque () {
		this.hashtable = new Hashtable<String, Compte>();
	}

	public void ouvrirCompte(String nom, String password) throws Exception
	{
		Compte compteExiste = this.hashtable.get(nom);
		if ( compteExiste != null) {
			throw new Exception("Le compte existe déjà !");
		} else {
			Compte nouveauCompte = new Compte (nom, password, 0);
			this.hashtable.put(nom, nouveauCompte);
		}
	}

	public Compte verifie(String nom, String password) throws Exception
	{
		Compte compte = this.hashtable.get(nom);
		if (compte != null) {
			System.out.println("Compte trouvé");
			if (compte.getPassword().equals(password)) {
				return compte;
			} else {
				throw new Exception("Le mot de passe n'est pas correct.");	
			}
		} else {
			throw new Exception("Le compte n'existe pas !");
		}
	}

	public int fermerCompte(String nom, String password) throws Exception
	{
		Compte compte = this.verifie(nom, password);
		this.hashtable.remove(nom);
		return compte.getSolde();
	}

	public void deposer(int somme, Compte c)
	{
		c.additionSolde(somme);
	}

	public int retirer(int somme, Compte c)
	{
		c.soustractionSolde(somme);
		return c.getSolde();
	}

	public int solde(Compte c)
	{
		return c.getSolde();
	}
}