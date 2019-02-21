package github.kyungsoo.towerdefense.entity;

public abstract class AbstractEntity implements IEntity
{
	protected double loc[] = new double[2];
	protected double range;
	protected double hp;
	protected double power;
	protected double radius;
	

	// public AbstractEntity() {}
	// Alt+Shift+S 
	protected AbstractEntity(double[] loc, double radius, double range, double hp, double power)
	{
		// super();
		this.loc = loc;
		this.radius = radius;
		this.range = range;
		this.hp = hp;
		this.power = power;
	}

	@Override
	public double getX()
	{
		return this.loc[0];
	}

	@Override
	public double getY()
	{
		return this.loc[1];
	}

	@Override
	public double getHP()
	{
		return this.hp;
	}

	@Override
	public double getPower()
	{
		
		return this.power;
	}

	@Override
	public double getSpeed()
	{
		throw new RuntimeException("이거 안쓸거 같음!");
	}

	@Override
	public double getDegree()
	{
		throw new RuntimeException("이거 안쓸거 같음!");
	}

	@Override
	public double getRange()
	{
		return this.range;
	}
	@Override
	public double getRadius()
	{
		return this.radius;
	}


}
