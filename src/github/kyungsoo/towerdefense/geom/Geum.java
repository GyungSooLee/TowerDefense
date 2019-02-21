package github.kyungsoo.towerdefense.geom;

import github.kyungsoo.towerdefense.entity.IEntity;

public class Geum
{

	/**
	 * 
	 * @param a ���̰� 2��  ��
	 * @param b
	 * @return
	 */
	public boolean collide( IEntity gun, IEntity enemy) 
	{
		double distance; // ���� ������ �Ÿ�
		double dx = gun.getX() - enemy.getX();
		double dy = gun.getY() - enemy.getY();
		double pow_distance = (dy * dy) + (dx * dx);
		distance = Math.sqrt(pow_distance);
		
		if(gun.getRange() + enemy.getRadius() >= distance ) 
		{
			System.out.println("OOO");
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
