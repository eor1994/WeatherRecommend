package dev.Or.WeatherRecommend;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Scanner;



import java.net.URI;
import java.net.http.HttpRequest;

@SpringBootApplication
public class WeatherRecommendApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WeatherRecommendApplication.class, args);
		System.out.println("Hello World");

		// 1. Fetch the API response based on API Link
		URL urlOBJ = new URL("https://api.openweathermap.org/data/2.5/weather?lat=53.3498&lon=6.2603&appid=7309101b60a41d1f7102233145794584");
		HttpURLConnection connection = (HttpURLConnection) urlOBJ.openConnection();
		connection.setRequestMethod("GET");

		//response of HTTP Request
		int responseCode = connection.getResponseCode();
		System.out.println("Response CODE: " + responseCode);

		if(responseCode == HttpURLConnection.HTTP_OK){
			StringBuilder sb = new StringBuilder();
			Scanner scanner = new Scanner(connection.getInputStream());
			while(scanner.hasNext()) {
				sb.append(scanner.nextLine());
			}
			System.out.println(sb);


		} else{
			System.out.println("Error in sending a GET Request");
		}

	}

}

