package application;
import java.util.ArrayList;
import java.sql.SQLException;
public class Restaurant {
	private int id;
	private String name;
	private String type;
	private String time;
	
	public Restaurant(int id, String name, String time,String type)  {
		this.id = id;
		this.name = name;
		this.type = type;
		this.time = time;
	}
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;	
	}
	public String getTime() {
		return time;
	}
	public String getInfo() {
		String info = "";
		info += String.format("NAME: %s \n", getName());
		info += String.format("OPEN TIME: %s \n", getTime());
		info += String.format("TYPE: %s \n", getType());
		return info;
	}
	
}
