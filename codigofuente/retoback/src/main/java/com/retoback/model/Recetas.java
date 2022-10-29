package com.retoback.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recetas {

	int id_receta;
	String title;
	String image;
	int likes;

	public Recetas () {
		
	}
	
	public Recetas(int id_receta, String title, String image, int likes) {
		super();
		this.id_receta = id_receta;
		this.title = title;
		this.image = image;
		this.likes = likes;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_receta() {
		return id_receta;
	}

	public void setId_receta(int id_receta) {
		this.id_receta = id_receta;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Recetas [id_receta=" + id_receta + ", title=" + title + ", image=" + image + ", likes=" + likes + "]";
	}
	
}
