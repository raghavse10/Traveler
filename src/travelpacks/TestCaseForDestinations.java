package travelpacks;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseForDestinations {

	Destination d1;
	Destination d2;

	List<Activity> LS1 = new ArrayList<Activity>();
	List<Activity> LS2 = new ArrayList<Activity>();
	@BeforeEach
	void setUp() throws Exception {
		
		LS1.add(new Activity("Sky Diving", "Ahmedabad", "Fun activity", 200, 6));
		LS1.add(new Activity("Skuba Diving", "Ahmedabad", "Fun activity", 300, 2));
		d1 = new Destination("Ahmedabad", LS1);
		
		LS2.add(new Activity("Go Karting", "Mumbai", "Fun activity", 200, 4));
		LS2.add(new Activity("Bird Watching", "Mumbai", "Fun activity", 400, 5));
		d2 = new Destination("Mumbai", LS2);
	}

	@Test
	void testGetActList() {
		assertTrue(LS1.equals(d1.getActList()));
		assertTrue(LS2.equals(d2.getActList()));
	}

	@Test
	void testAddActivity() {

		Activity act1 = new Activity("Car Racing", "Ahmedabad", "Fun activity", 500, 3);
		d1 = d1.addActivity(act1);
		LS1.add(act1);
		assertTrue(LS1.equals(d1.getActList()));
		
		Activity act2 = new Activity("Bungee Jumping", "Mumbai", "Fun activity", 800, 4);
		d2 = d2.addActivity(act2);
		LS2.add(act2);
		assertTrue(LS2.equals(d2.getActList()));
	}

	@Test
	void testGetName() {
		assertEquals("Mumbai", d2.getName());
		assertEquals("Ahmedabad", d1.getName());
	}

}
