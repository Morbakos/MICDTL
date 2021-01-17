
/**
 * Exception levée par la classe Triangle
 * @version 1.0
 * @author Guillaume Santini
 */
public class TriangleException extends Exception
{
	public TriangleException( int n )
	{
		super( "Un triangle ne peut être initialisé qu'avec 3 sommets. Le constructeur a été appelé avec "+n+" sommets." );
	}
}
