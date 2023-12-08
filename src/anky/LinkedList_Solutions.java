package anky;

import java.util.ArrayList;

public class LinkedList_Solutions {
	private Node head = null;
	
		  static class Node {
		    int data;
		    Node next = null;

		    Node(int d) {
		      data = d;
		    }
		  }
		  
		  private LinkedList_Solutions(Node head) {
			  this.head = head;
		  }
		  

		  public LinkedList_Solutions(int[] lst) {
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
		  
		  public LinkedList_Solutions(int start, int end) {
			  // For simplicity start < end
			  head = new Node(start);
			  Node curr = head;
			  for(int i = start + 1; i <= end; i++) {
				  curr.next = new Node(i);
				  curr = curr.next;
			  }
		  }
		  
		  public static LinkedList_Solutions rev(LinkedList_Solutions ll) {
			  return new LinkedList_Solutions(reverse(ll.head));
		  }
		  
		  
		  private static Node reverse(Node n) {
			  // This one has some weird intricacies...
			  	Node tip = n;
			    Node curr = n;
			    Node prev = null;

			    while (curr != null) {
			      Node nxt = curr.next;
			      curr.next = prev;
			      prev = curr;
			      curr = nxt;
			    }
			    tip = prev;
			    return tip;
		  }
		  
		  public int[] toArray() {
			  Node curr = head;
			  int[] out = new int[this.length()];
			  for(int i=0; i<out.length; i++) {
				  out[i] = curr.data;
				  curr = curr.next;
			  }
			  return out;
		  }
		  
		  public ArrayList<Integer> toArrayList(){
			  Node curr = head;
			  ArrayList<Integer> out = new ArrayList<>();
			  while (curr != null) {
				  out.add(curr.data);
				  curr = curr.next;
			  }
			  return out;
		  }
		  
		  public int sum() {
			  Node curr = head;
			  int sum = 0;
			  while (curr != null) {
				  sum += curr.data;
				  curr = curr.next;
			  }
			  return sum;
		  }
		  
		  public int find(int el) {
			  // Return the index of the element or -1 if not found
			  Node curr = head;
			  int ind = 0;
			  while(curr != null) {
				  if(curr.data == el)
					  return ind;
				  curr = curr.next;
				  ind ++;
			  }
			  return -1;
		  }
		  
		  public boolean delete(int el) {
			  Node curr = head;
			  
			  if(curr.data == el) {
				  head = curr.next;
				  return true;
			  }
			  while(curr.next != null) {
				  if(curr.next.data == el) {
					  curr.next = curr.next.next;
					  return true;
				  }
				  curr = curr.next;
			  }
			  return false;
		  }
		  
		  public boolean equals(LinkedList_Solutions other) {
			  Node curr = head;
			  Node othCurr = other.head;
			  while(curr != null && othCurr != null) {
				  if(curr.data != othCurr.data) {
					  return false;
				  }
				  curr = curr.next;
				  othCurr = othCurr.next;
			  }
			  if(othCurr != null || curr != null) {
				  return false;
			  }
			  return true;
		  }
		  
		  public void push(int el) {
			  Node curr = head;
			  if(head == null) {
				  head = new Node(el);
				  return;
			  }
			  while (curr.next != null) {
				  curr = curr.next;
			  }
			  curr.next = new Node(el);
		  }
		  
		  public Node pop() {
			  if(head == null) {
				  return null;
			  }
			  if(head.next == null) {
				  Node out = new Node(head.data);
				  head = null;
				  return out;
			  }
			  Node curr = head;
			  Node out = null;
			  while (curr.next.next != null) {
				  curr = curr.next;
			  }
			  out = new Node(curr.next.data);
			  curr.next = null;
			  return out;
		  }
		  
		  public boolean insert(int ind, int el) {
			  if(this.length() < ind) {
				  return false;
			  }
			  Node curr = head;
			  int i = 0;
			  while(curr != null) {
				  if(ind == i+1) {
					  Node ins = new Node(el);
					  ins.next = curr.next;
					  curr.next = ins;
					  return true;
				  }
				  curr = curr.next;
				  i++;
			  }
			  curr = new Node(el);
			  return true;
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
		    Node curr = head;
		    int len = 0;
		    while (curr != null) {
		      len++;
		      curr = curr.next;
		    }
		    return len;
		  }
}
