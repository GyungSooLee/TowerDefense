package github.kyungsoo.towerdefense.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import github.kyungsoo.towerdefense.entity.Circle;
import github.kyungsoo.towerdefense.entity.Enemy;
import github.kyungsoo.towerdefense.entity.Router;
import github.kyungsoo.towerdefense.entity.TowerModel;

/**
 * 
 * 
 * 
 *   +----------------------------+
 *   |                            |
 *   |                            |
 *   |                            |
 *   |                            |
 *   |     shape panel            |
 *   |                            |
 *   |                            |
 *   |                            |
 *   +----------------------------+
 *   |     control panel          |
 *   |                            |
 *   +----------------------------+
 * @author KyungSooLee
 *
 */
public class MainFrame extends  JFrame 
{

	TowerModel model = new TowerModel();
	
	ShapePanel shapePanel = new ShapePanel(model);
	
	Timer timer = new Timer(100, new ActionListener()
	{
		// long prevTime = System.currentTimeMillis();
		// 56, 60...., 
		@Override
		public void actionPerformed(ActionEvent e)
		{
			long curTime = System.currentTimeMillis(); // 1/1000��
			System.out.println("T: " + curTime);
			// System.out.println(System.currentTimeMillis());
			// 1. �Ѿ� ���
			
			
			// 2. �� ��� ó��
			//  2.1. HP ���� - 
			//  2.2. �Ѿ� ���־� ��(����, ���� �������
			// 3. �� �̵� ��Ŵ
			model.updateGame(curTime);
			
			// 3. ȭ�� ������Ʈ
			SwingUtilities.invokeLater(() -> shapePanel.update(model));
//			shapePanel.update(model);
			//System.out.println("OK");
			if( model.isGameOver() ) {
				timer.stop();
			}
		}
	});
	
	// Router router = new Router();
	
	public MainFrame(String title)
	{
		super("X");
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		this.setContentPane(root);
		
		root.add(shapePanel, BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel();
		{
			
			JButton moveRight = new JButton("moveRight");
			southPanel.add(moveRight);
			JButton moveLeft = new JButton("moveLeft");
			southPanel.add(moveLeft);
			JButton enemyBtn = new JButton("ENEMY");
			southPanel.add(enemyBtn);
			enemyBtn.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					int delta = 4;
					Enemy enemy = new Enemy(null, 15, 100,  delta, delta);
					model.addEnemy(enemy, System.currentTimeMillis());
					
				}
			});
		}
		root.add(southPanel, BorderLayout.SOUTH);
		
		
		

		
		root.revalidate();
		root.repaint();

		
		
		//1. �ν��Ͻ��� ����ϴ�.
		//   ��������� �׳� ����� �ν����Դϴ�.
//		ShapeMovement mv = new ShapeMovement() ;
		
		// 2. �����带 ��ӹ��� Ŭ������ start()�� ȣ���ϸ� ���ο� ������ �� ���� �Ҵ��
//		mv.start();
		
//		router.setShapePanel(shapePanel);
//		
//		router.start();
		model.assembleRouters(new double[][] {
			{100, 100},
			{300, 100},
			{300, 400}, 
			{500, 400},
			{550, 600}
		});

	}
	
	void moveShapes(int dx, int dy ) {
		for(int i = 0; i < shapePanel.shapes.size(); i++)
		{
			ShapeUI ui = shapePanel.shapes.get(i);
//			ui.moveShape(dx, dy);
		}

		// shapePanel.revalidate();
		shapePanel.repaint();
	}

	public static void main(String[] args)
	{
		// JFrame f1 = new JFrame("Power Point");
		MainFrame frame = new MainFrame("Power Point");
//		 frame.model.addEnemy(new double[] {300, 300});
		/*
		 * â�� �ִ� X ������ ��� �Ұ���?
		 * 
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true); // â�� ������!
		frame.timer.start();
		// frame.timer.schedule(new Timertaks, delay);

	}

}
