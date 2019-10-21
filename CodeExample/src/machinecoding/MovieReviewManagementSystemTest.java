package machinecoding;

import java.util.LinkedList;
import java.util.List;

public class MovieReviewManagementSystemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieReviewManagementSystem movieReviewManagementSystem=new MovieReviewManagementSystem();
		movieReviewManagementSystem.onboardUser("SRK");
		movieReviewManagementSystem.onboardUser("Salman");
		movieReviewManagementSystem.onboardUser("Arun");
	
		List<String> listGenere=new LinkedList<>();
		listGenere.add("Action");
		movieReviewManagementSystem.onBoardMovie("Don", "2006", listGenere);
		listGenere.remove("Action");
		listGenere.add("Drama");
		movieReviewManagementSystem.onBoardMovie("Tiger", "2008", listGenere);
		
		listGenere.remove("Drama");
		listGenere.add("Comedy");
		movieReviewManagementSystem.onBoardMovie("Padmawat", "2006", listGenere);
		
		
	}

}
