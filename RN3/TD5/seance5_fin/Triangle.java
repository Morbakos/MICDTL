/**
 * Décrit un triangle dans le plan 2D
 * @version 1.0
 * @author Guillaume Santini
 */
public class Triangle extends Polygone
{	
	public Triangle(PointPlan [] listeDePoints, int niveau) throws TriangleException
	{
		super(listeDePoints, niveau);	
		if ( listeDePoints.length != 3  ) 
			throw new TriangleException( listeDePoints.length ) ; 
	}
	
}
