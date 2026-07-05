package RevNodesInKGrps;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dum=new ListNode(0,head);
        ListNode grpPrev=dum;

        while(true){
            ListNode kth=getKth(grpPrev,k);
            if(kth==null) break;
            ListNode grpNext=kth.next;
            ListNode prev=kth.next;
            ListNode curr=grpPrev.next;
            while(curr!=grpNext){
                ListNode tmp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=tmp;
            }
            ListNode tmp=grpPrev.next;
            grpPrev.next=kth;
            grpPrev=tmp;
        }
        return dum.next;
    }
    private ListNode getKth(ListNode curr,int k){
        while(curr!=null&&k>0){
            curr=curr.next;
            k--;
        }
        return curr;
    }
}

