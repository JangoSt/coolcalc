package com.damaja.cocktailmixxer.Components;

import com.damaja.cocktailmixxer.R;

import java.io.Serializable;


//@ Project : Cocktailmixxer
//@ Date : 31.10.2013
//@ Author : Matthias Wildberg, Jakob Nisin

public class Saft extends RowItem implements Serializable, Cloneable {
	/**
	 * 
	 *
	 */
	static int imageId = R.drawable.icons_saft;
	private double AlkGehalt;
	private int Behaelter;
	public String Kategorie;
	private static final long serialVersionUID = 11L;

	public Saft(String title, String description, int procent) {
		super(imageId, title, description);
		// TODO Auto-generated constructor stub
		this.procent=procent;
	}

	private int S_ID;
	private int procent = 0;

	// Wert an ml im spziefischem Cocktail
	private int ml = 0;

	public int getMl() {
		return ml;
	}

	public void setMl(int ml) {
		this.ml = ml;
		AlkGehalt = getAlkMl();
	}

	private String Name;
	private String decs;

	public Object clone() throws CloneNotSupportedException {
		/*
		 * Hier wird die Methode clone der Superklasse(in diesem Falle Object)
		 * aufgerufen.
		 */
		return super.clone();
	}


	public double getAlkMl() {
		double ret = ((double)ml)/100*procent;
		return ret;
	}

	public String toString() {
		return "";
	}

	public void setdescNormal() {
			super.setDesc("---");

	}

	public void setDescList() {
			super.setDesc("Getr�nkanteil im Cocktail: \n" + Math.round(procent)
					+ " %" + "\n" + procent * Math.round((500 / 100)) + " ml");

	}

}
