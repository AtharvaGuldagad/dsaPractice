package RemoveNnodes;

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int N=0;
        ListNode curr=head;
        while(curr!=null){
            N++;
            curr=curr.next;
        }
        int rmIndex=N-n;
        if(rmIndex==0) return head.next;
        curr=head;
        for(int i=0;i<N-1;i++){
            if((i+1)==rmIndex){
                curr.next=curr.next.next;
                break;
            }
            curr=curr.next;
        }
        return head;
    }
}
