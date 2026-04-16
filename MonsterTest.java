package com.example.haunted.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class MonsterTest {
	
	private List<Item> loot;
	private Monster monster;
	
	@BeforeEach // Now know how to use BeforeEach
	void makeConstructor() {
		loot = new ArrayList<>();
		loot.add(new Armor("Armor", "Iron", 10));
		
		monster = new Monster("Zombie", 25, 15, 5, loot);
	}
	
	@Test
	void constructorShouldInitializeAllFields() {
		assertEquals("Zombie", monster.getName());
		assertEquals(50, monster.getHealth());
		assertEquals(50, monster.getMaxHealth());
		assertEquals(10, monster.getAttack());
		assertEquals(5, monster.getDefense());
	}
	
	@Test
	void constructorShouldThrowName() {
		assertThrows(NullPointerException.class, () -> new Monster(null, 25, 15, 5, loot));
	}
	
	@Test
	void constructorShouldThrowLoot() {
		assertThrows(NullPointerException.class, () -> new Monster("Zombie", 25, 15, 5, null));
	}
	
	// Damage test --> We should test if it reduces health, non-negative, and test with negative number.
	
	@Test
	void takeDamageShouldReduceHealth() {
		monster.takeDamage(15);
		
		assertEquals(10, monster.getHealth());
	}
	
	@Test
	void takeDamageWithNegativeSouldNot() {
		monster.takeDamage(-5);
		
		assertEquals(25, monster.getHealth());
	}
	
	@Test
	void healthDoesNotGoBelowZero() {
		monster.takeDamage(100);
		
		assertEquals(25, monster.getHealth());
	}
	
	// Alive test should check if monster is dead or not.
	
	@Test
	void isAliveShouldReturnTrueWhenHealthAboveZero() {
		assertTrue(monster.isAlive());
	}
	
	@Test
	void isAliveShouldReturnFalseWhenHealthIsZero() {
		monster.takeDamage(25);
		
		assertFalse(monster.isAlive());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 10, 100})
	
	void takeDamageShouldNotBeBelowZero(int damage) {
		monster.takeDamage(damage);
		
		assertTrue(monster.isAlive());
	}
}
