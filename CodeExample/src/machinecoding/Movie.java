package machinecoding;

import java.util.*;

public class Movie {
	private int id;
	private String movieName;
	private List<Genre> listGenre=new LinkedList<>();
	private String year;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public List<Genre> getListGenre() {
		return listGenre;
	}

	public void setListGenre(List<Genre> listGenre) {
		this.listGenre = listGenre;
	}

	
	

}
