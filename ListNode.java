public class ListNode {
    
    ListNode next;
    String data;
    int stock;
    
    public ListNode(String data, int stock){
        this.data = data;
        this.next = null;
        this.stock = stock;
    }

    public int getStock(){
        return stock;
    }
    public void setStock(int s){
        this.stock = s;
    }
    public String getData(){
        return this.data;
    }
    public void setData(String d){
        this.data = d;
    }
}

