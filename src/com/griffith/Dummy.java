package com.griffith;

import java.util.ArrayList;
import java.util.List;

public class Dummy {

	public boolean isDay() {
		return false;
	}

	public String getName() {
		return "griff";
	}

	public List<Thing> getThings() {
		List<Thing> things = new ArrayList<Thing>();
		things.add(new Thing("test1"));
		things.add(new Thing("test2"));
		return things;
	}

}
