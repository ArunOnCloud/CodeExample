package practice;

public class ExcelColumnNumberToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("AB:"+ExcelColumnNameToNumber("AB"));
		System.out.println("AD:"+ExcelColumnNameToNumber("AD"));
		System.out.println("BD:"+ExcelColumnNameToNumber("BD"));
		System.out.println("BF:"+ExcelColumnNameToNumber("BF"));
		System.out.println("CF:"+ExcelColumnNameToNumber("CF"));
		System.out.println("CH:"+ExcelColumnNameToNumber("CH"));
		System.out.println("DH:"+ExcelColumnNameToNumber("DH"));
		System.out.println("DJ:"+ExcelColumnNameToNumber("DJ"));
		System.out.println("EJ:"+ExcelColumnNameToNumber("EJ"));
		System.out.println("EL:"+ExcelColumnNameToNumber("EL"));
		System.out.println("FL:"+ExcelColumnNameToNumber("FL"));
		System.out.println("FN:"+ExcelColumnNameToNumber("FN"));
		System.out.println("GN:"+ExcelColumnNameToNumber("GN"));
		System.out.println("GP:"+ExcelColumnNameToNumber("GP"));
		System.out.println("HP:"+ExcelColumnNameToNumber("HP"));
		//System.out.println("FL:"+ExcelColumnNameToNumber("FL"));
	}
	
	public static int ExcelColumnNameToNumber(String columnName)
	{
	    

	    columnName = columnName.toUpperCase();

	    int sum = 0;

	    for (int i = 0; i < columnName.length(); i++)
	    {
	        sum *= 26;
	        sum += (columnName.charAt(i) - 'A' + 1);
	    }

	    return sum;
	}


}
