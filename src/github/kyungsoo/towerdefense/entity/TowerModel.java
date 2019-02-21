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
import java.util.List;

public class TowerModel
{

	List<Gun> guns = new ArrayList<>();
	List<Enemy> enemies = new ArrayList<>();
	List<Bullet> bullets  = new ArrayList<>();
	/**
	 * 주어전 위치에 총을 추가합니다.
	 * @param loc
	 */
	public void addGun(double[] loc)
	{
		Gun g = new Gun(loc, 50, 120);
		guns.add(g);
	}
	public List<Gun> getGuns()
	{
		return guns;
	}
	
	
	
	public void addEnemy(double[] loc)
	{
		Enemy e = new Enemy(loc, 50, 100);
		enemies.add(e);
	}
	public List<Enemy> getEnemys()
	{
		return enemies;
	}
	public void updateGame()
	{
		// 1. 총알 등록
		generateBullet();
		// 2. 적 사망 처리
		//  2.1. HP 감소 - 
		//  2.2. 총알 없애야 함(적중, 범위 벗어났을때
		// 3. 적 이동 시킴
		
	}
	/*
	 * 1. 각각의 총알에 대해서
	 * 2. 사거리 내의 적들을 확보함(여러개
	 *    2.1. 없으면 리턴
	 *    2.2. 있으면 그 중에 하나 pick!
	 *        Lm, Le 를 이용해서 각도 잡아냄
	 */
	void generateBullet()
	{
		for (Gun gun : guns)
		{	
			// if()
		}
		
	}
	
	
	
	
	
}
 