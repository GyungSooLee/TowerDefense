package github.kyungsoo.towerdefense.ui;
import java.awt.Color;
import java.awt.Graphics;

import github.kyungsoo.towerdefense.entity.Circle;
import github.kyungsoo.towerdefense.entity.Gun;
import github.kyungsoo.towerdefense.entity.IEntity;

public class CircleUI extends ShapeUI
{

	private IEntity target;
	private Color bgColor;
	private Color lineColor;
	private double radius = 20; 
	
	public CircleUI(IEntity target, Color bgColor, Color lineColor)
	{
		this.target = target;
		this.bgColor = bgColor;
		this.lineColor = lineColor;
	}

	public IEntity getTarget()
	{
		return target;
	}
	
	public void draw(Graphics g) {
		// 배경색 칠하기
		g.setColor(bgColor);
		g.fillOval((int)(target.getX() - radius), (int)(target.getY() - radius), (int)(this.radius * 2), (int)(this.radius * 2));
		// 라인 색 칠하기
		g.setColor(lineColor);
		g.drawOval((int)(target.getX() - radius), (int)(target.getY() - radius), (int)(this.radius * 2), (int)(this.radius * 2));
	}

	@Override
	public boolean contains(int x, int y)
	{
//		double cx = target.getCenterX();
//		double cy = target.getCenterY();
//		double sqrSum = (cx - x) * (cx - x) + (cy - y) * (cy - y);
//		
//		if(Math.sqrt(sqrSum) >= target.getRadius())
//		{
//			return false;
//		}
//		// TODO Auto-generated method stub
//		return true;
		throw new RuntimeException("확인 필요함");
	}
	
	@Override
	public String toString()
	{
		return this.target.toString();
	}

	@Override
	protected double[] getBoxArea()
	{
//		double r2 = this.target.getRadius() * 2;
//		return new double [] { 
//				target.getLeftX(), target.getTopY(), 
//				target.getLeftX() + r2, target.getTopY() + r2};
		throw new RuntimeException("확인 필요함");
	}

	public void setTarget(IEntity entity)
	{		
		this.target = entity;
	}
}
