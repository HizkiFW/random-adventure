package com.hizkifw.randventure;

public class Place implements java.io.Serializable {
	private static final long serialVersionUID = 2811755159514952634L;

	public String name;
	
	public Place dirNorth;
	public Place dirSouth;
	public Place dirEast;
	public Place dirWest;
	
	public Coordinate pos;
	public int elevation;
	
	public Place(String name, Coordinate coords) {
		this.name = name;
		this.pos = coords;
	}
}
