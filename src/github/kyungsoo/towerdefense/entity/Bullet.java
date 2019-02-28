package github.kyungsoo.towerdefense.entity;

public class Bullet extends AbstractEntity
{
	protected double degree;
	/**
	 * 초당 이동 픽셀
	 */
	protected double speed;
	protected Bullet(double[] loc, double range, double hp, double power, double degree, double speed)
	{
		super(loc, range, range, hp, power);
		this.degree = degree;
		this.speed = speed;
	}
	
	@Override
	public double getSpeed()
	{
		return this.speed;
	}
	
	@Override
	public double getDegree()
	{
		return this.degree;
	}
	public void setHP(double hp)
	{
		this.hp = hp;
	}



}
