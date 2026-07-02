package CopyLinkedLists;

import java.util.HashMap;
import java.util.Map;

//Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class Solution {
    public Node copyRandomList(Node head) {
        Map <Node,Node> oldToNew=new HashMap<>();
        oldToNew.put(null,null);

        Node curr=head;
        while(curr!=null){
            Node copy=new Node(curr.val);
            oldToNew.put(curr, copy);
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            Node copy=oldToNew.get(curr);
            copy.next=oldToNew.get(curr.next);
            copy.random=oldToNew.get(curr.random);
            curr=curr.next;
        }
        return oldToNew.get(head);
    }
}

