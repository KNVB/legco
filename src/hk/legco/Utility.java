package hk.legco;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utility 
{
	public static int getCurrentTermNo()
	{
		int result=0;
		int theYear=2000,thisMonth,thisYear;
		Calendar calendar = new GregorianCalendar();		
		thisYear= calendar.get(Calendar.YEAR);
		thisMonth= calendar.get(Calendar.MONTH)+1;
		if (thisYear>1997)
		{
			if (thisYear<2001)
				result++;
			else
			{
				result++;
				while (theYear<thisYear)
				{
					theYear+=4;
					result++;
				}
			}
			if ((theYear==thisYear)&& (thisMonth>9))
			{
				result++;
			}
		}		
		return result;
	}
	public static String getCurrentTermPeriod()
	{
		String result=new String();
		int theYear=2000,thisMonth,thisYear;
		Calendar calendar = new GregorianCalendar();		
		thisYear= calendar.get(Calendar.YEAR);
		thisMonth= calendar.get(Calendar.MONTH)+1;
		while (theYear<thisYear)
		{
			theYear+=4;
		}
		if ((theYear==thisYear)&& (thisMonth>9))
			result=theYear+"-"+(theYear+4);
		else
			result=(theYear-4)+"-"+theYear;
		return result;
	}
	public static String getTermPeriod(int termNo)
	{
		int i,thisYear=2000;
		String result=null;
		if (termNo>0)
		{
			if (termNo==1)
			{
				result="1998-2000";
			}
			else
			{
				for (i=2;i<=termNo;i++)
				{
					thisYear+=4;
				}
				result=(thisYear-4)+"-"+thisYear;
			}
		}
		return result;
	}
	public static void main(String[] args) 
	{
		System.out.println(Utility.getTermPeriod(6));
		System.out.println(Utility.getCurrentTermNo());
		System.out.println(Utility.getCurrentTermPeriod());
	}
}
