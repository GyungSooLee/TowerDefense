package routers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import github.kyungsoo.towerdefense.entity.Router;

class RouterTest
{

	@Test
	void test()
	{
		Router [] routers = assembleRouters(new double[][] {
			{0, 0},
			{100, 100},
			{100, 300},
			{400, 600}
		});
		
		assertEquals(3, routers.length);
		// Router temp = routers[0].getNext();
		// boolean yes = routers[1] == temp;
		assertTrue(routers[1] == routers[0].getNext());
		assertTrue(routers[2] == routers[1].getNext());
		assertTrue ( routers[2].getNext() == null);
	}

	Router [] assembleRouters(double [][] points) {       //               V
		Router[] routers = new Router[points.length - 1]; // [ r1, r2, r3 ]
		for(int i = 0; i < points.length - 1; i++)
		{
			Router r = new Router(null, points[i], points[i + 1]);
			routers[i] = r;
			if(i > 0)
			{
				routers[i - 1].setNext(r);
			}

		}
		return routers;
	}
}
