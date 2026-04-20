class LRUCache {


    class Node
    {
        int key=0;
        int val=0;
        
        Node next;
        Node prev;
        
        public Node(int key,int val)
        {
            this.key=key;
            this.val=val;
        }
    }
    
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    
    HashMap<Integer,Node> mpp=new HashMap<>();
    
    int capacity=0;
    LRUCache(int cap) {
        // code here
        capacity=cap;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {

        
        //  code here
        
        if(mpp.containsKey(key))
        {
            Node res=mpp.get(key);
            int v=res.val;
            deleteNode(res);
            insertAfterHead(res);
            return v;
        }
        return -1;
    }

        
    public  void put(int key, int value) {
        //  code here
        if(mpp.containsKey(key))
        {
            Node res=mpp.get(key);
            deleteNode(res);
            mpp.remove(res.key);
        }
        if(capacity==mpp.size())
        {
             Node res=tail.prev;
            deleteNode(res);
            mpp.remove(res.key);
        }
        insertAfterHead(new Node(key,value));
        mpp.put(key,head.next);
    }
    
    public  void deleteNode(Node curr)
    {
        Node delPrev=curr.prev;
        Node delNext=curr.next;
        
        delPrev.next=delNext;
        delNext.prev=delPrev;
    }
    public  void insertAfterHead(Node curr)
    {
        curr.prev=head;
        curr.next=head.next;
        head.next.prev=curr;
        head.next=curr;
    }
}