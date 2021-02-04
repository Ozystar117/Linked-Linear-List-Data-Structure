/**
 * 
 */
package singlyLinkedList;

/**
 * @author Emmanuel Ozioma
 *
 */
public class LinkNode<E> {
//	the object to be stored in the node
	public E theObject;
//	reference to the next node in the linked list
	public LinkNode next;
	
	public LinkNode(E theObject, LinkNode next) {
		this.theObject = theObject;
		this.next = next;
	}
}
