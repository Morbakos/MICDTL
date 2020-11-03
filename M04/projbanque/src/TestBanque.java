public class TestBanque
{
	public static void main(String[] args) throws Exception{
		

		Banque banque = new Banque();

		banque.ouvrirCompte("MaTiteNoble", "MonTitMilitaire");

		Compte monCompte = banque.verifie("MaTiteNoble", "MonTitMilitaire");
		System.out.println("Votre compte possède un solde de " + banque.solde(monCompte) + "€");
	}
}