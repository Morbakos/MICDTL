


public class Test
{
	public static void main( String [] args )
	{
		Polygone c1;
		Polygone c2;
		
		PointPlan [] t = new PointPlan [3] ;
		t[0] = new PointPlan(2001,2000);
		t[1] = new PointPlan(2000, 2001);
		t[2] = new PointPlan(2001,2001);

		PointPlan [] q = new PointPlan [4] ;
		q[0] = new PointPlan(1,1);
		q[1] = new PointPlan(1000, 1);
		q[2] = new PointPlan(1000,1000);
		q[3] = new PointPlan(1,1000);
		
		try
		{
			c1 = new Triangle( t, 150);
			c2 = new Quadrilatère( q, 150);
			if (c1.compareTo(c2)==1)
				System.out.println("Supérieur strict");
			else
				System.out.println("Inférieur ou égal");
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
	}
}


