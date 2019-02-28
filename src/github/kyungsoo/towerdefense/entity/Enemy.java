package github.kyungsoo.towerdefense.entity;

public class Enemy extends AbstractEntity
{

	double dx;
	double dy;
	
	public Enemy(double[] loc, double range, double hp, int dx, int dy)
	{
		super(loc, range, range, hp, 0);
		this.dx = dx;
		this.dy = dy;
	}
	
	private int ss;

	@Override
	public double[] getDelta()
	{
		return new double [] {dx, dy};
	}


}
