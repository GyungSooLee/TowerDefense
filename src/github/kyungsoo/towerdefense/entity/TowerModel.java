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
import java.util.List;

public class TowerModel
{

	List<Gun> guns = new ArrayList<>();
	List<Enemy> enemies = new ArrayList<>();
	List<Bullet> bullets  = new ArrayList<>();
	/**
	 * �־��� ��ġ�� ���� �߰��մϴ�.
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
		// 1. �Ѿ� ���
		generateBullet();
		// 2. �� ��� ó��
		//  2.1. HP ���� - 
		//  2.2. �Ѿ� ���־� ��(����, ���� �������
		// 3. �� �̵� ��Ŵ
		
	}
	/*
	 * 1. ������ �Ѿ˿� ���ؼ�
	 * 2. ��Ÿ� ���� ������ Ȯ����(������
	 *    2.1. ������ ����
	 *    2.2. ������ �� �߿� �ϳ� pick!
	 *        Lm, Le �� �̿��ؼ� ���� ��Ƴ�
	 */
	void generateBullet()
	{
		for (Gun gun : guns)
		{	
			// if()
		}
		
	}
	
	
	
	
	
}
 