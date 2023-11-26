public class Tree {
    public Node root;

    public Tree(String data, int stock) {
        this.root = new Node(data,stock);
    }

    public boolean isEmpty(){
        return root==null;
    }
    public Node getRoot(){
        return root;
    }
    private int getHeight(Node node){
        if(node==null){
            return 0;
        }else{
            return node.getHeight();
        }
    }

    private int getBalance(Node node){
        if (node == null){
            return 0;
        }else{
            return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
        }
    }

    private void updateHeight(Node node) {
        int maxHeight = Math.max(
                getHeight(node.getLeftChild()),
                getHeight(node.getRightChild())
        );
        node.setHeight(maxHeight + 1);
    }

    private Node rightRotate(Node node){
        Node leftNode = node.getLeftChild();
        Node centerNode = leftNode.getRightChild();
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node leftRotate(Node node){
        Node rightNode = node.getRightChild();
        Node centerNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private Node rotation(Node node){
        int balance = getBalance(node);
        if (balance > 1) {
            if (getBalance(node.getLeftChild()) < 0) {
                node.setLeftChild(leftRotate(node.getLeftChild()));
            }
            return rightRotate(node);
        }
        if (balance < -1) {
            if (getBalance(node.getRightChild()) > 0) {
                node.setRightChild(rightRotate(node.getRightChild()));
            }
            return leftRotate(node);
        }
        return node;
    }

    public Tree insert(String data, int stock) {
        root = insert(data, stock, root);
        return this;
    }

    private Node insert(String data, int stock, Node node) {
        if (node == null) {
            return new Node(data, stock);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(data, stock, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(data, stock, node.getRightChild()));
        } else {
            return node;
        }
        updateHeight(node);
        return rotation(node);
    }

    private String getMax(Node node){
        if(node.getRightChild()!=null){
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    public void delete(String data) {
        root = delete(data, root);
    }

    private Node delete(String data, Node node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(data, node.getRightChild()));
        } else {
            
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
    
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }
        updateHeight(node);
        return rotation(node);
    }

    public void print() {
        System.out.println("Producto\t\tStock");
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.getLeftChild());
            System.out.println(node.getData()+"\t\t"+node.getStock()+"\n");
            printInOrder(node.getRightChild());
        }
    }

    public Node search(String data){
        return search(data,root);
    }

    public Node search(String data, Node node){

        if(node == null || node.getData()==data){
            return node;
        }else{
            if(node.getData().compareTo(data)>0){
                return search(data, node.getLeftChild());
            }else if(node.getData().compareTo(data)<0){
                return search(data, node.getRightChild());
            }else{
                return node;
            }
        }
    }
}
