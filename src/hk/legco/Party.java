package hk.legco;

import java.sql.SQLException;
import java.util.Vector;

public class Party 
{
	DbOp dbo=null;
	public Party()
	{
		
	}
	
	public Vector<String> getPartyNameList()
	{
		Vector<String> result=new Vector<String>();
		try 
		{
			dbo=new DbOp();
			result=dbo.getPartyNameList();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				dbo.close();
				dbo=null;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return result;
	}
}
