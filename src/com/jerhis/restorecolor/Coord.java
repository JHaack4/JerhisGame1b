package com.jerhis.restorecolor;

public class Coord {

	public double x, y;

	public Coord(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Coord() {
		x = 0;
		y = 0;
	}

	public Coord(String s) {
		int k = 2;
		while (s.charAt(k) != ',')
			k++;
		x = Double.parseDouble(s.substring(1, k));
		y = Double.parseDouble(s.substring(k + 1, s.length() - 1));
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public String toString(boolean doInt) {
		return "(" + (int) x + ", " + (int) y + ")";
	}

	public Coord clone() {
		return new Coord(x, y);
	}

}
