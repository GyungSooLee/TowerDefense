package github.kyungsoo.towerdefense.entity;
/**
 * 
 *              R
 *       +---------------+
 *       (x1,y1)
 *       
 * 20% -> 
 * @author KyungSooLee
 *
 */
public class Circle extends Shape
{
	// final double PI = 3.14;
	
	private double x1, y1;
	private double r;
	
	/*
	 * 아무것도 안붙이면 디폴드 - package private이라고 얘기합니다.
	 */
	public Circle(double x1, double y1, double r) {
		this.x1 = x1;
		this.y1 = y1;
		this.r = r;
	}
	
	public double getCenterX()
	{
		return x1;
	}
	
	public double getCenterY()
	{
		return y1;
	}
	
	public void setCenterX(double x)
	{
		this.x1 = x;
	}
	
	public void setCenterY(double y)
	{
		this.y1 = y;
	}
	
	
	@Override
	public double getArea()
	{
		double area = 0;
		area = Math.PI * r * r;
		return area;
	}

	@Override
	public double getAround()
	{
		double around = 0;
		around = Math.PI * 2 * r;
		// TODO Auto-generated method stub
		return around;
	}
	
	public double getLeftX()
	{
		return (this.x1 - this.r);
	}
	public double getTopY()
	{
		return (this.y1 - this.r);
	}
	
	public double getRadius() {
		return this.r;
	}
	
	public double width()
	{
		return (2 * this.r);
	}
	
	public double height()
	{
		return (2 * this.r);
	}

	@Override
	public String toString()
	{
		return "Circle [x1=" + x1 + ", y1=" + y1 + ", r=" + r + "]";
	}
	
	

}
