package mc.arexmc.main;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mc.arexmc.utils.Config;





public class MySQL {

	
	
	public static String HOST = Config.cfg2.getString("HOST");
	public static String PORT = "3306";
	public static String DATABASE = Config.cfg2.getString("DATABASE");
	public static String USER = Config.cfg2.getString("USER");
	public static String PASSWORD = Config.cfg2.getString("PASSWORT");
	public static Connection con;
	
	
	public static void connect() {
		
			try {
				con = DriverManager.getConnection("jdbc:MySQL://" + HOST + ":" + PORT + "/" + DATABASE, USER, PASSWORD);
					System.out.println("[MySQL] Verbindung erfolreich aufgebaut");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	}
	
	public static void disconnect() {
		if(isConnected()) {
			try {
				con.close();
				System.out.println("[MySQL] Wurde erfolgreich geschlossen");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static boolean isConnected() {
	return (con == null ? false : true); 
		
	}
	


	
	
	
	public static ResultSet getResult(String qry) {
		try {
			PreparedStatement ps = con.prepareStatement(qry);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public static PreparedStatement getStatement(String sql) {
		if(isConnected()){
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				return ps;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return null;
	}
	public static void Update(String qry){
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(qry);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	
	public static ResultSet Query(String query) throws SQLException {
        Statement statement = con.createStatement();
        return statement.executeQuery(query);
    }
	
	public static void update(String qry) {
        if(isConnected()){
        	try {
				con.createStatement().executeUpdate(qry);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
}
	public static void createTable() {
		MySQL.update("CREATE TABLE IF NOT EXISTS ArexBan(Spielername varchar(64),UUID varchar(64),Ende bigint, Grund varchar(64), Operator varchar(64), IP varchar(64))");
		MySQL.update("CREATE TABLE IF NOT EXISTS ArexMute(Spielername varchar(64),UUID varchar(64),Ende bigint, Grund varchar(64), Operator varchar(64))");
		MySQL.update("CREATE TABLE IF NOT EXISTS ArexWarn(UUID varchar(64), Spielername varchar(64),Warns int(100))");
		
	}
	
	
	
}
