package github.kyungsoo.towerdefense.entity;

public class Enemy extends AbstractEntity
{

	protected Enemy(double[] loc, double range, double hp)
	{
		super(loc, range, range, hp, 0);
	}
	
	private int ss;

}
