package java1021stream;

public class Game {
	private int level;
	private String job;
	private int attack;
	private String position;
	
	
	public Game() {
		super();
	}
	
	public Game(int level, String job, int attack, String position) {
		super();
		this.level = level;
		this.job = job;
		this.attack = attack;
		this.position = position;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Game [level=" + level + ", job=" + job + ", attack=" + attack + ", position=" + position + "]";
	}
	
	


}
