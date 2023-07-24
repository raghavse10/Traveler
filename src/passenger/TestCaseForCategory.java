package passenger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCaseForCategory {

	Category obj1 = null;
	Category obj2 = null;
	Category obj3 = null;
	Category obj4 = null;
	
	@BeforeEach
	void setUp() throws Exception {
		obj1 = new Category("Standard");
		obj2 = new Category("Gold");
		obj3 = new Category("Premium");
		obj4 = new Category("Platinum!!");
	}

	@Test
	void testGetName() {

		assertEquals("Standard", obj1.getName());
		assertEquals("Gold", obj2.getName());
		assertEquals("Premium", obj3.getName());
		assertEquals("Standard", obj4.getName());
	}
	
	@Test
	void testGetCategoryPrice() {

		assertEquals(0, obj1.getCategoryPrice());
		assertEquals(100, obj2.getCategoryPrice());
		assertEquals(200, obj3.getCategoryPrice());
		assertEquals(0, obj4.getCategoryPrice());
	}
	
	@Test
	void testGetDiscountIndex() {

		assertEquals(1, obj1.getDiscountIndex());
		assertEquals(0.9, obj2.getDiscountIndex());
		assertEquals(0, obj3.getDiscountIndex());
		assertEquals(1, obj4.getDiscountIndex());
	}

}
