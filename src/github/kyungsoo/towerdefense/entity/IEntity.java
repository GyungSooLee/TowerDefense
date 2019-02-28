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
	 * 초당 움직이는 거리(pixel)
	 * @return
	 */
	double getSpeed();
	/**
	 * x축과 이루는 각도
	 * @return
	 */
	double getDegree();
	/**
	 * 사정거리
	 * @return
	 */
	double getRange();
	
	double getRadius();
	
	double[] getCenter();
	/**
	 * 단위 시간당 이동할 dx, dy의 배열
	 * @return
	 */
	double[] getDelta();
	
	void shiftLoc(double dx, double dy);
}
