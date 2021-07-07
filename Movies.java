package entity;

public class Movies {
	
	private int movie_id;
	private String title;
	private String director;
	private int release_year;
	private String rating;
	private String genre;
	private int length_in_mins;
	
	public Movies(
			int movie_id,
			String title,
			String director,
			int release_year,
			String rating,
			String genre,
			int length_in_mins) {
		this.setMovie_id(movie_id);
		this.setTitle(title);
		this.setDirector(director);
		this.setRelease_year(release_year);
		this.setRating(rating);
		this.setGenre(genre);
		this.setLength_in_mins(length_in_mins);
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getLength_in_mins() {
		return length_in_mins;
	}

	public void setLength_in_mins(int length_in_mins) {
		this.length_in_mins = length_in_mins;
	}
	
}
