package stack;

public class EmptyStackException extends CustomException{
	public EmptyStackException(){
		super("Cannot pop, stack is empty");
	}
}
