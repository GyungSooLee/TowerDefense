package github.kyungsoo.towerdefense.entity;

import java.util.LinkedList;

/**
 * dx, dy�� �����ؼ� enemy �̵���Ŵ
 * 
 * enemy �� end point �� �����ϸ� ���� router���� enemy�� ������
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
		double [] delta  = entity.getDelta(); // FIXME delta�� router�� �Űܾ���!
		entity.shiftLoc(delta[0], delta[1]);
		
	}
}
