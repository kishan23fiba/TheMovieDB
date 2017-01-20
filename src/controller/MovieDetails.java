package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.MovieCast;
import models.Movies;
import models.Videos;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import dao.MovieDao;

@WebServlet("/MovieDetails")
public class MovieDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int ID=Integer.parseInt(request.getParameter("id"));
		System.out.println("id caught: "+ ID);
		MovieDao movieDao = new MovieDao();
		String responseJson=movieDao.getMovieById(ID);
		try{
			JSONObject objectmain=(JSONObject) JSONValue.parseWithException(responseJson);
			JSONArray genres=(JSONArray) objectmain.get("genres");
			List<String> genre=new ArrayList<String>();
			for(int i=0;i<genres.size();i++)
			{
				JSONObject obj_genre=(JSONObject) genres.get(i);
				String g=(String) obj_genre.get("name");
				genre.add(g);
			}
			int id=Integer.parseInt(objectmain.get("id").toString());
			String title=(String) objectmain.get("original_title");
			String overview=objectmain.get("overview").toString();
			String releasedate=objectmain.get("release_date").toString();
			String revenue=objectmain.get("revenue").toString();
			int runtime=Integer.parseInt(objectmain.get("runtime").toString());
			double vote_average=Double.parseDouble(objectmain.get("vote_average").toString());
			int vote_count=Integer.parseInt(objectmain.get("vote_count").toString());
			List<String> productionCompanies=new ArrayList<String>();
			JSONArray prodArr=(JSONArray) objectmain.get("production_companies");
			for(int i=0;i<prodArr.size();i++)
			{
				JSONObject obj_prod=(JSONObject)prodArr.get(i);
				String s=obj_prod.get("name").toString();
				productionCompanies.add(s);
			}
			String backdrop_path="https://image.tmdb.org/t/p/w1280"+objectmain.get("backdrop_path").toString();
			String poster_path="https://image.tmdb.org/t/p/w500"+objectmain.get("poster_path").toString();
			System.out.println("backdrop="+ backdrop_path);
			Movies movie=new Movies(id, title, overview, releasedate, revenue, runtime, vote_average, vote_count, genre, productionCompanies,backdrop_path,poster_path);
			request.setAttribute("movie", movie);
			
			// for cast & credit
			String responseJSONCast=movieDao.getCastbyId(ID);
			List<MovieCast> movieCast=new ArrayList<MovieCast>();
			try
			{
				JSONObject obj=(JSONObject) JSONValue.parseWithException(responseJSONCast);
				JSONArray cast=(JSONArray) obj.get("cast");				
				for(int i=0;i<cast.size();i++)
				{
					JSONObject castobj=(JSONObject)cast.get(i);					
					int cast_id=Integer.parseInt(castobj.get("cast_id").toString());
					String character=castobj.get("character").toString();
					int person_id=Integer.parseInt(castobj.get("id").toString());
					String name=castobj.get("name").toString();
					String image="";
					if(castobj.get("profile_path")==null)
					{
						image="http://s3.amazonaws.com/37assets/svn/765-default-avatar.png";
					}
					else
					{
						image="https://image.tmdb.org/t/p/w300"+castobj.get("profile_path").toString();;
					}
					MovieCast mc=new MovieCast(cast_id, character, person_id, name, image);
					movieCast.add(mc);
				}				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			request.setAttribute("movieCast", movieCast);			
			//For videos
			List<Videos> videos=movieDao.getVideosbyId(ID);
			request.setAttribute("videos", videos);
			request.getRequestDispatcher("jsp/moviedetails.jsp").forward(request, response);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
