/**
 * Nodo
 */
public class Node {
    private Node rightChild, leftChild;
    private int height, stock;
    private String data;

    public Node (String data,int n){
        this.data=data;
        this.height=1;
        this.leftChild=null;
        this.rightChild=null;
        this.stock=n;
    }
    public int getStock(){
        return this.stock;
    }

    public void setStock(int n){
        this.stock=n;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
    
}