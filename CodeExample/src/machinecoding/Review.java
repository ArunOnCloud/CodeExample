package machinecoding;

public class Review {
	private Movie movie;
	private User user;
	private int currentReviewCount;
	private int rating;
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCurrentReviewCount() {
		return currentReviewCount;
	}
	public void setCurrentReviewCount(int currentReviewCount) {
		this.currentReviewCount = currentReviewCount;
	}
	

}
