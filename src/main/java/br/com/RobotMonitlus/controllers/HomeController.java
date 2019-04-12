package br.com.RobotMonitlus.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.RobotMonitlus.entity.Mensagem;

@Controller
public class HomeController
{

	
	@Autowired
	 RestTemplate restTemplate;
	
   @GetMapping("/")
   public String index()
   {
      return "home/index";
   }
   
   @GetMapping("/sendMessage")
   public String send() throws ParseException
   {
	   
	   for(int i = 0; i <= 100; i++){
		   Locale BRAZIL = new Locale("pt","BR");
		   SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",BRAZIL);
		
		   Date startDate = formato.parse("24/08/2018 00:01:00");
		   Date endDate = formato.parse("26/08/2018 23:59:00");
		   
		   long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
		   Date date = new Date(random);
		    
		   Random ran = new Random();
		   int temp = ran.nextInt((6000 - 2500) + 1) + 1000;
		   
		   Mensagem msg = new Mensagem();
		   msg.setData(temp);
		   msg.setDevice_id("2C0565");
		   msg.setLng("-25.0");
		   msg.setLat("-25.0");
		   msg.setRssi("-23.0");
		   msg.setSnr(3.8);
		   msg.setStation("30A5");
		   msg.setTime(date.getTime());
		   msg.setDatesend(date.getTime());
		   
		   ResponseEntity response = restTemplate.postForEntity("http://144.217.95.136:1337/Mensagens", msg,
				   String.class);
		   
		   System.out.println(response.getBody());
				   //return response.getBody();
		   
		   ObjectMapper mapperObj = new ObjectMapper();
			
			try {
				// get Employee object as a json string
				String jsonStr = mapperObj.writeValueAsString(msg);
				System.out.println(jsonStr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	  
		
      return "home/index";
   }
   
   
   @Bean
   public RestTemplate rest() {
   return new RestTemplate();
   }
}
