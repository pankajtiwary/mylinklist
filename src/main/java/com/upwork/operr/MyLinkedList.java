package com.upwork.operr;

import java.util.Iterator;

public interface MyLinkedList<TYPE> extends Iterable<TYPE> {
	
	public int getSize();
	
	public void push(TYPE type);
	
	public TYPE pop();
	
	public void removeValueGreaterThan(TYPE target);
	
	public Iterator<TYPE> iterator();

}
