package anky;

import java.util.ArrayList;

public class LinkedList {
	private Node head = null;
	
		  static class Node {
		    int data;
		    Node next = null;

		    Node(int d) {
		      data = d;
		    }
		  }
		  
		  private LinkedList(Node head) {
			  this.head = head;
		  }

		  public LinkedList(int[] lst) {
		    if (lst.length == 0) {
		      head = null;
		      return;
		    }
		    head = new Node(lst[0]);
		    Node curr = head;
		    for (int i = 1; i < lst.length; i++) {
		      curr.next = new Node(lst[i]);
		      curr = curr.next;
		    }

		  }
		  
		  public LinkedList(int start, int end) {
			  throw new UnsupportedOperationException("TODO");
			  // Create the linked list with values from start -> end
			  // For simplicity start < end
		  }
		  
		  public static LinkedList rev(LinkedList ll) {
			  return new LinkedList(reverse(ll.head));
		  }
		  
		  
		  private static Node reverse(Node n) {
			  // Reverse a linked list from a node
			  // This one has some weird intricacies...
			  throw new UnsupportedOperationException("TODO");
		  }
		  
		  public int[] toArray() {
			  // convert linked list into an int array preserving order
			  throw new UnsupportedOperationException("TODO");
		  }
		  
		  public ArrayList<Integer> toArrayList(){
			  // convert linked list to an int ArrayList preserving order
			  throw new UnsupportedOperationException("TODO");
		  }
		  
		  public int sum() {
			  // sum the list
			  throw new UnsupportedOperationException("TODO");
		  }
		  
		  public int find(int el) {
			  // Return the index of the element or -1 if not found in list
			  throw new UnsupportedOperationException("TODO");
		  }
		  
		  public boolean delete(int el) {
			  // Delete the first element in the list which matches this value
			  throw new UnsupportedOperationException("TODO");
		  }
		  
		  public boolean equals(LinkedList other) {
			  // Return whether a linked list equals another
			  throw new UnsupportedOperationException("TODO");
		  }
		  
		  public void push(int el) {
			  // Append a node to the end of the list with value <el>
			  throw new UnsupportedOperationException("TODO");
		  }
		  
		  public Node pop() {
			  // remove and return the last node in the list 
			  throw new UnsupportedOperationException("TODO");
		  }
		  
		  public boolean insert(int ind, int el) {
			  // insert element <el> at index <ind> return false if index is out of bounds
			  throw new UnsupportedOperationException("TODO");
		  }
		  
		  public void print() {
			  System.out.print(this.toString());
		  }

		  public String toString() {
			var out = "";
		    Node curr = head;
		    while (curr != null) {
		      out += "[" +curr.data;
		      if(curr.next == null) {
		    	  out += "|0x0]";
		      } else {
		    	  out += "|&]->";
		      }
		      curr = curr.next;
		    }
		    return out;
		  }

		  public int length() {
		    // Return the length of the list
			  throw new UnsupportedOperationException("TODO");
		  }
}
