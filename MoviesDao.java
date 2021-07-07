package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Movies;


public class MoviesDao {

	private Connection connection;
	private final String GET_MOVIES_QUERY = "SELECT * FROM movies";
	private final String ADD_MOVIE_BY_QUERY = "INSERT INTO movies(title, director, release_year, rating, genre, length_in_mins) VALUES(?,?,?,?,?,?)";
	private final String REMOVE_MOVIE_BY_ID_QUERY = "DELETE FROM movies WHERE movie_id = ?";
	private final String UPDATE_TITLE_BY_ID_QUERY = "UPDATE movies SET title = ? Where movie_id = ?";
	private final String UPDATE_DIRECTOR_BY_ID_QUERY = "UPDATE movies SET director = ? Where movie_id = ?";
	private final String UPDATE_RELEASE_YEAR_BY_ID_QUERY = "UPDATE movies SET release_year = ? Where movie_id = ?";
	private final String UPDATE_RATING_BY_ID_QUERY = "UPDATE movies SET rating = ? Where movie_id = ?";
	private final String UPDATE_GENRE_BY_ID_QUERY = "UPDATE movies SET genre = ? Where movie_id = ?";
	private final String UPDATE_RUNTIME_BY_ID_QUERY = "UPDATE movies SET length_in_mins = ? Where movie_id = ?";
	
	
	
	
	public MoviesDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Movies> getMovies() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_MOVIES_QUERY).executeQuery();
		List<Movies> movies = new ArrayList<Movies>();
		
		while (rs.next()) {
			movies.add(populateMovie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
		}
	 return movies;
	}
	
	public void addMovie(String title, String director, int release_year, String rating, String genre, int length_in_mins) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_MOVIE_BY_QUERY);
		ps.setString(1, title);
		ps.setString(2, director);
		ps.setInt(3, release_year);
		ps.setString(4, rating);
		ps.setString(5, genre);
		ps.setInt(6, length_in_mins);
		ps.executeUpdate();
	}
	
	public void removeMovie(int movie_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(REMOVE_MOVIE_BY_ID_QUERY);
		ps.setInt(1, movie_id);
		ps.executeUpdate();
	}
	
	public void updateTitle(String title, int movie_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_TITLE_BY_ID_QUERY);
		ps.setString(1, title);
		ps.setInt(2, movie_id);
		ps.executeUpdate();
	}
	
	public void updateDirector(String director, int movie_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_DIRECTOR_BY_ID_QUERY);
		ps.setString(1, director);
		ps.setInt(2, movie_id);
		ps.executeUpdate();
	}
	
	public void updateReleaseYear(int release_year, int movie_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_RELEASE_YEAR_BY_ID_QUERY);
		ps.setInt(1, release_year);
		ps.setInt(2, movie_id);
		ps.executeUpdate();
	}
	
	
	public void updateRatng(String rating, int movie_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_RATING_BY_ID_QUERY);
		ps.setString(1, rating);
		ps.setInt(2, movie_id);
		ps.executeUpdate();
	}
	
	public void updateGenre(String genre, int movie_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_GENRE_BY_ID_QUERY);
		ps.setString(1, genre);
		ps.setInt(2, movie_id);
		ps.executeUpdate();
	}
	
	public void updateRuntime(int length_in_mins, int movie_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_RUNTIME_BY_ID_QUERY);
		ps.setInt(1, length_in_mins);
		ps.setInt(2, movie_id);
		ps.executeUpdate();
	}
	
	private Movies populateMovie(int id, String title, String director, int release_year, String rating, String genre, int length_in_mins) throws SQLException {
		return new Movies(id, title, director, release_year, rating, genre, length_in_mins);
	}
	
}
