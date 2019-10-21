package machinecoding;

import java.util.List;

public class MovieReviewManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private UserManagementSystem userManagementSystem;
	private ReviewManagementSystem reviewManagementSystem;
	private MovieManagementSystem movieManagementSystem;
	public MovieReviewManagementSystem() {
		// TODO Auto-generated constructor stub
		userManagementSystem=new UserManagementSystem();
		reviewManagementSystem=new ReviewManagementSystem();
		movieManagementSystem=new MovieManagementSystem();
	}
	public void onboardUser(String name) {
		userManagementSystem.addUser(name);
	}
	public void onBoardMovie(String movieName,String year,List<String> listGenere) {
		movieManagementSystem.addMovie(movieName, year, listGenere);
	}
	
	public List<Movie> listTopNMoviewByYear(int n){
		
		
		
		return null;
		
	}
	
	
	

}
