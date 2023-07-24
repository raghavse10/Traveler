package passenger;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import travelpacks.Activity;

class TestCaseForPassenger {

	Passenger obj1;
	Passenger obj2;
	Passenger obj3;
	
	@BeforeEach
	void setUp() throws Exception {
		List<Activity> LS = new ArrayList<Activity>();
		LS.add(new Activity("Sky Diving", "Ahmedabad", "Fun activity", 200, 6));
		LS.add(new Activity("Skuba Diving", "Ahmedabad", "Fun activity", 300, 2));
		obj1 = new Passenger("", 201, new Category("STANDARD"), -2000, LS);
		LS.clear();
		
		LS.add(new Activity("Swimming", "Pondicherry", "Fun activity", 400, 3));
		LS.add(new Activity("Fishing", "Pondicherry", "Fun activity", 300, 1));
		obj2 = new Passenger( null, 202, new Category("Premium"), 4000, LS);
		LS.clear();
		
		LS.add(new Activity("Horse Riding", "Pune", "Fun activity", 200, 15));
		obj3 = new Passenger("Vidhu", 203, new Category("Gold"), 0, LS);
		LS.clear();
	}

	@Test
	void testToString() {
		assertEquals("Passenger Name: Vidhu & Passenger Code: 203", obj3.toString());
		assertEquals("Passenger Name: null & Passenger Code: 202", obj2.toString());
		assertEquals("Passenger Name:  & Passenger Code: 201", obj1.toString());
	}
	
	@Test
	void testGetCode() {
		assertEquals(203, obj3.getCode());
		assertEquals(202, obj2.getCode());
		assertEquals(201, obj1.getCode());
	}
	
	@Test
	void testGetBalance() {
		assertEquals(0, obj3.getBalance());
		assertEquals(4000, obj2.getBalance());
		assertEquals(0, obj1.getBalance());
	}
	
	@Test
	void testGetName() {
		assertEquals("Vidhu", obj3.getName());
		assertEquals(null, obj2.getName());
		assertEquals("", obj1.getName());
	}
	
}
