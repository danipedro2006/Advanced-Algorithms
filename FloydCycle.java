package diverse;

public class FloydCycle {
	
	static Node head;
	
	public void push(int data) {
		
		Node newnode=new Node(data);
		newnode.next=head;
		head=newnode;
	}
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next=null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	static void detectloop() {
		Node slow=head;
		Node fast=head;
		
		while(slow!=null && fast!=null && fast.getNext()!=null) {
			slow=slow.getNext();
			fast=fast.getNext().getNext();
			if(slow==fast) {
				System.out.println("Cycle detected");
				break;
			}
		}
	}
	public static void main(String[] args) {
		FloydCycle linkedlist=new FloydCycle();
		linkedlist.push(10);
		linkedlist.push(20);
		linkedlist.push(40);
		linkedlist.push(15);
		linkedlist.push(30);
		
		linkedlist.head.next.next.next=linkedlist.head;
		detectloop();

	}

}
