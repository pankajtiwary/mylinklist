package com.upwork.operr;

import java.util.Iterator;

public class MyLinkedListImpl<TYPE extends Comparable<TYPE>> implements MyLinkedList<TYPE> {
	
	private Node<TYPE> firstNode;
	
	private Node<TYPE> lastNode;
	
	private int size;
	
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public void push(TYPE type) {
		if(type == null) {
			throw new RuntimeException("Data cant be null");
		}
		if(!(type instanceof Comparable<?>)) {
			throw new RuntimeException("Data must implement Comparable Interface");
		}
		if (firstNode == null) {
			firstNode = new Node<TYPE>();
			firstNode.setData(type);
			firstNode.setNextNode(null);
			firstNode.setPreviousNode(null);
			lastNode = firstNode;
			size++;
		} else {
			Node<TYPE> newNode = new Node<TYPE>();
			newNode.setData(type);
			newNode.setNextNode(null);
			newNode.setPreviousNode(lastNode);
			lastNode.setNextNode(newNode);
			lastNode = newNode;
			size++;
		}
	}
	@Override
	public TYPE pop() {
		if(lastNode == null) {
			return null;
		} else {
			TYPE value = lastNode.getData();
			Node<TYPE> previousNode = lastNode.getPreviousNode();
			if(previousNode == null) {
				lastNode = firstNode = null;
			} else {
				previousNode.setNextNode(null);
				lastNode = previousNode;
			}
			size--;
			return value;
		}
	}
	
	@Override
	public void removeValueGreaterThan(TYPE target) {
		if(target == null) {
			throw new RuntimeException("Data must implement Comparable Interface");
		}
		Node<TYPE> pointer = lastNode;
		while (pointer!=null) {
			TYPE data = pointer.getData();
			if(data.compareTo(target) > 0) {
				size--;
				if(pointer.getNextNode() == null && pointer.getPreviousNode() == null) {
					//when there is only one node in list
					firstNode = lastNode = pointer = null;
				} else if( pointer.getNextNode() == null) {
					//when pointer is pointing to last Node.
					pointer.getPreviousNode().setNextNode(null);
					lastNode = pointer.getPreviousNode();
					pointer = pointer.getPreviousNode();
				} else if(pointer.getPreviousNode() == null) {
					//when pointer is pointing to first Node.
					firstNode = pointer.getNextNode();
					firstNode.setPreviousNode(null);
					pointer = pointer.getPreviousNode();
				} else {
					//when pointer is neither firstNode nor last node.
					pointer.getPreviousNode().setNextNode(pointer.getNextNode());
					pointer = pointer.getPreviousNode();
					
				}
			} else {
				pointer = pointer.getPreviousNode();
			}
		}
	}


	class MyIterator implements Iterator<TYPE> {
		 Node<TYPE> iterNode = firstNode;
		@Override
	    public boolean hasNext() {
	    	return (iterNode != null);
	    }
		@Override
	    public TYPE next() {
			TYPE value = iterNode.getData();
			iterNode = iterNode.getNextNode();
			return value;
	    }
		@Override
	    public void remove() {
	        throw new RuntimeException("Method not supported.");
	    }
	}

	@Override
	public Iterator<TYPE> iterator() {
		return new MyIterator();
	}
	
}


class Node<TYPE> {

	private TYPE data;
	
	private Node<TYPE> nextNode;


	private Node<TYPE> previousNode;
	
	public TYPE getData() {
		return data;
	}

	public void setData(TYPE data) {
		this.data = data;
	}

	public Node<TYPE> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<TYPE> next) {
		this.nextNode = next;
	}
	public Node<TYPE> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node<TYPE> previousNode) {
		this.previousNode = previousNode;
	}	
	
	public String toString() {
		return data.toString();
	}

}
