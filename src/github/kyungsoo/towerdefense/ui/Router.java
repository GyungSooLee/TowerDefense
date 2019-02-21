package github.kyungsoo.towerdefense.ui;
import java.util.ArrayList;
import java.util.List;

/**
 * ������ �̵��� ����մϴ�.
 * 
 * v
 * R1 - R2 - R3 
 * @author KyungSooLee
 *
 */
public class Router extends Thread
{

	double [] startPoint; // [x, y]
	
	double [] endPoint ; // [x, y]

	// List<ShapeUI> shapes = new ArrayList<ShapeUI>();
	
	double frameRate = 5.0;
	
	Router next = null;
	
	int [] mVector = { 5, 5};

	private ShapePanel shapeHolder;
	
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				double fps = 1000/frameRate; // 20 frapme per sec
				Thread.sleep((long)fps);
				List<ShapeUI> shapes = shapeHolder.getShapes();
				for(int i = 0; i < shapes.size(); i++)
				{
//					shapes.get(i).moveShape(mVector[0], mVector[1]);
				}
				shapeHolder.repaint();
			} catch (InterruptedException e)
			{
			}
		}

		/*
		 *  1. shapes �� ������ ������ ����
		 *     (dx, dy)��ŭ �̵���Ŵ
		 *     if(���� �����ߴٸ�)
		 *       next.deliver(shape)
		 */
	}

	public void setShapePanel(ShapePanel shapePanel)
	{
		this.shapeHolder = shapePanel;
		
	}
	
	
}
