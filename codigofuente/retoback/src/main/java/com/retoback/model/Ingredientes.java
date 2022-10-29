package com.retoback.model;

import java.util.Arrays;

public class Ingredientes {

	String[] ingredientes;

	public String[] getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String[] ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		return "Ingredientes [ingredientes=" + Arrays.toString(ingredientes) + "]";
	}
		
}
