package geom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import github.kyungsoo.towerdefense.entity.Enemy;
import github.kyungsoo.towerdefense.entity.Gun;
import github.kyungsoo.towerdefense.geom.Geom;

class GeomTest
{

	@Test
	void test()
	{
		Geom g = new Geom();
		Gun gun = new Gun(new double[] {300, 600}, 0, 0);
		Enemy enemy = new Enemy(new double[] {600, 300}, 0, 0, 10, 10);
		double rad = g.degToEnemy(gun, enemy);
		double deg = Math.toDegrees(rad);
		System.out.println(deg);
		
	}

}
