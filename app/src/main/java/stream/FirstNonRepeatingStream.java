package stream;

public class FirstNonRepeatingStream{
	/// Unique Stream Node
	private class Node{
		public char ch;
		public Node next, prev;
		public Node(char ch, Node prev, Node next){
			this.ch = ch;
			this.prev = prev;
			this.next = next;
		}
	}

	private void printStream(){
		Node curr = head;
		System.out.println("head: " + (head == null ? "null" : head.ch));
		System.out.println("tail: " + (tail == null ? "null" : tail.ch));
		while (curr != null){
			System.out.print(curr.ch + " -> ");
			curr = curr.next;
		}
		System.out.println(" null\n");
	}

	private void nodeRemove(char ch){
		int code = (int)ch;

		if (stream[code] == head){
			if (stream[code] == tail){
				head = tail = null;
				return;
			}
			// move head ahead
			head = stream[code].next;
			if (head != null)
				head.prev = null;
			return;
		}

		if (stream[code] == tail){
			tail = tail.prev;
			if (tail != null)
				tail.next = null;
			return;
		}

		// make prev node skip this node
		stream[code].prev.next = stream[code].next;
		// make next node skip this node
		stream[code].next.prev = stream[code].prev;
	}

	/// characters that have occurred
	private boolean[] occurred;
	/// characters that have occurred more than once
	private boolean[] badChars;

	/// Unique Stream Linked List
	private Node head, tail;
	private Node[] stream;

	public FirstNonRepeatingStream(){
		occurred = new boolean[256];
		badChars = new boolean[256];
		stream = new Node[256];
		for (int i = 0; i < 256; i ++){
			occurred[i] = false;
			badChars[i] = false;
			stream[i] = null;
		}
	}

	public void add(char ch){
		int code = (int)ch;
		if (occurred[code]){
			badChars[code] = true;
			// remove it's node
			nodeRemove(ch);
			//printStream();
			return;
		}
		occurred[code] = true;
		stream[code] = new Node(ch, tail, null);

		if (tail != null)
			tail.next = stream[code];
		tail = stream[code];

		if (head == null)
			head = stream[code];
		//printStream();
	}

	public char getFirstNonRepeating(){
		if (head == null)
			return '-';
		return head.ch;
	}
}
