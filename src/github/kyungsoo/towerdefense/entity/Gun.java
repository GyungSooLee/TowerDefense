package github.kyungsoo.towerdefense.entity;

public class Gun extends AbstractEntity
{

	private final static double DEFAULT_HP = 100;
	private final static double DEFAULT_POWER = 2;
	public Gun(double [] loc, double radius, double range)
	{
		super(loc, radius, range, DEFAULT_HP, DEFAULT_POWER);
	}	
	
}
