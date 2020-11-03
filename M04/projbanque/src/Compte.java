public class Compte
{
	private String nomProprietaire;
	private String password;
	private int soldeCompte;

	public Compte (String nomProp, String pass, int soldeInitial)
	{
		this.nomProprietaire = nomProp;
		this.password = pass;
		this.soldeCompte = soldeInitial;
	}

	public String getProprietaire ()
	{
		return this.nomProprietaire;
	}

	public void setProprietaire (String nouveauProp)
	{
		this.nomProprietaire = nouveauProp;
	}


	public String getPassword ()
	{
		return this.password;
	}

	public void setPassword (String nouveauPassword)
	{
		this.password = nouveauPassword;
	}


	public int getSolde () 
	{
		return this.soldeCompte;
	}

	public void setSolde (int nouveauSolde)
	{
		this.soldeCompte = nouveauSolde;
	}

	public void additionSolde (int somme)
	{
		this.soldeCompte += somme;
	}

	public void soustractionSolde (int somme)
	{
		this.soldeCompte -= somme;
	}

}