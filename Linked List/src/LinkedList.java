
public class LinkedList {

	ListNode start;
	
	LinkedList() {
		start = null;
	}
	LinkedList(ListNode head) {
		start = head;
	}
	
	void Append(ListNode node) {
		ListNode ptr = start;
		
		if(start==null) {
			start = node;
			return;
		}
		
		while(ptr.next!=null) 
			ptr = ptr.next;		
		ptr.next = node;
	}
	
	void DeleteNode(int val) {
		ListNode ptr = start, prev;
		
		//start node to delete
		if(start.value == val){
			start = start.next;
			return;
		}
		
		while(ptr!=null && ptr.next.value!=val)
			ptr = ptr.next;
		
		//not found
		if(ptr==null) 
			return;
		
		//ptr node to delete
		prev = ptr;
		prev.next = ptr.next.next;
	}
	
	void Reverse() {
		ListNode head = null, ptr = start, prev = null; 
					
		while(ptr!=null) {
			head = ptr;
			ptr = ptr.next;
			head.next = prev;						
			prev = head;			
		}
		start = head;		
	}
	
	void Display() {
		ListNode ptr = start;
		
		System.out.println("Linked list: ");
		while(ptr!=null) {
			System.out.print(ptr.value + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list = new LinkedList();
		
		for(int i=0; i<5; i++) {
			ListNode node = new ListNode(i);
			list.Append(node);
		}
		
		list.Display();
		
/*		list.Reverse();
		list.Display();
*/		
		list.DeleteNode(3);
		list.Display();
		
		list.DeleteNode(0);
		list.Display();
		
		list.DeleteNode(4);
		list.Display();
	}
}
