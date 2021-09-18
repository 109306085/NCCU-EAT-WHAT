package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.sql.PreparedStatement;
import java.sql.DatabaseMetaData;

public class ExecSQL {

	private static String url;
	private static String username;
	private static String password;
	private static Connection conn = null;
	private RestaurantList rList ; 
	private Restaurant rest;
	
	public ExecSQL() throws SQLException{
		
		username = "TG04";
		password = "XFvnCp";
		String server =  "jdbc:mysql://140.119.19.73:9306/";
		String database = username;
		String config = " ?useUnicode=true&characterEncoding=utf8";
		url =  "jdbc:mysql://140.119.19.73:9306/TG04?useUnicode=true&characterEncoding=utf8";
		initializing();
	}
	private void initializing() throws SQLException{
		try {
			conn= DriverManager.getConnection(url,username,password);
			createRestaurantTable();
   		    
		}catch(SQLException e) {
			System.out.println( "錯誤訊息:"+e.getMessage());
		}
	}
	public boolean findTable(String tableName) throws SQLException{
		PreparedStatement p = conn.prepareStatement("SHOW TABLES LIKE ?"); 
		p.setString(1, tableName);
		if(p.executeQuery().next()) {
			return true;
		}else {
			return false;
		}
		
	}
	public boolean createRestaurantTable() throws SQLException{
		String qq = "CREATE TABLE IF NOT EXISTS restaurant"
				+ " (ID INT(100) NOT NULL,"
				+ " name VARCHAR(100) NOT NULL,"
				+ " time VARCHAR(300) NOT NULL,"
				+ " type VARCHAR(10) NOT NULL,"
				+ " PRIMARY KEY (ID))";
		PreparedStatement createTableStat = conn.prepareStatement(qq); 
		int i = createTableStat.executeUpdate();
		if(i==0) {
			return true;
		}else {
			return false;
		}
	}
	public Restaurant findRestaurant(String name) throws SQLException{ 
		
		String qq = "SELECT * from restaurant WHERE name=?";
		PreparedStatement findRestStat = conn.prepareStatement(qq);
		findRestStat.setString(1, name);
		ResultSet rr = findRestStat.executeQuery();
		int restID = 0;
		String restName = "";
		String restTime = "";
		String restType = "";
		
		while(rr.next()) {
			restID = rr.getInt("ID");
			restName = rr.getString("name");
			restTime = rr.getString("time");
			restType = rr.getString("type");
			Restaurant r = new Restaurant(restID,restName,restTime,restType);
			return r;
		}
		return null;
	}
	
