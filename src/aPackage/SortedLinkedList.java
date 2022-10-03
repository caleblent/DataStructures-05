package aPackage;

// initial class logic copied from LinkedList.java in the DataStructuresClass project folder
public class SortedLinkedList<T extends Comparable<? super T>> {
	
	/** The first node in the list */
	private ListNode head;
	
	/** The last node in the list */
	private ListNode tail;

	/** The number of items in the list */
	private int nodeCount;

	public SortedLinkedList() {
		tail = new ListNode(null, null);
		head = new ListNode(null, tail);
		nodeCount = 0;
	}
	
	public void addItem(T data) {
		if (nodeCount == 0) {
			ListNode newNode = new ListNode(data, tail);
			head.next = newNode;
		} else {
			ListNode temp = head;
			while (temp.next.data.compareTo(data) < 0) {
				temp = temp.next;
				if (temp.next == tail) {
					break;
				}
			}
			ListNode newNode = new ListNode(data, temp.next);
			temp.next = newNode;
		}
		nodeCount++;
	}
	
	public void deleteItem(T data) throws IllegalArgumentException {
		ListNode temp = head;
		if (temp.next == tail) {
			throw new IllegalArgumentException("Specified data is not present here.");
		}
		while (temp.next.data.compareTo(data) != 0) {
			temp = temp.next;
			if (temp.next == tail) {
				throw new IllegalArgumentException("Specified data is not present here.");
			}
		}
		temp.next = temp.next.next;
		nodeCount--;
	}
	
	/**
	 * Helper method to locate the node at a particular index
	 * Can be used to avoid duplicated code in other methods
	 * Note this is private since it is used to support the public methods
	 * @param index the index you want to locate
	 * @return A pointer to the node at requested index
	 * @throws IllegalArgumentException If requested index is out of bounds
	 */
	private ListNode findNodeAtPosition(int index) throws IllegalArgumentException{
		if (index < 0 || index > nodeCount)
			throw new IllegalArgumentException(index + " is not a valid index.");
		ListNode ptr = head.next;
		if(index >= nodeCount) {
			throw new IllegalArgumentException("Not valid; largest index is " + (nodeCount-1));
		}
		for(int i = 0; i < index; i++) {
			ptr = ptr.next;
		}
		return ptr;
	}
	
	/**
	 * Note that this is returning pointer the data item (type T), not the ListNode object
	 * @param index index that you want to fetch data from
	 * @return data item located at that index
	 * @throws IllegalArgumentException if requested index is out of bounds
	 */
	public T get(int index) throws IllegalArgumentException{
		return findNodeAtPosition(index).data;
	}
	
	/**
	 * Does this item exist in the list?
	 * @param data The data item you're looking for
	 * @return true if data item is already in the list, false if not
	 */
	public boolean contains(T target) {
		if (nodeCount == 0)
			return false;
		ListNode ptr = head.next;
		while(ptr != null && ptr.data != null) {
			if(ptr.data.equals(target))
				return true;
			ptr = ptr.next;
		}
		return false;
	}
	
	/**
	 * This prints out the size of the linked list, and then the indexes and 
	 * elements of all nodes currently in the list.
	 */
	@Override
	public String toString() {
		String str = "";
		
		str += "Size: " + nodeCount + "\n";
		
		for (int i = 0; i < nodeCount; i++) {
			str += i + ":\t" + this.get(i) + "\n";
		}
		
		return str;
	}
	
	public int getNodeCount() {
		return this.nodeCount;
	}

	/**
	 * A private class for our ListNodes
	 * Since this class is private, only code in the LinkedList class can reference it
	 * We can safely make the attributes here public because no one else can get to the private class
	 * This allows for simpler code in our LinkedList class as long as we can trust ourselves
	 * not to supply illegal values
	 * Note that since this is a private class, we're still using the same type T as the LinkedList
	 * class that we are inside of, so no need to re-declare that type parameter here.
	 * @author gosnat
	 *
	 */
	private class ListNode {
		/** The data to store in this node */
		T data;
		/** A pointer to the next node in the list */
		ListNode next;

		/**
		 * Constructor
		 * @param data The actual data item to store
		 * @param next A pointer to the node that should go next in the list
		 */
		public ListNode(T input, ListNode nextNode) {
			data = input;
			next = nextNode;
		}

//		public int compareTo(SortedLinkedList<T>.ListNode other) {
//			return this.data.compareTo(other.data);
//		}

	}
	
}
