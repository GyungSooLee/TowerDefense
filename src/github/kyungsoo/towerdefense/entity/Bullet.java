package github.kyungsoo.towerdefense.entity;

public class Bullet extends AbstractEntity
{
	protected double degree;
	protected Bullet(double[] loc, double range, double power, double degree)
	{
		super(loc, range, range, 0, power);
		this.degree = degree;
	}

}
