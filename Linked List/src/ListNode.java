
public class ListNode {
	
	int value;
	ListNode next;
	
	ListNode(int val) {
		value = val;
		next = null;
	}
	
	ListNode(int val, ListNode nextNode) {
		value = val;
		next = nextNode;
	}	
	
	void Display() {
		System.out.println("List node: "+value+ " next: "+next.value);
	}
}
