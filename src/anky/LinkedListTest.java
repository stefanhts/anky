package anky;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void testLength() {
		var ll = new LinkedList(1, 5);
		assert(ll.length() == 5);
		
		ll = new LinkedList(new int[] {});
		assert(ll.length() == 0);
		
		ll = new LinkedList(new int[] {1, 2, 3});
		assert(ll.length() == 3);
	}
	
	@Test
	void testEquals() {
		var fromArray = new LinkedList(new int[] {1, 2, 3});
		assert(fromArray.equals(new LinkedList(1, 3)));
		
		var ll = new LinkedList(1, 4000);
		var l2 = new LinkedList(1, 4000);
		
		assert(ll.equals(l2));
		assert(!ll.equals(LinkedList.rev(ll)));
		ll.delete(7);
		ll.insert(6, 99);
		assert(!l2.equals(ll));
	}
	
	@Test
	void testRev() {
		var ll = new LinkedList(1, 30);
		var l2 = new LinkedList(1, 30);
		assert(LinkedList.rev(LinkedList.rev(ll)).equals(l2));
		
		ll = new LinkedList(new int[] {1, 2, 3});
		l2 = new LinkedList(new int[] {3, 2, 1});
		assert(LinkedList.rev(ll).equals(l2));
	}
	
	
	@Test
	void testPush() {
		var ll = new LinkedList(1, 5);
		ll.push(6);
		
		assert(ll.equals(new LinkedList(1, 6)));
		ll.push(10000);
		assert(ll.equals(new LinkedList(new int[] {1, 2, 3, 4, 5, 6, 10000})));
	}
	
	@Test
	void testPop() {
		var ll =new LinkedList(1, 5);
		var n = ll.pop();
		assert(n.data == 5);
		assert(n.next == null);
		assert(ll.equals(new LinkedList(1, 4)));
		
	}
	
	@Test
	void testFind() {
		var ll = new LinkedList(1, 5);
		assert(ll.find(5) == 4);
		assert(ll.find(1000) == -1);
		assert(ll.find(3) == 2);
	}
	
	@Test
	void testDelete() {
		var ll = new LinkedList(1, 5);
		assert(!ll.delete(77));
		assert(ll.delete(3));
		assert(ll.equals(new LinkedList(new int[] {1, 2, 4, 5})));
	}
	
	@Test
	void testInsert() {
		var ll = new LinkedList(1, 5);
		assert(!ll.insert(1000, 0));
		assert(ll.insert(3, 77));
		assert(ll.equals(new LinkedList(new int[] {1, 2, 3, 77, 4, 5})));
	}
	
	@Test
	void testSum() {
		var ll = new LinkedList(new int[] {1, 2, 3, 4});
		assert(ll.sum() == 10);
		ll = new LinkedList(new int[] {});
		assert(ll.sum() == 0);
	}
	
	@Test
	void testToArray() {
		var arr = new int[] {1,2,3,10101,5,6,7};
		var ll = new LinkedList(arr);
		assert(arrayEquals(arr, ll.toArray()));
	}
	
	@Test
	void testToArrayList() {
		var arr = new int[] {1,2,3,10101,5,6,7};
		var ll = new LinkedList(arr);
		assert(arrayListEquals(arr, ll.toArrayList()));
	}
	
	boolean arrayEquals(int[] a, int[] b) {
		if(a.length != b.length)
			return false;
		for (int i = 0; i< a.length;i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
	
	boolean arrayListEquals(int[] a, ArrayList<Integer> b) {
		if(a.length != b.size())
			return false;
		for (int i = 0; i< a.length;i++) {
			if(a[i] != b.get(i)) {
				return false;
			}
		}
		return true;
	}

}
