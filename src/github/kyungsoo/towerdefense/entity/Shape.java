package github.kyungsoo.towerdefense.entity;
/**
 * 
 * @deprecated �̰� ������
 * @author KyungSooLee
 *
 */
public abstract class Shape	//abstract : ���� �ν��Ͻ��� ������ ���ϰ� ���� ���.
{

	/*
	 * public double getArea() { return -1; // ���� �ȵ�! }
	 */
	/**
	 * ������ ���̸� ���մϴ�.
	 * @return
	 */
	public abstract double getArea(); 
	
	/**
	 * ������ �ѷ��� ��ȯ�մϴ�.
	 */
	public abstract double getAround();
	
	public void r() {}
	
}
