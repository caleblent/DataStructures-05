package aPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * A simple test run to act as a gutcheck of your SortedLinkedList implementation
 * @author gosnat
 *
 */
class TestsOfSortedLinkedList {

	@Test
	void testString() {
		SortedLinkedList<String> sll = new SortedLinkedList<String>();
		assertEquals("Size: 0\n", sll.toString());
		
		assertThrows(IllegalArgumentException.class,
				() -> sll.deleteItem("Vanilla"));
		assertEquals("Size: 0\n", sll.toString());
		
		sll.addItem("Strawberry");
		assertEquals("Size: 1\n0:\tStrawberry\n", sll.toString());
		
		sll.addItem("Chocolate");
		assertEquals("Size: 2\n0:\tChocolate\n1:\tStrawberry\n", sll.toString());
		
		sll.addItem("Vanilla");
		assertEquals("Size: 3\n0:\tChocolate\n1:\tStrawberry\n2:\tVanilla\n", sll.toString());
		
		sll.deleteItem("Strawberry");
		assertEquals("Size: 2\n0:\tChocolate\n1:\tVanilla\n", sll.toString());

		assertThrows(IllegalArgumentException.class,
				() -> sll.deleteItem("Strawberry"));
		assertEquals("Size: 2\n0:\tChocolate\n1:\tVanilla\n", sll.toString());
		
		sll.addItem("Pistachio");
		assertEquals("Size: 3\n0:\tChocolate\n1:\tPistachio\n2:\tVanilla\n", sll.toString());
		
		sll.addItem("Strawberry");
		assertEquals("Size: 4\n0:\tChocolate\n1:\tPistachio\n2:\tStrawberry\n3:\tVanilla\n", sll.toString());
		
		sll.addItem("Strawberry");
		assertEquals("Size: 5\n0:\tChocolate\n1:\tPistachio\n2:\tStrawberry\n3:\tStrawberry\n4:\tVanilla\n", sll.toString());
		
		sll.addItem("Strawberry");
		assertEquals("Size: 6\n0:\tChocolate\n1:\tPistachio\n2:\tStrawberry\n3:\tStrawberry\n4:\tStrawberry\n5:\tVanilla\n", sll.toString());

		sll.deleteItem("Strawberry");
		assertEquals("Size: 5\n0:\tChocolate\n1:\tPistachio\n2:\tStrawberry\n3:\tStrawberry\n4:\tVanilla\n", sll.toString());

		sll.deleteItem("Pistachio");
		assertEquals("Size: 4\n0:\tChocolate\n1:\tStrawberry\n2:\tStrawberry\n3:\tVanilla\n", sll.toString());

		assertThrows(IllegalArgumentException.class,
				() -> sll.deleteItem("Strawberryy"));
		assertEquals("Size: 4\n0:\tChocolate\n1:\tStrawberry\n2:\tStrawberry\n3:\tVanilla\n", sll.toString());

		assertThrows(IllegalArgumentException.class,
				() -> sll.deleteItem("AAA"));
		assertEquals("Size: 4\n0:\tChocolate\n1:\tStrawberry\n2:\tStrawberry\n3:\tVanilla\n", sll.toString());

		assertThrows(IllegalArgumentException.class,
				() -> sll.deleteItem("ZZZ"));
		assertEquals("Size: 4\n0:\tChocolate\n1:\tStrawberry\n2:\tStrawberry\n3:\tVanilla\n", sll.toString());

	}
	
	@Test
	void testInteger() {
		SortedLinkedList<Integer> ill = new SortedLinkedList<>();
		assertEquals("Size: 0\n", ill.toString());
		
		assertThrows(IllegalArgumentException.class,
				() -> ill.deleteItem(42));
		assertEquals("Size: 0\n", ill.toString());
		
		ill.addItem(42);
		assertEquals("Size: 1\n0:\t42\n", ill.toString());
		
		ill.addItem(17);
		assertEquals("Size: 2\n0:\t17\n1:\t42\n", ill.toString());
		
		ill.addItem(50000);
		assertEquals("Size: 3\n0:\t17\n1:\t42\n2:\t50000\n", ill.toString());
		
		ill.deleteItem(17);
		assertEquals("Size: 2\n0:\t42\n1:\t50000\n", ill.toString());

		assertThrows(IllegalArgumentException.class,
				() -> ill.deleteItem(15));
		assertEquals("Size: 2\n0:\t42\n1:\t50000\n", ill.toString());
		
		ill.addItem(101);
		assertEquals("Size: 3\n0:\t42\n1:\t101\n2:\t50000\n", ill.toString());
		
		ill.addItem(102);
		assertEquals("Size: 4\n0:\t42\n1:\t101\n2:\t102\n3:\t50000\n", ill.toString());
		
		ill.addItem(42);
		assertEquals("Size: 5\n0:\t42\n1:\t42\n2:\t101\n3:\t102\n4:\t50000\n", ill.toString());
		
		ill.addItem(42);
		assertEquals("Size: 6\n0:\t42\n1:\t42\n2:\t42\n3:\t101\n4:\t102\n5:\t50000\n", ill.toString());

		ill.deleteItem(50000);
		assertEquals("Size: 5\n0:\t42\n1:\t42\n2:\t42\n3:\t101\n4:\t102\n", ill.toString());

		ill.deleteItem(101);
		assertEquals("Size: 4\n0:\t42\n1:\t42\n2:\t42\n3:\t102\n", ill.toString());

		ill.deleteItem(42);
		assertEquals("Size: 3\n0:\t42\n1:\t42\n2:\t102\n", ill.toString());

		
		assertThrows(IllegalArgumentException.class,
				() -> ill.deleteItem(57));
		assertEquals("Size: 3\n0:\t42\n1:\t42\n2:\t102\n", ill.toString());

		assertThrows(IllegalArgumentException.class,
				() -> ill.deleteItem(-1));
		assertEquals("Size: 3\n0:\t42\n1:\t42\n2:\t102\n", ill.toString());

		assertThrows(IllegalArgumentException.class,
				() -> ill.deleteItem(100000));
		assertEquals("Size: 3\n0:\t42\n1:\t42\n2:\t102\n", ill.toString());

	}
}