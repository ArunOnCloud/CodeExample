import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
public class GsTest {

	 private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int maxCargoWeight = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int cargoListRows = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        int cargoListColumns = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int[][] cargoList = new int[cargoListRows][cargoListColumns];

        for (int cargoListRowItr = 0; cargoListRowItr < cargoListRows; cargoListRowItr++) {
            String[] cargoListRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            for (int cargoListColumnItr = 0; cargoListColumnItr < cargoListColumns; cargoListColumnItr++) {
                int cargoListItem = Integer.parseInt(cargoListRowItems[cargoListColumnItr]);
                cargoList[cargoListRowItr][cargoListColumnItr] = cargoListItem;
            }
        }

        int[] res = findTruckCargo(maxCargoWeight, cargoList);

        for (int resItr = 0; resItr < res.length; resItr++) {
           // bufferedWriter.write(String.valueOf(res[resItr]));

            if (resItr != res.length - 1) {
            //    bufferedWriter.write("\n");
            }
        }

       // bufferedWriter.newLine();

       // bufferedWriter.close();

        scanner.close();
    }
	static int[] findTruckCargo(int maxCargoWeight, int[][] cargoList) {
        /*
         * Write your code here.
         */
        
        int n=cargoList.length;
        int[] ans=new int[n+1];
        int[][] arr=new int[maxCargoWeight+1][n+1];
        for(int i=0;i<maxCargoWeight+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    arr[i][j]=0;
                }else{
                    int w=i-cargoList[j-1][1];
                    int one=0;
                    if(w<=0){
                        one=0;
                    }else{
                        one=arr[w][j-1] + cargoList[j-1][2];
                    }
                    int two=arr[i][j-1];
                    arr[i][j]=Math.max(one,two);
                }
            }
        }
        for(int i=0;i<maxCargoWeight+1;i++){
            for(int j=0;j<n+1;j++){
            	System.out.print(arr[i][j]+" ");
            }
            System.out.println();
            }
        ans[n]=arr[maxCargoWeight][n];
        System.out.println(arr[maxCargoWeight][n]);
        return ans;    

    }

}
