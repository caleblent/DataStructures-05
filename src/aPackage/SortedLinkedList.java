package aPackage;

// initial class logic copied from LinkedList.java in the DataStructuresClass project folder
public class SortedLinkedList<T extends Comparable<? super T>> {
	
	/** The first node in the list */
	private ListNode head;
	
	/** The last node in the list */
	private ListNode tail;

	/** The number of items in the list */
	private int nodeCount;

	/** 
	 * Don't pay too much attention to this constructor since we're going to
	 * move on to a better version soon.  Just know that it's putting all of the
	 * data items from the items array into a LinkedList in the same order
	 * @param items
	 */
	public SortedLinkedList(T[] items) {
		this.clear();
		
		int size;
		if (items != null)
			size = items.length;
		else
			size = 0;
		
		ListNode temp = null;
		for(int i = size-1; i >= 0; i--) {
			temp = new ListNode(items[i], temp);
		}
		head = new ListNode(null, temp);
		nodeCount = size;
	}
	
	public void insert(T value, int index) throws IllegalArgumentException {
		// handles the scenario where they want to insert at index 0 where there is no data
		if (index == 0 && nodeCount == 0) {
			head.next = new ListNode(value, null);
			nodeCount++;
			return;
		}
		if (index < 0 || index > nodeCount)
			throw new IllegalArgumentException(index + " is not a valid index.");
		
		ListNode newNode = new ListNode(value, null);
		if (index == 0) {
			newNode.next = head.next;
			head.next = newNode;
		} else {
			ListNode tempNode = head.next;
			for (int i = 0; i < index - 1; i++) {
				tempNode = tempNode.next;
			}
			ListNode nodeNextToNewNode = tempNode.next;
			tempNode.next = newNode;
			newNode.next = nodeNextToNewNode;
		}
		nodeCount++;
	}
	
	public void delete(T value) throws IllegalArgumentException {
		if (nodeCount == 0)
			throw new IllegalArgumentException("There are no values to delete.");
		ListNode curr = head;
		while (curr.next.data != value) {
			curr = curr.next;
			if (curr.next == tail)
				throw new IllegalArgumentException("Given value cannot be deleted as it doesn't exist.");
		}
		curr.next = curr.next.next;
		nodeCount--;
	}
	
	public void deleteIndex(int index) throws IllegalArgumentException {
		if (nodeCount == 0)
			throw new IllegalArgumentException("There are no values to delete.");
		if (index < 0 || index > nodeCount)
			throw new IllegalArgumentException(index + " is not a valid index.");
		ListNode curr = head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
			if (curr.next == tail)
				throw new IllegalArgumentException("Given value cannot be deleted as it doesn't exist.");
		}
		curr.next = curr.next.next;
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
	
	@Override
	public String toString() {
		String retVal = "";
		
		if (head == null)
			return "";
		
		ListNode ptr = head.next;
		if (ptr == null)
			return "";
		
		while( ptr != null) {
			retVal += ptr.data + " ";
//			if (ptr.next != null) {
//				retVal += "-> ";
//			}
			ptr = ptr.next;
		}
		
		return retVal;
	}
	
	public int getNodeCount() {
		return this.nodeCount;
	}
	
	private void clear() {
		this.head = null;
		this.tail = null;
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

	}
	
}
