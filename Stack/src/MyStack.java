import java.util.ArrayList;


public class MyStack {

	ArrayList<Integer> myStack;
	
	MyStack() {
		myStack = new ArrayList<Integer>();
	}
	int Pop() {
		if(myStack.size()==0)
			return -1;
		
		int val;
		val = myStack.get(myStack.size()-1);
		myStack.remove(myStack.size()-1);
		return val;		
	}
	
	void Push(int val) {
		myStack.add(val);
	}
	
	void Display() {
		System.out.println("Stack : ");
		for(int i=0; i<myStack.size(); i++)
			System.out.print(myStack.get(i)+" ");
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyStack stack = new MyStack();
		stack.Push(1);
		stack.Push(2);
		stack.Push(3);
		stack.Push(4);
		stack.Display();
		
		stack.Pop();
		stack.Display();
		stack.Pop();
		stack.Display();
		
		stack.Pop();
		stack.Pop();
		stack.Display();
	}
}