	public String findTaiwanese()throws SQLException {
		String info = "";
		Statement stat = conn.createStatement();
		String qq = "SELECT * from restaurant WHERE type='中式' ";
		boolean hasResultSet = stat.execute(qq);
		ResultSet result = stat.getResultSet();
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();
        
		if (hasResultSet) {
            for (int i = 1; i <= columnCount; i++) {
            	info += metaData.getColumnLabel(i);
               
                if (i >=1 && i<columnCount){
                	info += ", ";     
                }
            }
            info += "\n";
            info += "\n";
            while (result.next()) {
            	for (int i = 1; i <= columnCount; i++) {
            		info += result.getString(i);
            		if (i >=1&&i<columnCount){
            			info += ", ";
            		}
            	}
            	info += "\n" ;
            	info += "\n";
            }
            result.close();
        } 
		return info;
	}
	public String findJapanese()throws SQLException {
		String info = "";
		Statement stat = conn.createStatement();
		String qq = "SELECT * from restaurant WHERE type='日式' ";
		boolean hasResultSet = stat.execute(qq);
		ResultSet result = stat.getResultSet();
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();
        
		if (hasResultSet) {
            for (int i = 1; i <= columnCount; i++) {
            	info += metaData.getColumnLabel(i);
               
                if (i >=1 && i<columnCount){
                	info += ", ";     
                }
            }
            info += "\n";
            info += "\n";
            while (result.next()) {
            	for (int i = 1; i <= columnCount; i++) {
            		info += result.getString(i);
            		if (i >=1&&i<columnCount){
            			info += ", ";
            		}
            	}
            	info += "\n" ;
            	info += "\n";
            }
            result.close();
        } 
		return info;
	}
	public String findAmerican()throws SQLException {
		String info = "";
		Statement stat = conn.createStatement();
		String qq = "SELECT * from restaurant WHERE type='美式' ";
		boolean hasResultSet = stat.execute(qq);
		ResultSet result = stat.getResultSet();
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();
        
		if (hasResultSet) {
            for (int i = 1; i <= columnCount; i++) {
            	info += metaData.getColumnLabel(i);
               
                if (i >=1 && i<columnCount){
                	info += ", ";     
                }
            }
            info += "\n";
            info += "\n";
            while (result.next()) {
            	for (int i = 1; i <= columnCount; i++) {
            		info += result.getString(i);
            		if (i >=1&&i<columnCount){
            			info += ", ";
            		}
            	}
            	info += "\n" ;
            	info += "\n";
            }
            result.close();
        } 
		return info;
	}
	public String findAll()throws SQLException {
		String info = "";
		Statement stat = conn.createStatement();
		String qq = "SELECT * from restaurant WHERE ID <124 ";
		boolean hasResultSet = stat.execute(qq);
		ResultSet result = stat.getResultSet();
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();
        
		if (hasResultSet) {
            for (int i = 1; i <= columnCount; i++) {
            	info += metaData.getColumnLabel(i);
               
                if (i >=1 && i<columnCount){
                	info += ", ";     
                }
            }
            info += "\n";
            info += "\n";
            while (result.next()) {
            	for (int i = 1; i <= columnCount; i++) {
            		info += result.getString(i);
            		if (i >=1&&i<columnCount){
            			info += ", ";
            		}
            	}
            	info += "\n" ;
            	info += "\n";
            }
            result.close();
        } 
		return info;
	}
public Restaurant RandomChoice() throws SQLException{ 
		
		String qq = "SELECT * from restaurant WHERE ID=?";
		PreparedStatement findRestStat = conn.prepareStatement(qq);
		Random x = new Random(); 
		findRestStat.setInt(1, x.nextInt(123));
		ResultSet rr = findRestStat.executeQuery();
		int restID = 0;
		String restName = "";
		String restTime = "";
		String restType = "";
		
		while(rr.next()) {
			restID = rr.getInt("ID");
			restName = rr.getString("name");
			restTime = rr.getString("time");
			restType = rr.getString("type");
			Restaurant r = new Restaurant(restID,restName,restTime,restType);
			return r;
		}
		return null;
	}
public String findOther()throws SQLException {
	String info = "";
	Statement stat = conn.createStatement();
	String qq = "SELECT * from restaurant WHERE type <> '美式'  AND type <> '日式' AND type <> '中式'";
	boolean hasResultSet = stat.execute(qq);
	ResultSet result = stat.getResultSet();
    ResultSetMetaData metaData = result.getMetaData();
    int columnCount = metaData.getColumnCount();
    
	if (hasResultSet) {
        for (int i = 1; i <= columnCount; i++) {
        	info += metaData.getColumnLabel(i);
           
            if (i >=1 && i<columnCount){
            	info += ", ";     
            }
        }
        info += "\n";
        info += "\n";
        while (result.next()) {
        	for (int i = 1; i <= columnCount; i++) {
        		info += result.getString(i);
        		if (i >=1&&i<columnCount){
        			info += ", ";
        		}
        	}
        	info += "\n" ;
        	info += "\n";
        }
        result.close();
    } 
	return info;
}
	/*
	public boolean addRestaurantList(int id) throws SQLException{ 
		String qq = "SELECT * from restaurant WHERE ID=?";
		PreparedStatement findRestStat = conn.prepareStatement(qq);
		findRestStat.setInt(1, id);
		ResultSet rr = findRestStat.executeQuery();
		
		int restID = 0;
		String restName = "";
		String restTime = "";
		String restType = "";
		while(rr.next()) {
			restID = rr.getInt("ID");
			restName = rr.getString("name");
			restTime = rr.getString("time");
			restType = rr.getString("type");
			rList.addRestaurant(restID, restName, restTime, restType);
			return true;
		}
		return false;
	}
	*/
	
}
