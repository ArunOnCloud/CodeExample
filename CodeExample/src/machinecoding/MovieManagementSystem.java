package machinecoding;

import java.util.LinkedList;
import java.util.List;

public class MovieManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private List<Movie> movieList=new LinkedList<>();
	private Integer movieCounter=0;
	
	private List<Genre> genreList=new LinkedList<>();
	
	public void addMovie(String name,String year,List<String> genereList) {
		Movie movie=new Movie();
		movie.setId(movieCounter);
		movie.setMovieName(name);
		List<Genre> listGenre=new LinkedList<>();
		movie.setListGenre(listGenre);
	    for(String ge:genereList) {
	    	Genre genere=getGenre(ge);
	    	if(genere == null) {
	    		genere=addGenre(ge);
	    	}
	    	listGenre.add(genere);
	    }
		
	}
	
	public Genre addGenre(String genreName) {
		Genre genre=new Genre();
		genre.setName(genreName);
	    genreList.add(genre);
	    return genre;
	}
	public Genre getGenre(String name) {
		Genre genre=new Genre();
		genre.setName(name);
		for(Genre ge : genreList) {
			if(ge.getName().equalsIgnoreCase(name)) {
				return ge;
			}
		}
		return null;
		
	}
	public Movie getMovieByName(String movieName) {
		for(Movie movie:movieList) {
			if(movie.getMovieName().equalsIgnoreCase(movieName)) {
				return movie;
			}
		}
		return null;
	}

}
