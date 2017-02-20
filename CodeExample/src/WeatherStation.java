import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WeatherStation {

	private double mintemp;// minimum temperature
	private double maxtemp;// maximum temperature
	private double rainfallMM; //rainfall (in mm)
	private double numOfHoursSunshine;// number of hours sunshine for each month
	private int month;
	private int year;

	public WeatherStation() {}
	
	public WeatherStation(String line) {
		String[] tokens = line.trim().split("\\s+");
		if (tokens.length != 6) {
			System.out.println("Invalid line");
			System.out.println("line: "+line);
			return;
		}
		year = Integer.parseInt(tokens[0]);
		month = Integer.parseInt(tokens[1]);
		maxtemp = Double.parseDouble(tokens[2]);
		mintemp = Double.parseDouble(tokens[3]);
		rainfallMM = Double.parseDouble(tokens[4]);
		numOfHoursSunshine = Double.parseDouble(tokens[5]);
	}

	public double getMintemp() {
		return mintemp;
	}

	public double getMaxtemp() {
		return maxtemp;
	}

	public double getRainfallMM() {
		return rainfallMM;
	}

	public double getNumOfHoursSunshine() {
		return numOfHoursSunshine;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public String getMonthName() {
		switch (month) {
		case 1:
			return "January";

		case 2:
			return "February";

		case 3:
			return "March";

		case 4:
			return "April";

		case 5:
			return "May";

		case 6:
			return "June";

		case 7:
			return "July";

		case 8:
			return "August";

		case 9:
			return "September";

		case 10:
			return "October";

		case 11:
			return "November";

		case 12:
			return "December";
		}

		return "Invalid month";
	}
	
	//find which year had the most rainfall(in mm)
	public static void wettestYearReport(ArrayList<WeatherStation> monthDataList) {
		Map<Integer, Double> map = new HashMap<>();
		Double temp;
		for (WeatherStation m : monthDataList) {
			if (map.containsKey(m.getYear())) {
				temp = map.get(m.getYear());
				temp += m.getRainfallMM();
				map.put(m.getYear(),temp);
			} else {
				map.put(m.getMonth(), m.getRainfallMM());
			}
		}
		Set<?> mapSet = (Set<?>) map.entrySet();
        Iterator<?> it = mapSet.iterator();
		Map.Entry mapEntry = (Map.Entry) it.next();
        double maxRain = (Double) mapEntry.getValue();
        int maxYear = (Integer) mapEntry.getKey();
        while(it.hasNext()){
        	mapEntry = (Map.Entry) it.next();
        	if(maxRain<(Double) mapEntry.getValue()){
        		maxRain = (Double) mapEntry.getValue();
                maxYear = (Integer) mapEntry.getKey();
        	}	
        }
        System.out.println("Wettest year: "+maxYear+" ("+maxRain+" mm)");
	}
	
	//find which year had the least rainfall(in mm)
	public void driestYearReport(ArrayList<WeatherStation> monthDataList) {
		Map<Integer, Double> map = new HashMap<>();
		Double temp;
		for (WeatherStation m : monthDataList) {
			if (map.containsKey(m.getYear())) {
				temp = map.get(m.getYear());
				temp += m.getRainfallMM();
				map.put(m.getYear(),temp);
			} else {
				map.put(m.getYear(), m.getRainfallMM());
			}
		}
		Set mapSet = (Set) map.entrySet();
        Iterator it = mapSet.iterator();
		Map.Entry mapEntry = (Map.Entry) it.next();
        double minRain = (Double) mapEntry.getValue();
        int minYear = (Integer) mapEntry.getKey();
        while(it.hasNext()){
        	mapEntry = (Map.Entry) it.next();
        	if(minRain>(Double) mapEntry.getValue()){
        		minRain = (Double) mapEntry.getValue();
                minYear = (Integer) mapEntry.getKey();
        	}	
        }
        System.out.printf("%s %d %s%.1f %s\n", "Driest year:",minYear,"(",minRain,"mm)");
	}

	//find which month had the most hours of sunshine
	public static void sunniestMonthReport(ArrayList<WeatherStation> monthDataList) {
		int maxYear;
		String maxMonth;
		double maxSun;
		maxYear = monthDataList.get(0).getYear();	
		maxMonth = monthDataList.get(0).getMonthName();	
		maxSun = monthDataList.get(0).getNumOfHoursSunshine();	
		
		for (int i=1; i<monthDataList.size(); i++) {
			if(maxSun<monthDataList.get(i).getRainfallMM()){// are you sure it is correct?
				maxYear = monthDataList.get(i).getYear();	
				maxMonth = monthDataList.get(i).getMonthName();	
				maxSun = monthDataList.get(i).getNumOfHoursSunshine();	
			}
		}
        System.out.println("Sunniest month: "+maxMonth+" "+maxYear+" ("+maxSun+" hours)");
	}
	
	public static void main(String[] args) {
		ArrayList<WeatherStation> monthDataList = new ArrayList<WeatherStation>();
		
		WeatherStation monthData1 = new WeatherStation("1930   1    8.1     2.4   120.5    54.2");
		monthDataList.add(monthData1);
		WeatherStation monthData2 = new WeatherStation("1930   2    4.4     0.6   22.2    29.1");
		monthDataList.add(monthData2);
		WeatherStation monthData3 = new WeatherStation("1930   3    8.1     2.1   76.2    88.2");
		monthDataList.add(monthData3);
		
		WeatherStation monthData4 = new WeatherStation("1947   8   23.9    13.3   12.7   239.0");
		monthDataList.add(monthData4);
		WeatherStation monthData5 = new WeatherStation("1947   9   18.8    11.1   35.5   145.5");
		monthDataList.add(monthData5);
		WeatherStation monthData6 = new WeatherStation("1947  10   14.6     8.2   14.0    83.1");
		monthDataList.add(monthData6);
		
		WeatherStation monthData7 = new WeatherStation("1956   8   16.6    10.2   146.1   112.1");
		monthDataList.add(monthData7);
		WeatherStation monthData8 = new WeatherStation("1956   9   17.6    10.7   83.4    98.4");
		monthDataList.add(monthData8);
		WeatherStation monthData9 = new WeatherStation("1956  10   12.9     6.9   33.1    98.4");
		monthDataList.add(monthData9);
		
		
		WeatherStation monthData10 = new WeatherStation("2012  10   12.2     6.1  61.2   111.4");
		monthDataList.add(monthData10);
		WeatherStation monthData11 = new WeatherStation("2012  11    9.2     3.8  110.6    68.7");
		monthDataList.add(monthData11);
		WeatherStation monthData12 = new WeatherStation("2012  12    7.0     2.3  136.0    57.7");
		monthDataList.add(monthData12);
		
		WeatherStation.wettestYearReport(monthDataList);
		WeatherStation.sunniestMonthReport(monthDataList);
		(new WeatherStation()).driestYearReport(monthDataList);
		
	}
}