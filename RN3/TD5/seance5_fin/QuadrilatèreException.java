
/**
 * Exception levée par la classe Quadrilatère
 * @version 1.0
 * @author Guillaume Santini
 */
public class QuadrilatèreException extends Exception
{
	public QuadrilatèreException( int n )
	{
		super( "Un quadrilatère ne peut être initialisé qu'avec 4 sommets. Le constructeur a été appelé avec "+n+" sommets." );
	}
}
