package com.hizkifw.randventure;

public class Place implements java.io.Serializable {
	private static final long serialVersionUID = 2811755159514952634L;

	public String name;
	
	public Coordinate dirNorth;
	public Coordinate dirSouth;
	public Coordinate dirEast;
	public Coordinate dirWest;
	
	public Coordinate pos;
	public int elevation;
	
	public Place(String name, Coordinate coords) {
		this.name = name;
		this.pos = coords;
	}
}
