/**
 * 
 */
package singlyLinkedList;

import java.util.NoSuchElementException;


import linkedList.LinkedList;

/**
 * @author Emmanuel Ozioma
 *
 */
public class LinkedLinearList<E> implements LinkedList<E>{
//	reference to the node at the beginning of the linked list
	private LinkNode<E> head;
//	the size of the linked list
	private int size;
	
	public LinkedLinearList() {
//		initialise the fields
		head = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Object get(int index) {
		if(indexIsValid(index)) {
			LinkNode<E> currentLinkNode = head;
			E theObject = head.theObject;
			if(index != 0) {
				for(int i = 0; i < index ; i++) {
					currentLinkNode = currentLinkNode.next;
				}
			}
			
			return currentLinkNode.theObject;
		}
		throw new IndexOutOfBoundsException("index + " + index + "  size: " + size);
	}

//	return the index of a specified object
	@Override
	public int indexOf(Object object) {
		int index = 0;
		LinkNode<E> currentLinkNode = head;
//		loop through the list
		while(currentLinkNode != null) {
//			check if the object to be found matches the object in the current link node
			if(currentLinkNode.theObject == object) {
				return index;
			}
			//update the current link node the loop is on
			currentLinkNode = currentLinkNode.next;
			//update the index to that of the current link node
			index++;
		}
//		if the compiler reaches here, the object was not found hence, throw an error
		throw new NoSuchElementException();
	}

	/**
	 * remove an object from the list and return that object
	 * 
	 * ensure that if the index is not 0, currentLinkNode should be the node just before the node to be removed before removing the node
	 */
	@Override
	public Object remove(int index) {
		LinkNode<E> removedLinkNode = null;
		if(index == 0) {
			removedLinkNode = head;
			head = head.next;
		}else {
			LinkNode<E> currentLinkNode = head;
			for(int i = 0; i < index; i++) {
				if(i == index - 1) {
					removedLinkNode = currentLinkNode.next;
//					remove the node
					currentLinkNode.next = currentLinkNode.next.next; 
				}
				currentLinkNode = currentLinkNode.next;
			}
		}
		return removedLinkNode.theObject;
//		throw new IndexOutOfBoundsException("index: " + index + "  size: " + size);
	}

	@Override
	public void add(int index, Object theObject) {
		// TODO Auto-generated method stub
		
	}

//	Add an object to the beginning of the list
	@Override
	public void addFirst(Object theObject) {
//		check if the list is not empty
		if(!isEmpty()) {
			head = new LinkNode(theObject, head);
		}else {
			head = new LinkNode(theObject, null);
		}
		size++;
	}

//	Add an object to the end of the list
	@Override
	public void addLast(Object theObject) {
//		if the list is empty, add the object as the first object
		if(isEmpty()) {
			addFirst(theObject);
		}else {
			//create a new LinkNode to store the object and set its reference to the next object to be null
			LinkNode<E> newLinkNode = new LinkNode(theObject, null); 
			//create a reference to the object at the beginning of the list
			LinkNode current = head; 
			// loop through the list
			while(current.next != null) {
				current = current.next;
			}
			// set the last node to reference the new node as the next node on the list
			current.next = newLinkNode;
		}
//		increase the size of the list
		size++;
	}

	@Override
	public String outputList() {
		String output = "[";
		LinkNode<E> current = head;
		while(current != null) {
			output += current.theObject + ", ";
			current = current.next;
		}
		if(size > 0) {
			output = output.substring(0, output.length() - 2);
		}
		return output + "]";
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFound(Object theObject) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean indexIsValid(int index) {
		return index >= 0 && index < size;
	}
	
}
