package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.MoviesDao;
import entity.Movies;

public class Menu {

	private MoviesDao moviesDao = new MoviesDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Movies", 
			"Add A Movie",
			"Remove A Movie",
			"Update a Movie's Title",
			"Update A Movie's Director",
			"Update A Movie's Release Year",
			"Update A Movie's MPAA Rating",
			"Update A Movie's Genre",
			"Update A Movie's Run Time");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayMovies();
				} else if (selection.equals("2")) {
					addMovie();
				} else if (selection.equals("3")) {
					removeMovie();
				} else if (selection.equals("4")) {
					updateTitle();
				} else if (selection.equals("5")) {
					updateDirector();
				} else if (selection.equals("6")) {
					updateReleaseYear();
				} else if (selection.equals("7")) {
					updateRating();
				} else if (selection.equals("8")) {
					updateGenre();
				} else if (selection.equals("9")) {
					updateRuntime();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue ...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n---------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	
	private void displayMovies() throws SQLException {
		List<Movies> movies = moviesDao.getMovies();
		for (Movies movie : movies) {
			System.out.println(movie.getMovie_id() + " - " + movie.getTitle() + " - " + 
					"Directed By: " + movie.getDirector() + 
					" in " + movie.getRelease_year() + 
					" MPAA Rating of " + movie.getRating() + " " + movie.getGenre() + 
					" Runtime of " + movie.getLength_in_mins() + " mins");
		}
	}
	
	private void addMovie() throws SQLException {
		System.out.print("Enter title:");
		String title = scanner.nextLine();
		System.out.print("Enter director or leave blank:");
		String director = scanner.nextLine();
		System.out.print("Enter release year or 9999:");
		int release_year = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter rating or leave blank:");
		String rating = scanner.nextLine();
		System.out.print("Enter genre or leave blank:");
		String genre = scanner.nextLine();
		System.out.print("Enter movie length in minutes or 999:");
		int length_in_mins = Integer.parseInt(scanner.nextLine());
		moviesDao.addMovie(title, director, release_year, rating, genre, length_in_mins);
	}
	
	private void removeMovie() throws SQLException {
		System.out.print("Enter movie id to remove:");
		int movie_id = Integer.parseInt(scanner.nextLine());
		moviesDao.removeMovie(movie_id);
	}
	
	private void updateTitle() throws SQLException {
		System.out.print("Enter the movie id to update its Title: ");
		int movie_id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter New Title: ");
		String title = scanner.nextLine();
		moviesDao.updateTitle(title, movie_id);
	}
	
	private void updateDirector() throws SQLException {
		System.out.print("Enter the movie id to update its Director: ");
		int movie_id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter New Director: ");
		String director = scanner.nextLine();
		moviesDao.updateDirector(director, movie_id);
	}
	
	private void updateReleaseYear() throws SQLException {
		System.out.print("Enter the movie id to update its Release Year: ");
		int movie_id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter New Year in four digit format: ");
		int release_year = Integer.parseInt(scanner.nextLine());
		moviesDao.updateReleaseYear(release_year, movie_id);
	}
	
	private void updateRating() throws SQLException {
		System.out.print("Enter the movie id to update its Title: ");
		int movie_id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter New MPAA Rating: ");
		String rating = scanner.nextLine();
		moviesDao.updateRatng(rating, movie_id);
	}
	
	private void updateGenre() throws SQLException {
		System.out.print("Enter the movie id to update its Title: ");
		int movie_id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter New Genre (list all corresponding Genres at the same time): ");
		String genre = scanner.nextLine();
		moviesDao.updateGenre(genre, movie_id);
	}
	
	private void updateRuntime() throws SQLException {
		System.out.print("Enter the movie id to update its Release Year: ");
		int movie_id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the Runtime for the movie in minutes: ");
		int length_in_mins = Integer.parseInt(scanner.nextLine());
		moviesDao.updateRuntime(length_in_mins, movie_id);
	}
}
