package models;

import java.util.List;

public class Movies {
	int id;
	String title;
	String overview;
	String release_date;
	String revenue;
	int runtime;	
	double vote_average;
	int vote_count;
	String backdrop_path;
	String poster_path;
	
	List<String> genres;
	List<String> productionCompanies;
	
	public Movies(int id, String title, String overview, String release_date,
			String revenue, int runtime, 
			double vote_average, int vote_count, List<String> genres,
			List<String> productionCompanies, String backdrop_path, String poster_path) {
		super();
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.release_date = release_date;
		this.revenue = revenue;
		this.runtime = runtime;		
		this.vote_average = vote_average;
		this.vote_count = vote_count;
		this.genres = genres;
		this.productionCompanies = productionCompanies;
		this.backdrop_path=backdrop_path;
		this.poster_path=poster_path;
		
	}
	public String getBackdrop_path() {
		return backdrop_path;
	}
	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getRevenue() {
		return revenue;
	}
	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	
	public double getVote_average() {
		return vote_average;
	}
	public void setVote_average(double vote_average) {
		this.vote_average = vote_average;
	}
	public int getVote_count() {
		return vote_count;
	}
	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public List<String> getProductionCompanies() {
		return productionCompanies;
	}
	public void setProductionCompanies(List<String> productionCompanies) {
		this.productionCompanies = productionCompanies;
	}
	
}
