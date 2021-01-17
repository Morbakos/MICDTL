/**
 * Décrit un quadrilatère dans le plan 2D
 * @version 1.0
 * @author Guillaume Santini
 */
public class Quadrilatère extends Polygone
{	
	public Quadrilatère(PointPlan [] listeDePoints, int niveau) throws QuadrilatèreException
	{
		super(listeDePoints, niveau);	
		if ( listeDePoints.length != 4  ) 
			throw new QuadrilatèreException( listeDePoints.length ) ; 
	}
	
}
