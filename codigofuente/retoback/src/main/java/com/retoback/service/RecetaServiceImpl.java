package com.retoback.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retoback.model.Content;
import com.retoback.model.Ingredientes;
import com.retoback.model.Recetas;
import com.retoback.request.recetaRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class RecetaServiceImpl implements RecetaService {
	
	@Value("${api.private.base.url.ingredientes}")
	private String nameService;
	
	@Value("${api.private.key}")
	private String apiKey;
	
	@SuppressWarnings("unchecked")
	@Override
	public recetaRequest listarRecetasPorIngredientes(Ingredientes ingredientes) {
		// TODO Auto-generated method stub
		    recetaRequest recetaRequest = new recetaRequest();
		      
		    System.out.println("getIngredientes:"+ingredientes.getIngredientes());
		    
		    RestTemplate restTemplate = new RestTemplate();
		    
		    StringBuilder stb =new StringBuilder();
		    
		    if(ingredientes!= null) {
		    	
		    	for(int i=0; i <ingredientes.getIngredientes().length;i++) {
		    		stb.append(",");
		    		stb.append(ingredientes.getIngredientes()[i]);
		    	}
		    }
		    System.out.println("stb:"+stb.toString());
		    final String baseUrl = nameService + "?apiKey="+apiKey+"&"+"ingredients="+stb.toString();
		    
		    System.out.println("baseUrl:"+baseUrl);
		    URI uri;
			try {
				uri = new URI(baseUrl);
				   ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
				    
				   if (response.getStatusCodeValue() != 200 || Objects.isNull(response.getBody())) {
					  	recetaRequest.setCode(response.getStatusCodeValue());
		            	recetaRequest.setMessage("error");
					   return recetaRequest;
		            } else {
		           
		            	recetaRequest.setCode(response.getStatusCodeValue());
		            	recetaRequest.setMessage("success");
		            	  String  resultado = response.getBody();

		                    JsonParser parser = new JsonParser();
		                    JsonElement jsonTree = parser.parse(resultado);
		                    //JsonObject jsonObject = jsonTree.getAsJsonObject();
		                    JsonArray  usersArray = jsonTree.getAsJsonArray();
		                    List<Content> ListContent = new ArrayList<Content>();
		                    for (JsonElement data : usersArray) {
		                    	// String valoresConcat = "<"+data.getAsJsonObject().get("id").getAsString()+">"+"|"+"<"+data.getAsJsonObject().get("last_name").getAsString()+">"+"|"+"<"+data.getAsJsonObject().get("email").getAsString()+">";
		                    	 Content oContent = new Content(); 
		                    	 oContent.setTitle(data.getAsJsonObject().get("title").getAsString());
		                    	 oContent.setImage(data.getAsJsonObject().get("image").getAsString());
		                    	 oContent.setLikes(Integer.parseInt(data.getAsJsonObject().get("likes").getAsString()));
		                    	 ListContent.add(oContent);
		                    	
		                    	}
		                    recetaRequest.setContent(ListContent);
		                   /* JsonObject jsonObject = jsonTree.getAsJsonObject();
		                    JsonArray  usersArray = jsonObject.getAsJsonArray("data");
		                   
		                    for (JsonElement data : usersArray) {
		                    	 String valoresConcat = "<"+data.getAsJsonObject().get("id").getAsString()+">"+"|"+"<"+data.getAsJsonObject().get("last_name").getAsString()+">"+"|"+"<"+data.getAsJsonObject().get("email").getAsString()+">";
		                    	 users.add(valoresConcat);
		                    	 oUser.setData(users);
		                    	}*/
		            }

			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		 
		return recetaRequest;
	}
	
}