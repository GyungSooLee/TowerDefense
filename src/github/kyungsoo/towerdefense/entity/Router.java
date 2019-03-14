package github.kyungsoo.towerdefense.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import github.kyungsoo.towerdefense.ui.User;

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

	TowerModel model; // Ŭ�������� ���ϰ� ���յǰ� ���� (������)
	
	double [] spoint;
	double [] epoint;
	
	long duration = 4*1000;	//spoint���� epoint���� �ɸ��� �ð�.
	// LinkedList<Router> routers ;
	Router next;
	
	// List<Enemy> enemies = new ArrayList<>();
	
	Map<Enemy, Long> enemies = new HashMap<Enemy, Long>();//Python(=dictionary)
	
	// 
	
	public Router(TowerModel model, double [] s, double [] e) {
		this.model = model;
		spoint  = s;
		epoint = e;
	}
	
	public void moveEntity (long curTime ) {
		// (curTime - initTime)
		/*
		 * (ct - it)
		 * -------- = delta
		 *  10*1000
		 */
		// entity.shiftLoc(delta[0], delta[1]);
		double intervalTime = 0;
		List<Enemy> deleted = new ArrayList<Enemy>(); 
		for(Enemy e : enemies.keySet()) {
			if(e.getHP() <= 0)
			{
				deleted.add(e);
				continue;
			}
			long initTime = enemies.get(e);
			intervalTime = curTime - initTime;
			if( intervalTime >= this.duration )
			{
				if ( next != null ) {
					next.addEnemy(e, curTime); //
				} 
				else 
				{
					// TODO LIFE ��ƾ��� !
					System.out.println("goal in! ");
					User user = model.getUser();
					user.decreaseLife(1);
					
				}
				// enemies.remove(e); // ������ �߻������� ��! ConcurrentModificationException
				deleted.add(e);
			}
			else 
			{
				double t = intervalTime / duration;	//(0 < t < 1)
				double LX = (epoint[0] - spoint[0]) * t;
				double LY = (epoint[1] - spoint[1]) * t;
				double tempLoc[] = new double[] {spoint[0] + LX, spoint[1] + LY};
				e.setLocation(tempLoc);
			}
		}
		enemies.keySet().removeAll(deleted);
		
	}

	public void setNext(Router r)
	{
		next = r;
		// TODO Auto-generated method stub
		
	}

	public Router getNext()
	{
		return next;
		// TODO Auto-generated method stub
		
	}

	public int getX1()
	{
		// TODO Auto-generated method stub
		return (int) spoint[0];
	}

	public int getY1()
	{
		// TODO Auto-generated method stub
		return (int) spoint[1];
	}

	public int getX2()
	{
		// TODO Auto-generated method stub
		return (int) epoint[0];
	}
	
	public int getY2()
	{
		// TODO Auto-generated method stub
		return (int) epoint[1];
	}

	public void addEnemy(Enemy enemy, long initTime)
	{
		// this.enemies.add(enemy);
		this.enemies.put(enemy, initTime);
		enemy.setLocation(spoint);
	}
}
