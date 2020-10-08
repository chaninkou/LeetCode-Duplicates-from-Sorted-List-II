package leetcode82;

public class RemoveAllDuplicatesFromLinkedListFunction {
	public ListNode deleteDuplicates(ListNode head) {
		// To keep track where the solution head should start
        ListNode fakeHead = new ListNode(0);
        
        fakeHead.next = head;
        
        // To know our previous node while moving through duplicates or not
        ListNode previous = fakeHead;
        
        ListNode current = head;
        
        while(current != null){
        	// Go through all the duplicates
            while(current.next != null && current.val == current.next.val){
                current = current.next;
            }
            
            
            if(previous.next == current){ // If this is true, there was no duplicates
                previous = previous.next;
            } else { // This means there were duplicates and we need to update next pointer
                previous.next = current.next;
            }
            
            // Go to next element
            current = current.next;
        }
        
        return fakeHead.next;
    }
	
	// recursive way, hard to read tho
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        // If next element is not duplicate
        if(head.val != head.next.val){
        	// Just move pointer to next element
            head.next = deleteDuplicates(head.next);
            
            return head;
        } else {
        	// If next are the same, point to next
            while(head.next != null && head.val == head.next.val){
                head = head.next;
            }
            
            // Remove the next element of the duplicate
            return deleteDuplicates(head.next);
        }

    }
}
