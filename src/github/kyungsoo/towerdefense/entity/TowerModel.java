package github.kyungsoo.towerdefense.entity;
/**
 * MVC ��Ű��ó (80�⵵�� ui �� �����ϸ鼭 ���� ��Ű��ó)
 * 
 * Model - ������ ������ ���� + �����͸� �ٷ�� ��Ģ, Circle, Rect, Triangle
 * 
 * 
 *     Controller - �̺�Ʈ 
 *     
 *     
 * View - model �� ȭ�鿡 �׸��� ���(������)  CircleUI, RectUI, ... 
 * 
 * @author KyungSooLee
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import github.kyungsoo.towerdefense.geom.Geom;
import github.kyungsoo.towerdefense.ui.User;



public class TowerModel
{
	
	// Router router = new Router(new double[] {100, 100} , new double[] {500, 500});
	User user = new User();
	Router[] routers;

	public Router[] assembleRouters(double[][] points)	//router ���� ����, next�� �Ѱ��ֱ�.
	{
		routers = new Router[points.length - 1]; // [ r1, r2, r3 ]
		for (int i = 0; i < points.length - 1; i++)
		{
			Router r = new Router(this, points[i], points[i + 1]);
			routers[i] = r;
			if (i > 0)
			{
				routers[i - 1].setNext(r);
			}

		}
		return routers;
	}
	
	public Router[] getRouters()
	{
		return routers;
	}
	
	/**
	 * ������ ũ��
	 */
	int width = 800;
	int height = 600;
	
	List<Gun> guns = new ArrayList<>();
	List<Enemy> enemies = new ArrayList<>();
	List<Bullet> bullets  = new ArrayList<>();
	
	
	public int getWidth()
	{
		return width;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	/**
	 * �־��� ��ġ�� ���� �߰��մϴ�.
	 * @param loc
	 */
	public void addGun(double[] loc)
	{
		Gun g = new Gun(Arrays.copyOf(loc, 2), 50, 120);
		guns.add(g);
	}
	public List<Gun> getGuns()
	{
		return guns;
	}
	
	
	
//	public void addEnemy(double[] loc)
//	{
//		Enemy e = new Enemy(loc, 50, 100, 10, 10);
//		this.addEnemy(e);
//	}
	public List<Enemy> getEnemys()
	{
		return enemies;
	}

	long prevTime = 0;
	
	int score = 0;
	
	public void updateGame(long curTime) // 212918292872
	{
		if ( prevTime == 0 ) {
			prevTime = curTime;
			return;
		}
		long dT = curTime - prevTime;
	//	System.out.println("DT:" + dT);
		//  212918292872 prevTime;
		//  212918292922 curTime;  dT = curTime - prevTime
		// 1. �Ѿ� ���
		generateBullet(enemies);
		
		//  2.1. HP ���� - 
		processAttack(bullets, enemies);
		//  2.2. �� ��� ó��
		flushEntities(bullets);
		flushEntities(enemies);
		
		// score ó��
	//	System.out.println("Score : " + score);
		
		
		
		//  2.2. �Ѿ� ���־� ��(����, ���� �������)
		// 3. �̵� ó��
		moveBullet(dT);
		moveEnemies(routers, curTime); 
//		System.out.println("bullet size: " + bullets.size());
//		System.out.println("gun    size: " + guns.size());
		prevTime = curTime;

	}
	


	void moveEnemies(Router [] routers, long curTime)
	{
		for(Router router : routers)
		{
			router.moveEntity(curTime);
		}
//		for(Enemy enemy : enemies)
//		{
//			router.moveEntity(enemy);
//		}
		
	}
	

	void updateScore()
	{
		/*
		 * �� �� �����ؾ������� �ϴ� ���������.
		 * ���߿� OBSERVER PATTERN �����ؼ� ���յ��� ���߸� ����!
		 */
		score++;
	}
	
	/*
	 * ���׸� ��� ���! 
	 */
	<T extends IEntity> void flushEntities(List<T> entities)
	{
		List<T> deleted = new ArrayList<T>();
		for(T entity : entities) // for ~ each�������� ������ ���� 
		{
			if(entity.getHP() <= 0)
			{
				// entities.remove(entity); // ������ ����ϴ�.
				deleted.add(entity);
				if(entity.getClass() == Enemy.class)
				{
					// score ó��
					updateScore();
					// updateStatusBar();
				}

			}
			double[] newCenter = entity.getCenter();
			if(newCenter[0] < 0 || newCenter[0] > this.width || newCenter[1] < 0 || newCenter[1] > this.height)
			{
				deleted.add(entity);
			}
		}
		
		entities.removeAll(deleted); // 
		
	}
	/**
	 * 
	 * @param dT - delta millisecond(���� �������� ��� �ð� )
	 */
	public void moveBullet(long dT)
	{
		for(AbstractEntity bullet : bullets)
		{
			// FIXME �����丵�� �� �ϸ� ����!
			// bullet.shiftLoc( dL );
			double L = bullet.getSpeed(); // �ʴ� �̵� �ȼ�
			double dL = L * dT / 1000;
			double dx = dL * Math.cos(bullet.getDegree());
			double dy = dL * Math.sin(bullet.getDegree());
			bullet.shiftLoc(dx, dy);
		}
	}
	
	public void processAttack(List<Bullet> bullets, List<Enemy> enemies)
	{
		for(Enemy enemy : enemies)
		{
			for(AbstractEntity bullet : bullets)
			{
				if(Geom.collide(enemy, bullet))
				{
					bullet.setHP(0);
					double newHP = enemy.getHP() - bullet.getPower();
					enemy.setHP(newHP);
				}
			}
		}
	}
	


	/*
	 * 1. ������ �Ѿ˿� ���ؼ�
	 * 2. ��Ÿ� ���� ������ Ȯ����(������
	 *    2.1. ������ ����
	 *    2.2. ������ �� �߿� �ϳ� pick!
	 *        Lm, Le �� �̿��ؼ� ���� ��Ƴ�
	 */
	public void generateBullet(List<Enemy> enemies)
	{
		for (Gun gun : guns)
		{	
			List<Enemy> attackable = inRangeEnemy(gun, enemies);
			if ( attackable.size() > 0 ) 
			{
				double deg = Geom.degToEnemy(gun, attackable.get(0));
				double range = 5;
				double hp = 20;
				double power = 5;
				double speed = 200;
				Bullet bullet = new Bullet(Arrays.copyOf(gun.loc, 2), range, hp, power, deg, speed);
				bullets.add(bullet);
			//	System.out.println("new bullet : " + bullet);
			}
		}
	}
	
	public List<Enemy> inRangeEnemy(Gun gun, List<Enemy> enemies) 
	{
		List<Enemy> Attackable = new ArrayList<Enemy>();
		
		for(Enemy enemy : enemies)
		{
			if(Geom.collide(gun, enemy)) 
			{
				Attackable.add(enemy);
			}
		}
		return Attackable;
	}
	public List<Bullet> getBullets()
	{
		
		return this.bullets;
	}
	public void addEnemy(Enemy enemy, long initTime)
	{
		this.enemies.add(enemy);
		this.routers[0].addEnemy(enemy, initTime);
	}

	public User getUser()
	{
		return this.user;
	}

	public boolean isGameOver()
	{
		return user.getLife() <= 0;
//		if(user.getLife() <= 0)
//		{
//			return true;
//		}
//		return false;
	}
	
	
	
	
	
	
	
}
 