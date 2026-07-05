package MergeKsortedLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes=new ArrayList<>();
        for(ListNode least:lists){
            while(least!=null){
                nodes.add(least.val);
                least=least.next;
            }
        }
        Collections.sort(nodes);
        ListNode res=new ListNode(0);
        ListNode curr=res;
        for(int node:nodes){
            curr.next=new ListNode(node);
            curr=curr.next;
        }
        return res.next;
    }
}

