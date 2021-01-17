




public class PointPolaire
{
	// ---------------------------------------------------
	// Variables d'instance
	private double module ;
	private double argument ;

	// ---------------------------------------------------
	// Constructeurs
	public PointPolaire( double mod, double arg)
	{
		this.module = mod ;
		this.argument = arg ;
	}

	// ---------------------------------------------------
	// Accesseur Getter/Setter
	public void setModule(double mod)
	{
			this.module = mod;
	}

	public double getModule()
	{
		return this.module;
	}

	public void setArgument(double arg)
	{
		this.argument = arg;
	}
	
	public double getArgument()
	{
		return this.argument;
	}

	// ---------------------------------------------------
	// Méthodes génériques

	public String toString()
	{
		return( " (Arg = " + this.getArgument() +
				", Mod = " + this.getModule() + ")" );
	}
	public boolean equals(Object o)
	{
		if ( ! ( o instanceof PointPolaire ) ) 
			return false ;
		PointPolaire p = (PointPolaire) o ;
		return ( p.getModule()==this.getModule() &&
				 p.getArgument() == this.getArgument()) ;
	}
}

