package github.kyungsoo.towerdefense.ui;
import java.awt.Graphics;

public abstract class ShapeUI
{

	public abstract void draw(Graphics g);
	
	
	/**
	 * 주어진 도형이 (x,y)를 포함하면 true를 반환합니다.
	 * @param x
	 * @param y
	 * @return
	 */
	public abstract boolean contains(int x, int y);

	/**
	 * 도형이 차지하는 영역을 반환합니다. 
	 * @return [x1, y1, x2, y2]
	 */
	protected abstract double[] getBoxArea();
	
	
}
