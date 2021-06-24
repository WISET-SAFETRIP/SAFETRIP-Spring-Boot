package com.strip.safetrip;

import com.strip.safetrip.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@SpringBootApplication
public class SafeTripApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SafeTripApplication.class, args);
	}

}

