package application;
import java.sql.SQLException;
import java.util.ArrayList;
public class RestaurantList {
	private ArrayList<Restaurant> rList;
	private ExecSQL exec;
	public RestaurantList() throws SQLException {
		rList = new ArrayList<Restaurant>();
		exec = new ExecSQL();
	}
	
	public void addRestaurant(int id,String name,String time,String type)throws SQLException {
		rList.add(new Restaurant(id,name,time,type));
	}
	public Restaurant findRestaurant(String name) {
		for(Restaurant r : rList) {
			if(r.getName().equals(name)==true) {
				return r;
			}
		}
		return null;
	}
	
	public String getRestList() {
		String info = "";
		for(Restaurant r : rList) {
			info = r.getInfo();
		}
		return info;
	}
}
