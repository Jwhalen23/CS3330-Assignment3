package com.example.haunted.model;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
	
	@Test
	void constructorShouldInitializeFields() {
		Weapon weapon = new Weapon("Sword", "Diamond", 15);
		
		assertEquals("Sword", weapon.getName());
		assertEquals("Diamond", weapon.getDescription());
		assertEquals(15, weapon.getAttackBonus());
	}
	
	@Test
	void weaponShouldImplement() {
		
		Weapon weapon = new Weapon("Sword", "Diamond", 15);
		
		assertTrue(weapon instanceof Equippable);
	}
	
	
	// Test edge cases with attack bonus
	@ParameterizedTest
	@ValueSource(ints= {0, 1, 10, -15})
	@Test
	void getAttackBonusShouldSucceedWithEdge(int bonusDamage) {
		Weapon weapon = new Weapon("TEst Sword", "Test", 15);
		
		assertEquals(bonusDamage, weapon.getAttackBonus());
	}
}
