package github.kyungsoo.towerdefense.ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import github.kyungsoo.towerdefense.entity.Bullet;
import github.kyungsoo.towerdefense.entity.Enemy;
import github.kyungsoo.towerdefense.entity.Gun;
import github.kyungsoo.towerdefense.entity.Router;
import github.kyungsoo.towerdefense.entity.TowerModel;

public class ShapePanel extends JComponent implements MouseListener
{
	/*
	 * 객체 직렬화해서 복원할때 사용하는 괴상한 값입니다!
	 */
	private static final long serialVersionUID = -208805581528987250L;

	int margin = 0;
	
	ArrayList<ShapeUI> shapes= new ArrayList<>();
	
	ShapeUI activeShape = null;

	volatile TowerModel model;
	
	
	public ShapePanel(TowerModel model)
	{	
		this.model = model;
		setOpaque(true);
		this.addMouseListener(this);
		
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		// Graphics g - 붓이라고 생각하면 됩니다.
		// super.paintComponents(g);
		int W = this.getWidth();
		int H = this.getHeight();
		// 배경색
		g.setColor(Color.GREEN);
		g.fillRect(margin, margin, W - margin * 2, H - margin * 2);
		
		int gameW = model.getWidth();
		int gameH = model.getHeight();
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, gameW, gameH);
		
		if ( this.model != null ) {
			// gun 칠하기
			List<Gun> guns = this.model.getGuns();
			renderGuns(g, guns);
			
			List<Enemy> enemies = model.getEnemys();
			renderEnemies(g, enemies);
			
			List<Bullet> bullets = model.getBullets();
			renderBullets(g, bullets);
			System.out.printf("G:%d, E:%d, B:%d", guns.size(), enemies.size(), bullets.size() );
			
			Router[] routers = model.getRouters();
			renderRouters(g, routers);
			
			renderUser(g, model);
			
			gameOver(g, model.isGameOver());
			
		}
		
		// enemy 칠하기
		
		// bullet 칠하기
		
		// 경로 칠하기
		
		
	}
	
	private void gameOver(Graphics g, boolean gameOver)
	{
		if ( gameOver) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("courier new", Font.BOLD, 50));
			g.drawString("GAME OVER!", 300, 400);
		}
		
	}

	private void renderUser(Graphics g, TowerModel model)
	{
		int life = model.getUser().getLife();
		String lifeStr = "LIFE : " + life; //
		g.setColor(Color.BLACK);
		g.setFont(new Font("courier new", Font.BOLD, 20));
		g.drawString(lifeStr, 10, 28);
	}

	private void renderRouters(Graphics g, Router[] routers)
	{
		g.setColor(Color.RED);
		for(int i = 0; i < routers.length; i++)
		{
			g.drawLine(routers[i].getX1(), routers[i].getY1(), routers[i].getX2(), routers[i].getY2());
		}
		// TODO Auto-generated method stub
		
	}

	private void renderBullets(Graphics g, List<Bullet> bullets)
	{
		CircleUI ui = new CircleUI(null, Color.BLACK, Color.BLACK);
		for(int i = 0; i < bullets.size(); i++)
		{
			ui.setTarget(bullets.get(i));
			ui.draw(g);
		}	
	}
	

	void renderEnemies(Graphics g, List<Enemy> enemies)
	{
		CircleUI ui = new CircleUI(null, Color.RED, Color.BLACK);
		for(int i = 0; i < enemies.size(); i++)
		{
			ui.setTarget(enemies.get(i));
			ui.draw(g);
		}	
	}

	void renderGuns(Graphics g, List<Gun> guns)
	{
//		CircleUI ui = new CircleUI(null, Color.RED, Color.BLACK);
		GunUI ui = new GunUI(null, Color.YELLOW, Color.BLACK);
		for(int i = 0; i < guns.size(); i++)
		{
			ui.setTarget(guns.get(i));
			ui.draw(g);
		}
	}

	private void renderActiveShape(Graphics g)
	{
		if ( this.activeShape == null ) {
			return ;
		}
		System.out.println("active shape: " + activeShape);
		double [] box = activeShape.getBoxArea();
		System.out.println("            : " + Arrays.toString(box));
		g.setColor(Color.BLACK);
		g.drawRect((int)box[0], (int)box[1], 
				(int)(box[2]-box[0]), (int)(box[3]-box[1]));
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		System.out.println("clicked: " + e.getX() + ", " + e.getY());
		double xPoint;
		double yPoint;
		
		xPoint = e.getX();
		yPoint = e.getY();
//		double loc[] = new double[] {xPoint, yPoint};
		double loc[] = {xPoint, yPoint};
		
		model.addGun(loc);
		// repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	public List<ShapeUI> getShapes()
	{
		// TODO Auto-generated method stub
		return this.shapes;
	}

	public void addShape(ShapeUI shape)
	{
		shapes.add(shape);
		// TODO Auto-generated method stub
		
	}

	public void update(TowerModel model)
	{
		this.model = model;
		repaint();
		
	}
}
