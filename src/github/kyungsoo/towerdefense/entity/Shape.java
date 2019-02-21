package github.kyungsoo.towerdefense.entity;
/**
 * 
 * @deprecated 이거 빼야함
 * @author KyungSooLee
 *
 */
public abstract class Shape	//abstract : 직접 인스턴스를 만들지 못하게 막는 기능.
{

	/*
	 * public double getArea() { return -1; // 말이 안됨! }
	 */
	/**
	 * 도형의 넓이를 구합니다.
	 * @return
	 */
	public abstract double getArea(); 
	
	/**
	 * 도형의 둘레를 반환합니다.
	 */
	public abstract double getAround();
	
	public void r() {}
	
}
