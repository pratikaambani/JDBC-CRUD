package bean;

public class UserBean	{
	private String name;
	private int rollno;
	private String clas;
	private long mono;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getRollno()	{
		return this.rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public String getClas() {
		return this.clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	
	public long getMono()	{
		return this.mono;
	}
	public void setMono(long mono) {
		this.mono = mono;
	}
}