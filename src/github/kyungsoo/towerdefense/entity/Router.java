package github.kyungsoo.towerdefense.entity;

import java.util.LinkedList;

/**
 * dx, dy값 설정해서 enemy 이동시킴
 * 
 * enemy 가 end point 에 도착하면 다음 router한테 enemy를 전달함
 * 
 * @author KyungSooLee
 *
 */
public class Router
{

	double [] spoint ;
	double [] epoint;
	
	LinkedList<Router> routers ;
	
	
	public Router(double [] s, double [] e) {
		spoint  = s;
		epoint = e;
	}
	
	public void moveEntity ( IEntity entity) {
		double [] delta  = entity.getDelta(); // FIXME delta는 router로 옮겨야함!
		entity.shiftLoc(delta[0], delta[1]);
		
	}
}
