public class List {
    ListNode head;

    public List(){
        head  = null;
    }
    
    public void insert(String data, int stock){ 
        ListNode n = new ListNode(data, stock);
        if(head == null){
            head = n;
        }else{
            ListNode pointer = head;

            while(pointer.next != null){
                pointer = pointer.next;
            }
            pointer.next = n;
        }
    }

    public void makeEmpty(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }

}
