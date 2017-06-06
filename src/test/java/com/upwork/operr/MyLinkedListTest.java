package com.upwork.operr;


import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {

	MyLinkedList<Integer> list = null;

	@Before
	public void setUp() {
		list = new MyLinkedListImpl<>();
		assertTrue("Size not matching ", list.getSize() == 0);
		list.push(0);
		assertTrue("Size not matching ", list.getSize() == 1);
		list.push(1);
		assertTrue("Size not matching ", list.getSize() == 2);
		list.push(2);
		assertTrue("Size not matching ", list.getSize() == 3);
		list.push(3);
		assertTrue("Size not matching ", list.getSize() == 4);
		list.push(4);
		assertTrue("Size not matching ", list.getSize() == 5);
	}

	@After
	public void destroy() {

	}

	@Test
	public void testPop() {
		
		assertTrue("Size should be 5 now ", list.getSize() == 5);
		
		Integer value = list.pop();
		assertTrue("Value should be 4 ", value == 4);
		assertTrue("Size should be 4 now ", list.getSize() == 4);
		
		value = list.pop();
		assertTrue("Value should be 3 ", value == 3);
		assertTrue("Size should be 3 now ", list.getSize() == 3);
		
		value = list.pop();
		assertTrue("Value should be 2 ", value == 2);
		assertTrue("Size should be 2 now ", list.getSize() == 2);
		
		value = list.pop();
		assertTrue("Value should be 2 ", value == 1);
		assertTrue("Size should be 2 now ", list.getSize() == 1);
		
		value = list.pop();
		assertTrue("Value should be 0 ", value == 0);
		assertTrue("Size should be 0 now ", list.getSize() == 0);		
	}
	
	@Test
	public void testRemoveTarget1() {
		
		list = new MyLinkedListImpl<>();
		assertTrue("Size not matching ", list.getSize() == 0);
		list.push(0);
		assertTrue("Size not matching ", list.getSize() == 1);
		list.push(1);
		assertTrue("Size not matching ", list.getSize() == 2);
		list.push(2);
		assertTrue("Size not matching ", list.getSize() == 3);
		list.push(3);
		assertTrue("Size not matching ", list.getSize() == 4);
		list.push(4);
		assertTrue("Size not matching ", list.getSize() == 5);
		
		list.removeValueGreaterThan(1);
		assertTrue("Size not matching ", list.getSize() == 2);
		Iterator<Integer> iter = list.iterator();
		int expectedValue =0;
		while(iter.hasNext()) {
			Integer value = iter.next();
			assertTrue("Value not matching, realValue=" + expectedValue + ", expectedValue " + expectedValue, value == expectedValue);
			expectedValue++;
		}
	}
	
	@Test
	public void testRemoveTarget2() {
		
		list = new MyLinkedListImpl<>();
		assertTrue("Size not matching ", list.getSize() == 0);
		list.push(4);
		assertTrue("Size not matching ", list.getSize() == 1);
		list.push(3);
		assertTrue("Size not matching ", list.getSize() == 2);
		list.push(2);
		assertTrue("Size not matching ", list.getSize() == 3);
		list.push(1);
		assertTrue("Size not matching ", list.getSize() == 4);
		list.push(0);
		assertTrue("Size not matching ", list.getSize() == 5);
		
		list.removeValueGreaterThan(1);
		assertTrue("Size not matching ", list.getSize() == 2);
		Iterator<Integer> iter = list.iterator();
		int expectedValue =1;
		while(iter.hasNext()) {
			Integer value = iter.next();
			assertTrue("Value not matching, realValue=" + expectedValue + ", expectedValue " + expectedValue, value == expectedValue);
			expectedValue--;
		}
	}
	
	@Test
	public void testRemoveTarget3() {
		
		list = new MyLinkedListImpl<>();
		assertTrue("Size not matching ", list.getSize() == 0);
		list.push(3);
		assertTrue("Size not matching ", list.getSize() == 1);
		list.push(4);
		assertTrue("Size not matching ", list.getSize() == 2);
		list.push(0);
		assertTrue("Size not matching ", list.getSize() == 3);
		list.push(1);
		assertTrue("Size not matching ", list.getSize() == 4);
		list.push(2);
		assertTrue("Size not matching ", list.getSize() == 5);
		
		list.removeValueGreaterThan(1);
		assertTrue("Size not matching ", list.getSize() == 2);
		Iterator<Integer> iter = list.iterator();
		int expectedValue =0;
		while(iter.hasNext()) {
			Integer value = iter.next();
			assertTrue("Value not matching, realValue=" + expectedValue + ", expectedValue " + expectedValue, value == expectedValue);
			expectedValue++;
		}
	}

	
	
	@Test
	public void testRemoveTarget4() {
		
		list = new MyLinkedListImpl<>();
		assertTrue("Size not matching ", list.getSize() == 0);
		list.push(3);
		
		list.removeValueGreaterThan(1);
		assertTrue("Size not matching ", list.getSize() == 0);
	}
	
	@Test
	public void testRemoveTarget5() {
		
		list = new MyLinkedListImpl<>();
		assertTrue("Size not matching ", list.getSize() == 0);
		list.push(3);
		
		list.removeValueGreaterThan(3);
		assertTrue("Size not matching ", list.getSize() == 1);
	}
}
