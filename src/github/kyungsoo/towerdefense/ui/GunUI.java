package github.kyungsoo.towerdefense.ui;

import java.awt.Color;
import java.awt.Graphics;

import github.kyungsoo.towerdefense.entity.Gun;
import github.kyungsoo.towerdefense.entity.IEntity;

public class GunUI extends CircleUI
{

	public GunUI(Gun target, Color bgColor, Color lineColor)
	{
		super(target, bgColor, lineColor);
	}
	
	@Override
	public void draw(Graphics g)
	{
		super.draw(g);
		IEntity gun = this.getTarget();
		double range = gun.getRange();
		double xPoint = gun.getX();
		double yPoint = gun.getY();
		
		g.drawOval((int)(xPoint - range), (int)(yPoint - range), (int)(2 * range), (int)(2 * range));
	}

}
