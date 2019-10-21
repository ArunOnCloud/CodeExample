package machinecoding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReviewManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private Map<User,Integer> userReviewCountMap=new HashMap<>();

	List<Review> reviewList=new LinkedList<>(); 
	UserManagementSystem userManagementSystem;
	MovieManagementSystem movieManagementSystem;
   
	public void addReview(String userName,String movieName,Integer rating) {
		Review review=new Review();
		User user=userManagementSystem.getUserByName(userName);
		Movie movie=movieManagementSystem.getMovieByName(movieName);
		if(userReviewCountMap.get(user) !=null) {
			int count=userReviewCountMap.get(user);
			review.setCurrentReviewCount(count);
			userReviewCountMap.put(user, count+1);
		}else {
			review.setCurrentReviewCount(0);
		}
		review.setMovie(movie);
		review.setUser(user);
		if(review.getCurrentReviewCount() >=3) {
			review.setRating(rating*2);
		}else {
			review.setRating(rating);
		}
		
		reviewList.add(review);		
	}
	
	public List<Movie> getMovieByYear(){
		//reviewList
		/*Collections.sort(reviewList,new Comparator<T>(){
			{
		}
		})*/
		return null;
		
	}
	
	
	
	
	
}
