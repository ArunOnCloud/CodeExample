package practice;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
//import java.text.SimpleDateFormat;
//import java.*;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class test1 {
    public static String fun(String s)
    {
    	String str=s+" 00:00:00"+" 23:59:59";
    	return str;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /* Date d=new Date();
        Date d2=(Date)d.clone();
        System.out.println("date:"+d);
        
        SimpleDateFormat startDate = new SimpleDateFormat("E, y/M/d  '00:00:00' ");
        SimpleDateFormat endDate = new SimpleDateFormat("E, y/M/d  '23:59:59'");
        SimpleDateFormat write = new SimpleDateFormat("E, y/M/d HH:mm:ss",Locale.ENGLISH);
        
        String str1=startDate.format(d);
        String str2=endDate.format(d2);
        System.out.println("str1:"+str1);
    	System.out.println("str2:"+str2);
        Date sd=null;
        Date ed=null;
        
        	try {
				sd=startDate.parse(str1);
				//ed=endDate.parse(str2);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try {
				ed=write.parse(str2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("sd:"+sd);
        	System.out.println("ed:"+ed);*/
        /*String str=sd.toString();
        System.out.println(str);
        System.out.println("sd:"+str1);*/
        /*String str="15/11/1992";
        System.out.println(" "+fun(str));*/
        String str="C:/Users/arunram/Desktop/temp/BAJAJ/[B@d6f07b9";
        File file=new File(str);
        if(!file.isDirectory())
        {
        	System.out.print("created directory:"+file.mkdirs());
        }
        
	}

}
