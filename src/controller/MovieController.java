package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Discover;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import dao.MovieDao;

/**
 * Servlet implementation class movieController
 */
@WebServlet("/MovieController")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String key = "4ad83349880cbc8af99b1a22cb817a96";
		String urlString = "https://api.themoviedb.org/3/movie/upcoming?api_key="
				+ key
				+ "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&primary_release_year=2016";
		URL url = new URL(urlString);
		String responsedata = IOUtils.toString(url);
		try {
			List<Discover> discover = new ArrayList<Discover>();
			JSONObject output = (JSONObject) JSONValue
					.parseWithException(responsedata);
			JSONArray results = (JSONArray) output.get("results");
			for (int i = 0; i < results.size(); i++) {
				JSONObject res = (JSONObject) results.get(i);
				String image = (String) res.get("poster_path");
				int id = Integer.parseInt(res.get("id").toString());
				System.out.println("id=" + id);
				String title = (String) res.get("original_title");
				Discover d = new Discover("https://image.tmdb.org/t/p/original"
						+ image, id, title);
				discover.add(d);
			}
						
			request.setAttribute("discover", discover);

		} catch (Exception e) {
			e.printStackTrace();
		}
		MovieDao movieDao = new MovieDao();
		List<Discover> popularMovies=movieDao.getPopularMovies();
		request.setAttribute("upcomingMovies",popularMovies);
		request.getRequestDispatcher("jsp/home2.jsp")
				.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
