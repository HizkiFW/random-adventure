package com.hizkifw.randventure;

import java.util.HashMap;

public class Map implements java.io.Serializable {
	private static final long serialVersionUID = 1211127304518996856L;
	public Place startingPoint;
	public HashMap<Coordinate, Place> places;

	public Map(Place startingPoint) {
		this.startingPoint = startingPoint;
		places = new HashMap<>();
		places.put(startingPoint.pos, startingPoint);
	}

	public void newPlace(Place place) {
		places.put(place.pos, place);
	}
}
