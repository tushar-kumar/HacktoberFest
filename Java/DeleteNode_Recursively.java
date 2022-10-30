package linkedlist;

import java.util.Scanner;

public class DeleteNode_Recursively {
	
	public static Node<Integer> delete(Node<Integer> head, int pos){
		if(pos == 0)return head.next;
		if(head == null) return head;
		
		head.next = delete(head.next, pos-1);
		return head;
	}
	
	public static Node<Integer> takeInput(){
		Node<Integer> head = null, tail = null;
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		
		while(data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			if(head == null) {
				head = newNode;
			    tail = newNode;
	     	}
			else {
				tail.next = newNode;
				tail = newNode;
				
			}
			data = sc.nextInt();
		}
		sc.close();
		return head;
		
	}
	
	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		head = delete(head,5);
		print(head);

	}

}
