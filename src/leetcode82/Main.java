package leetcode82;


import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] input = {1,2,2,3,3,4};
		
		System.out.println("Input: " + Arrays.toString(input));
		
		ListNode head = insertNode(input);
		
		RemoveAllDuplicatesFromLinkedListFunction solution = new RemoveAllDuplicatesFromLinkedListFunction();
		
		displayLinkedList(solution.deleteDuplicates(head));
		
	}
	
	public static ListNode insertNode(int[] input){
		ListNode dummyRoot = new ListNode(0);
		ListNode previous = dummyRoot;
		
		for(int item : input){
			previous.next = new ListNode(item);
			previous = previous.next;
		}
	
		return dummyRoot.next;
	}
	
	public static void displayLinkedList(ListNode head){
		ListNode current = head;
		
		while(current != null){
			System.out.print(current.val + " ");
			
			current = current.next;
		}
		
		System.out.println(" ");
	}
}
