/**
 * 
 */
package singlyLinkedList;

import linkedList.LinkedList;

/**
 * @author Emmanuel Ozioma
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing Singly linked list");
		LinkedList<String> linearList = new LinkedLinearList<String>();
		System.out.println(linearList.outputList());
		linearList.addFirst("c");
		System.out.println(linearList.outputList());
		linearList.addFirst("b");
		linearList.addFirst("a");
		System.out.println(linearList.outputList());
		linearList.addLast("d1");
		System.out.println(linearList.outputList());
		linearList.addFirst("d0");
		System.out.println(linearList.outputList());
		linearList.addLast("d2");
		System.out.println(linearList.outputList());
		System.out.println(linearList.indexOf("d0"));
		System.out.println(linearList.remove(4));
		System.out.println(linearList.outputList());
	}

}
