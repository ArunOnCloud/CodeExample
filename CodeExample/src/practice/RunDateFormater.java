package practice;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class RunDateFormater {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2015-11-20";
        Date date = formatter.parse(dateInString);
        System.out.println(date);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        String  temp=format.format(date).toString();
        System.out.println("temp:"+temp);
//        Date endDate=formatter.parse("2015-11-21");
//        //int days=Days.daysBetween(date, endDate).getDays();
//        long diff =  endDate.getTime()-date.getTime();
//        Integer day=(int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//        System.out.println ("Days: " + day);
		//Date date;
        numberOfDays("2015-11-20","2015-12-23");		

	}
   public static  int numberOfDays(String s,String e) throws ParseException
   {
	   int res=0;
	   System.out.println(s+" "+e);
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	   Date sd = formatter.parse(s);
	   
	   Date se = formatter.parse(e);
	   long time=se.getTime()-sd.getTime();
	   res=(int)(time/(24*60*60*1000));
	   System.out.println("res:"+res);
	   return res;
	   
   }

}
