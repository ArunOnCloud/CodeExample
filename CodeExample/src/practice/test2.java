package practice;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
//import java.text.SimpleDateFormat;
//import java.*;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class test2 {
    public static String fun(String s)
    {
    	String str=s+" 00:00:00"+" 23:59:59";
    	return str;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Date d=new Date();
        Date d2=(Date)d.clone();
        System.out.println("date:"+d);
        
        //SimpleDateFormat startDate = new SimpleDateFormat("E, y/M/d  '00:00:00' ");
        SimpleDateFormat endDate1 = new SimpleDateFormat("E, y/M/d ");
        SimpleDateFormat endDate = new SimpleDateFormat("E, y/M/d HH:mm:ss",Locale.ENGLISH);
        
        //String str1=startDate.format(d);
        String str2=endDate1.format(d2);
       // System.out.println("str1:"+str1);
    	System.out.println("str2:"+str2);
    	Date sd=null;
        Date ed=null;
    	String str3;
    	String[] utilArr={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
    	String[] strArr=new String[24];
    	String endStr=":00:00";
    	for(int i=0;i<24;i++)
    	{
    		str3=str2+utilArr[i]+endStr;
    		System.out.println("str3:"+str3);
    		try {
				ed=endDate.parse(str3);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.out.println("ed:"+ed);
    	}
        
        
        	/*try {
				sd=startDate.parse(str1);
				//ed=endDate.parse(str2);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        	/*try {
				ed=endDate.parse(str2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        	//System.out.println("sd:"+sd);
        	//System.out.println("ed:"+ed);
        /*String str=sd.toString();
        System.out.println(str);
        System.out.println("sd:"+str1);*/
        /*String str="15/11/1992";
        System.out.println(" "+fun(str));*/
        	/*String target = "27-09-1991 20:29:30";
        	DateFormat df = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        	Date result=null;
			try {
				result = df.parse(target);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("ressult:"+result); */
        
        
	}

}
