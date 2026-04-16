package com.example.haunted.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrapTest {
	
	private Trap trap;
	
	@BeforeEach
	void makeConstructor() {
		trap = new Trap("Electric Trap", TrapType.ELECTRIC, 15, true, true);
	}
	
	@Test
	void constructorShouldInitializeFieldsCorrectly() {
		assertEquals("Electric Trap", trap.getName());
		assertEquals(TrapType.ELECTRIC, trap.getType());
		assertEquals(20, trap.getDamage());
		assertTrue(trap.isArmed());
		assertTrue(trap.isOneTimeTrigger());
	}
	
	@Test
	void constructorShouldThrowIfTypeIsNull() {
		assertThrows(NullPointerException.class, () -> new Trap("Electric Trap", null, 15, true, true));
	}
	
	// Trap tests
	@Test
	void disarmShouldMakeArmedFalse() {
		trap.disarm();
		
		assertFalse(trap.isArmed());
	}
	
	@Test
	void disarmShouldStayFalse() {
		trap.disarm();
		trap.disarm();
		
		assertFalse(trap.isArmed());
	}
	
	
}
