package com.hizkifw.randventure;

public class Place {
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
