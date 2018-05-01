package soultion.oob_addTwoNumber;


/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author hsj
 *
 */
public class AddTwoNumber_2 {
	
	public static void main(String[] args) {
		ListNode a1 = new ListNode(5);
//		ListNode a2 = new ListNode(4);
//		ListNode a3 = new ListNode(3);
//		a1.next = a2;
//		a2.next = a3;
		
		ListNode b1 = new ListNode(5);
//		ListNode b2 = new ListNode(5);
//		ListNode b3 = new ListNode(4);
//		b1.next = b2;
//		b2.next = b3;
		
		ListNode l1 = a1, l2 = b1;
		ListNode answer = addTwoNumbers(l1, l2);
		System.out.println(answer.val);
		System.out.println(answer.val+" "+answer.next.val);
		//System.out.println(answer.val+" "+answer.next.val+" "+answer.next.next.val);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode answer = null, temp = null, p = l1, q = l2;
		int flag=0;
		int i=0;
		while(p != null && q != null) {
			ListNode l = new ListNode((p.val + q.val + flag)%10);
			flag = (p.val + q.val + flag) / 10;
			if(i == 0) {
				answer = temp = l;
				i = 1;
			}else {
				temp.next = l;
				temp = l;
			}
			p = p.next;
			q = q.next;
		}
		while(p != null) {
			ListNode l = new ListNode((p.val + flag) % 10);
			flag = (p.val + flag) / 10;
			temp.next = l;
			temp = l;
			p = p.next;
		}
		while(q != null) {
			ListNode l = new ListNode((q.val + flag) % 10);
			flag = (q.val + flag) / 10;
			temp.next = l;
			temp = l;
			q = q.next;
		}
		if(flag != 0) {
			ListNode l = new ListNode(flag);
			temp.next = l;
		}
		return answer; 
    }
}
