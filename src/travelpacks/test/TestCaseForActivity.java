package travelpacks.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import travelpacks.Activity;

class TestCaseForActivity {

	Activity act1;
	Activity act2;
	Activity act3;
	
	@BeforeEach
	void setUp() throws Exception {
		
		act1 = new Activity("Bungee Jumping", "Mumbai", "Fun activity", 100, 3);
		act2 = new Activity("Rock Climbing", "Pune", "Fun activity", 300, 2);		//will try to exceed the capacity
		act3 = new Activity("Boxing", "Delhi", "Fun activity", 400, 5);
	}

	@Test
	void testToString() {
		assertEquals("Activity Name: Bungee Jumping Description: Fun activity Cost: 100 Capacity: 3", act1.toString());
		assertEquals("Activity Name: Rock Climbing Description: Fun activity Cost: 300 Capacity: 2", act2.toString());
		assertEquals("Activity Name: Boxing Description: Fun activity Cost: 400 Capacity: 5", act3.toString());
	}
	
	@Test
	void testGetCost() {
		assertEquals(100, act1.getCost());
		assertEquals(300, act2.getCost());
		assertEquals(400, act3.getCost());
	}
	
	@Test
	void testGetCapacity() {
		assertEquals(3, act1.getCapacity());
		assertEquals(2, act2.getCapacity());
		assertEquals(5, act3.getCapacity());
	}
	
	@Test
	void testGetActName() {
		assertEquals("Bungee Jumping", act1.getActName());
		assertEquals("Rock Climbing", act2.getActName());
		assertEquals("Boxing", act3.getActName());
	}
	
	@Test
	void testGetDestKey() {
		assertEquals("Mumbai", act1.getDestKey());
		assertEquals("Pune", act2.getDestKey());
		assertEquals("Delhi", act3.getDestKey());
	}
	
	@Test
	void testIncreasePassengerCount() {
		act1.increasePassengerCount();
		act1.increasePassengerCount();
		act1.increasePassengerCount();		// reaching the maximum capacity
		//act2.increasePassengerCount(); 	 will print "Can't exceed capacity." in console
		act2.increasePassengerCount();
		act2.increasePassengerCount();
		act3.increasePassengerCount();
		act3.increasePassengerCount();
		assertEquals(3, act1.getPassengerCount());
		assertEquals(2, act2.getPassengerCount());
		assertEquals(2, act3.getPassengerCount());
	}
	
	@Test
	void testEmptySpaces() {
		act1.increasePassengerCount();
		act1.increasePassengerCount();
		act1.increasePassengerCount();		//will print 0 empty spaces
		act2.increasePassengerCount();
		act2.increasePassengerCount();
		act3.increasePassengerCount();
		act3.increasePassengerCount();
		assertEquals(0, act1.emptySpaces());
		assertEquals(0, act2.emptySpaces());
		assertEquals(3, act3.emptySpaces());

	}
	
}
