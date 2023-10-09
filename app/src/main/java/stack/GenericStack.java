package stack;

public class GenericStack<T>{
	private class Node{
		public T data;
		public Node prev;
		public Node(T data, Node prev){
			this.data = data;
			this.prev = prev;
		}
	}

	private Node top;
	private int count;

	public GenericStack(){
		top = null;
		count = 0;
	}

	public void push(T item){
		top = new Node(item, top);
		count ++;
	}

	public T pop() throws EmptyStackException{
		if (top == null)
			throw new EmptyStackException();
		count --;
		T ret = top.data;
		top = top.prev;
		return ret;
	}

	public boolean isEmpty(){
		return top == null;
	}

	public int size(){
		return count;
	}
}
