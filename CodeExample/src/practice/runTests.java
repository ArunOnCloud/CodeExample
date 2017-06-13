package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

public class runTests {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//String f="2016-10-05";
       // String s="2016-10-06";
		// f.comp(s) result -1
//        String f="10:46 AM";
//        String s="10:45 PM";
//        System.out.println("face:"+f.compareTo(s));
//        Date data=new Date();
//        //SimpleDateFormat format=new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm a");
//        String str=format.format(data);
//        
//        System.out.println("face:"+str);
//        
//        Date date=format.parse("2016-10-06 12:40 PM");
//        
//        System.out.println("date:"+date.toString());
//		double lat1=28.693395;
//		double lat2=28.692482;
//		double lon1=77.148990;
//		double lon2=77.151720;
//		runTests test=new runTests();
//		double dis=test.distance(lat1, lon1, lat2, lon2);
//		System.out.println("dis:"+dis);
//		Thread.sleep(10000L);
		
//		String str="128888888888888888888888888888888888888888888888888888888888888888888888888888";
////       String str="128888888";
//		Integer b=null;
//		
//		try{
//			b=Integer.parseInt(str);
//			System.out.println(b);
//			
//		}catch(NumberFormatException e)
//		{
//			
//		e.printStackTrace();
//		}
//		
		String name="phonebook(2)";
		int f=name.indexOf("(");
		int e=name.indexOf(")");
		System.out.println(name.substring(f+1, e));
		System.out.println(name.substring(0,f));
		TreeMap<String,Integer> treeMap=new TreeMap<String,Integer>();
        treeMap.put("1", 1);
        System.out.println(treeMap.get("1"));
        treeMap.put("1", 2);
        System.out.println(treeMap.get("1"));
        treeMap.remove("3");

	}
	
	public double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        char unit='K';
        //unit = the unit you desire for results                               :*/
/*::           where: 'M' is statute miles (default)                         :*/
/*::                  'K' is kilometers                                      :*/
/*::                  'N' is nautical miles      */
        if (unit == 'K') {
            dist = dist * 1.609344;
        } else if (unit == 'N') {
            dist = dist * 0.8684;
        }
        return (dist);
    }
	public  double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    public double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

	
	
	
	

}
