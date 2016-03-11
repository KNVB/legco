package hk.legco;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Vector;

public class DbOp 
{
	private Connection dbConn = null;
	private String jdbcURL = new String();
	private String jdbcDriver = new String("org.sqlite.JDBC");
	
	public DbOp(String dbFilePath)throws SQLException, ClassNotFoundException
	{
		Class.forName(jdbcDriver);
		jdbcURL = "jdbc:sqlite:"+dbFilePath;
		dbConn = DriverManager.getConnection(jdbcURL);
	}
	public DbOp() throws SQLException, ClassNotFoundException 
	{
		jdbcURL = "jdbc:sqlite:legco.db";
		Class.forName(jdbcDriver);
		dbConn = DriverManager.getConnection(jdbcURL);
	}
	public int executeUpdate(String strSql) throws SQLException
	{
		int result;
		ResultSet rs = null;
		Statement stmt = dbConn.createStatement();
		result=stmt.executeUpdate(strSql);
		releaseResource(rs, stmt); 
		return result;
	}
	public Vector<String> getPartyNameList()throws SQLException
	{
		String strSql="select party_name from member_to_party group by party_name";
		Vector<String> result=new Vector<String>();
		ResultSet rs = null;
		Statement stmt = dbConn.createStatement();
		rs=stmt.executeQuery(strSql);
		while (rs.next())
		{
			result.add(rs.getString("party_name"));
		}
		releaseResource(rs, stmt); 
		return result;
	}
	/**
	 * Close db connection
	 * @throws SQLException 
	 * @throws Exception
	 */
	public void close() throws SQLException
	{
		dbConn.close();
		dbConn = null;
	}
	/**
	 * Release resource for 
	 * @param r ResultSet object
	 * @param s PreparedStatement object
	 */
	private void releaseResource(ResultSet r, Statement s) 
	{
		if (r != null) 
		{
			try 
			{
				r.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		if (s != null) 
		{
			try 
			{
				s.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		r = null;
		s = null;
	}	
}
