package github.kyungsoo.towerdefense.ui;

public class User
{
	/*
	 * 유저의 레벨, 돈, 라이프
	 */
	
	private int level = 1;
	private int money = 0;
	private int life = 1;
	
	public User() {}
	
	public User(int level, int money, int life)
	{
		super();
		this.level = level;
		this.money = money;
		this.life = life;
	}

	public void decreaseLife(int i)
	{
		this.life -= i;
		// TODO Auto-generated method stub
		
	}

	public int getLife()
	{
		return this.life;
		// TODO Auto-generated method stub
		
	}
	
}
