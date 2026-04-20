class LRUCache {
    class Node{
        
        int val=0;
        int key=0;

        Node prev,next;
        
        public Node(int key,int val)
        {
            this.key=key;
            this.val=val;
        }
    }
    
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1); 

    int cap=0;

    HashMap<Integer,Node> mp=new HashMap<>();

    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(mp.containsKey(key))
        {
            Node res=mp.get(key);
            int v=res.val;
            deleteNode(res);
            mp.remove(key);
            insertAfterHead(res);
            mp.put(key,head.next);
            return v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key))
        {
            Node res=mp.get(key);
            deleteNode(res);
            mp.remove(res.key);
        }
        if(cap==mp.size())
        {
            Node curr=tail.prev;
            deleteNode(curr);
            mp.remove(curr.key);
        }
        insertAfterHead(new Node(key,value));
        mp.put(key,head.next);
    }

    public void deleteNode(Node curr)
    {
        Node delNext=curr.next;
        Node delPrev=curr.prev;
        delPrev.next=delNext;
        delNext.prev=delPrev;
    }
    public void insertAfterHead(Node curr)
    {
        curr.next=head.next;
        curr.prev=head;
        head.next.prev=curr;
        head.next=curr;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */