package github.kyungsoo.towerdefense.geom;

import github.kyungsoo.towerdefense.entity.Enemy;
import github.kyungsoo.towerdefense.entity.Gun;
import github.kyungsoo.towerdefense.entity.IEntity;

public class Geom
{

	/**
	 * 
	 * @param a 길이가 2인  점
	 * @param b
	 * @return
	 */
	public static boolean collide( IEntity src, IEntity dest)
	{
		double distance; // 중점 사이의 거리
		double dx = src.getX() - dest.getX();
		double dy = src.getY() - dest.getY();
		double pow_distance = (dy * dy) + (dx * dx);
		distance = Math.sqrt(pow_distance);
		
		if(src.getRange() + dest.getRadius() >= distance ) 
		{
			System.out.println("OOO");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static double degToEnemy(Gun gun, Enemy enemy)
	{
		double dx = enemy.getX() - gun.getX();
		double dy = enemy.getY() - gun.getY();
		return Math.atan2(dy, dx);	//dy, dx
	}
}
