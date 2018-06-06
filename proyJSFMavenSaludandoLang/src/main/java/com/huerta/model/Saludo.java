package com.huerta.model;

public class Saludo {
	private String nom;
	private String lang;

	public Saludo(String nom, String lang){
		this.nom = nom;
		this.lang = lang;
	}

	public String getNom(){
		return nom;
	}

	public void setNom(String nom){
		this.nom = nom;
	}

	public String getLang(){
		return lang;
	}

	public void setLang(String lang){
		this.lang = lang;
	}
}