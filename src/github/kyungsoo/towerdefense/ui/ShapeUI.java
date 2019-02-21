package github.kyungsoo.towerdefense.ui;
import java.awt.Graphics;

public abstract class ShapeUI
{

	public abstract void draw(Graphics g);
	
	
	/**
	 * �־��� ������ (x,y)�� �����ϸ� true�� ��ȯ�մϴ�.
	 * @param x
	 * @param y
	 * @return
	 */
	public abstract boolean contains(int x, int y);

	/**
	 * ������ �����ϴ� ������ ��ȯ�մϴ�. 
	 * @return [x1, y1, x2, y2]
	 */
	protected abstract double[] getBoxArea();
	
	
}
