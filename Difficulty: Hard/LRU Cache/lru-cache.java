class LRUCache {

    static class Node{
         int key;
         int val;
        
         Node prev;
         Node next;
        Node(int key_,int val_)
        {
            key=key_;
            val=val_;
        }
        
    }
    
    static int capacity=0;
    
    static Node head=new Node(-1,-1);
    static Node tail=new Node(-1,-1);
    
    static HashMap<Integer,Node> hs=new HashMap<>();
    LRUCache(int cap) {
        // code here
        capacity=cap;
         hs = new HashMap<>();   // RESET

    head = new Node(-1, -1); // RESET
    tail = new Node(-1, -1);
        head.next=tail;
        tail.prev=head;
    }
    
    public static void addNode(Node newNode)
    {
            Node temp=head.next;
            newNode.next=temp;
            newNode.prev=head;
            
            head.next=newNode;
            temp.prev=newNode;
    }
    
    
    public static void deleteNode(Node delNode)
    {
        Node delPrev=delNode.prev;
        Node delNext=delNode.next;
        
        delPrev.next=delNext;
        delNext.prev=delPrev;
    }
    
        
     public static int get(int key) {

        if(!hs.containsKey(key)) return -1;

        Node node = hs.get(key);

        deleteNode(node);
        addNode(node);

        return node.val;
    }
        
    public static void put(int key, int value) {
        //  code here
        if(hs.containsKey(key))
        {
            Node resNode=hs.get(key);
            deleteNode(resNode);
            addNode(resNode);
            resNode.val=value;
            return;
        }
        if(capacity>0&&hs.size()==capacity)
        {
            Node res=tail.prev;
            deleteNode(res);
            hs.remove(res.key);
        }
        Node newNode=new Node(key,value);
        addNode(newNode);
        hs.put(key,newNode);
    }
}