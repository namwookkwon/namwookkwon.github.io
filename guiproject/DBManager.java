package guiproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DBManager {
	Connection conn;

	public DBManager() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertUserInfo(String id, String ps) {
		String sql = "INSERT INTO userinfo VALUES(?, ?);";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, ps);
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public List<Map<String, Object>> selectSample(String sql) {

		Statement st = null;

		Map<String, Object> tempMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

		try 
		{
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			//System.out.println("Query : " + sql);

			while (rs.next()) 
			{
				for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) 
				{
					tempMap.put(rs.getMetaData().getColumnName(i+1), rs.getString(rs.getMetaData().getColumnName(i+1)));
				}

				resultList.add(tempMap);
				tempMap = new HashMap<>();    // tempMap reset
			}

			rs.close(); st.close();
		}
		catch (SQLException se1) 
		{
			se1.printStackTrace();
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				if (st != null)
				{
					st.close();
				}
			} 
			catch (SQLException se2) 
			{ 
				se2.printStackTrace();
			}
		}

		return resultList;
	}
}