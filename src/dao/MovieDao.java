package dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import models.Discover;
import models.Movies;
import models.Videos;

public class MovieDao {
	public String key="4ad83349880cbc8af99b1a22cb817a96";
	public String getMovieById(int id) throws IOException
	{
		String urlString="https://api.themoviedb.org/3/movie/"+id+"?api_key=4ad83349880cbc8af99b1a22cb817a96&language=en-US";
		URL url=new URL(urlString);
		String responsedata = IOUtils.toString(url);
		return responsedata;
	}
	
	public String getCastbyId(int id) throws IOException
	{
		String urlString="https://api.themoviedb.org/3/movie/"+id+"/credits?api_key=4ad83349880cbc8af99b1a22cb817a96";
		URL url=new URL(urlString);
		String responsedata = IOUtils.toString(url);
		return responsedata;
	}
	
	public List<Videos> getVideosbyId(int id) throws IOException, ParseException
	{
		List<Videos> videos=new ArrayList<Videos>();
		String urlString="https://api.themoviedb.org/3/movie/"+id+"/videos?api_key=4ad83349880cbc8af99b1a22cb817a96";
		URL url=new URL(urlString);
		String responsedata = IOUtils.toString(url);
		JSONObject obj=(JSONObject) JSONValue.parseWithException(responsedata);
		JSONArray results=(JSONArray)obj.get("results");
		for(int i=0;i<results.size();i++)
		{
			JSONObject result=(JSONObject)results.get(i);
			String ID=result.get("id").toString();
			String key="https://www.youtube.com/embed/"+result.get("key").toString();
			String name=result.get("name").toString();
			Videos v=new Videos(ID, key, name);
			videos.add(v);
		}
		return videos;
	}
	public List<Discover> getPopularMovies() throws IOException
	{
		List<Discover> popularMovies=new ArrayList<Discover>();
		
		String urlString="https://api.themoviedb.org/3/movie/popular?api_key="+ key+"&language=en-US&page=1";
		URL url = new URL(urlString);
		String responsedata = IOUtils.toString(url);
		try{
			JSONObject response=(JSONObject) JSONValue.parseWithException(responsedata);
			JSONArray results=(JSONArray) response.get("results");
			for(int i=0;i<results.size();i++)
			{
				JSONObject res = (JSONObject) results.get(i);
				String image = (String) res.get("poster_path");
				int id = Integer.parseInt(res.get("id").toString());
				System.out.println("id=" + id);
				String title = (String) res.get("original_title");
				Discover d=new Discover("https://image.tmdb.org/t/p/original"+image, id, title);
				popularMovies.add(d);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return popularMovies;
	}
		
}
