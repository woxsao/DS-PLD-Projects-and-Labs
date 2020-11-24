/**
* Node class
* @author AT
*/
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    public int getValue(){
      return value;
    }

    public Node getLeft(){
      return left;
    }

    public void setValue(int v){
      value = v;
    }
    public Node getRight(){
      return right;
    }

    public void setLeft(Node n){
      left = n;
    }

    public void setRight(Node n){
      right = n;
    }

}
