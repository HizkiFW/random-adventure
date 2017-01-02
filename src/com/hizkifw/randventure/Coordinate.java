package com.hizkifw.randventure;

public class Coordinate implements java.io.Serializable {
	private static final long serialVersionUID = 5758621914240374406L;

	public final double x;
	public final double y;

	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
