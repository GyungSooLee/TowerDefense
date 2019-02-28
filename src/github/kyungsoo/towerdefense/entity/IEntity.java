package github.kyungsoo.towerdefense.entity;
/**
 * 
 * @author KyungSooLee
 *
 */
public interface IEntity
{

	double getX();
	double getY();
	
	double getHP();
	double getPower();

	/**
	 * �ʴ� �����̴� �Ÿ�(pixel)
	 * @return
	 */
	double getSpeed();
	/**
	 * x��� �̷�� ����
	 * @return
	 */
	double getDegree();
	/**
	 * �����Ÿ�
	 * @return
	 */
	double getRange();
	
	double getRadius();
	
	double[] getCenter();
	/**
	 * ���� �ð��� �̵��� dx, dy�� �迭
	 * @return
	 */
	double[] getDelta();
	
	void shiftLoc(double dx, double dy);
}
