package github.kyungsoo.towerdefense.entity;
/**
 * MVC 아키텍처 (80년도에 ui 가 등장하면서 나온 아키텍처)
 * 
 * Model - 순수한 데이터 집합 + 데이터를 다루는 규칙, Circle, Rect, Triangle
 * 
 * 
 *     Controller - 이벤트 
 *     
 *     
 * View - model 을 화면에 그리는 방식(렌더링)  CircleUI, RectUI, ... 
 * 
 * @author KyungSooLee
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import github.kyungsoo.towerdefense.geom.Geom;



public class TowerModel
{
	
	Router router = new Router(new double[] {10, 10} , new double[] {500, 500});

	/**
	 * 게임판 크기
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
	 * 주어전 위치에 총을 추가합니다.
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
	
	
	
	public void addEnemy(double[] loc)
	{
		Enemy e = new Enemy(loc, 50, 100, 10, 10);
		this.addEnemy(e);
	}
	public List<Enemy> getEnemys()
	{
		return enemies;
	}

	long prevTime = 0;
	public void updateGame(long curTime) // 212918292872
	{
		if ( prevTime == 0 ) {
			prevTime = curTime;
			return;
		}
		long dT = curTime - prevTime;
		System.out.println("DT:" + dT);
		//  212918292872 prevTime;
		//  212918292922 curTime;  dT = curTime - prevTime
		// 1. 총알 등록
		generateBullet(enemies);
		
		//  2.1. HP 감소 - 
		processAttack(bullets, enemies);
		//  2.2. 적 사망 처리
		flushEntities(bullets);
		flushEntities(enemies);
		
		
		
		//  2.2. 총알 없애야 함(적중, 범위 벗어났을때)
		// 3. 이동 처리
		moveBullet(dT);
		moveEnemies(router);
//		System.out.println("bullet size: " + bullets.size());
//		System.out.println("gun    size: " + guns.size());
		prevTime = curTime;
	}
	void moveEnemies(Router router)
	{
		for(Enemy enemy : enemies)
		{
			router.moveEntity(enemy);
		}
		
	}
	/*
	 * 제네릭 고급 기법! 
	 */
	<T extends IEntity> void flushEntities(List<T> entities)
	{
		List<T> deleted = new ArrayList<T>();
		for(T entity : entities) // for ~ each문에서는 삭제를 못함 
		{
			if(entity.getHP() <= 0)
			{
				// entities.remove(entity); // 오류가 생깁니다.
				deleted.add(entity);
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
	 * @param dT - delta millisecond(현재 프레임의 경고 시간 )
	 */
	public void moveBullet(long dT)
	{
		for(AbstractEntity bullet : bullets)
		{
			// FIXME 리팩토링을 좀 하면 좋음!
			// bullet.shiftLoc( dL );
			double L = bullet.getSpeed(); // 초당 이동 픽셀
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
	 * 1. 각각의 총알에 대해서
	 * 2. 사거리 내의 적들을 확보함(여러개
	 *    2.1. 없으면 리턴
	 *    2.2. 있으면 그 중에 하나 pick!
	 *        Lm, Le 를 이용해서 각도 잡아냄
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
				System.out.println("new bullet : " + bullet);
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
	public void addEnemy(Enemy enemy)
	{
		this.enemies.add(enemy);
		
	}
	
	
	
	
	
}
 