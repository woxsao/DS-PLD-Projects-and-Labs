/**
* Node class
* @author AT
*/

public class BinarySearchTree{
  private Node root;

  public BinarySearchTree(){
    root = null;
  }

  public BinarySearchTree(Node r){
    root = r;
  }

  public BinarySearchTree(int rt){
    root = new Node(rt);
  }

  public Node getRoot(){
    return root;
  }

  private Node addR(Node current, int value) {
    if (current == null) {
        return new Node(value);
    }
    if (value < current.getValue()) {
        current.setLeft(addR(current.getLeft(), value));
    } else if (value > current.getValue()) {
        current.setRight(addR(current.getRight(), value));
    } else {
        return current;
    }

    return current;
}

public void add(int value) {
  root = addR(root, value);
}

/**
* Calls the recursive find function
* @param value is the value to find
* @return whether or not that value is in the tree.
*/
public boolean find(int value){
  boolean returnValue = findR(value, root);
  return returnValue;
}

/**
* Finds the value in the search tree
* @param value is the value to find
* @param n is the node that we are using as a root.
* @return whether or not that value is found.
*/
public boolean findR(int value, Node n){
  if(n != null){
    int nVal = n.getValue();
    if(value < nVal){
      return findR(value, n.getLeft());
    }
    else if(value > nVal){
      return findR(value, n.getRight());
    }
    else{
      return true;
    }
  }
  return false;
}

/**
* Recursive method to Remove specified node and shifts the values accordingly according to the
inOrder succession of Binary Search Trees.
* @param value the intended value of the node to remove.
* @param n the node that we are currently on.
* @return the node after it is removed.
*/
public Node removeR(int value, Node n){
  //if item isn't in tree
  if(!find(value)){
    return null;
  }
  //if tree is empty
  if(n == null)
    return null;

  else{
    int nVal = n.getValue();
    if(value < nVal){
      n.setLeft(removeR(value, n.getLeft()));
    }
    else if(value > nVal){
      n.setRight(removeR(value, n.getRight()));
    }
    //if this is the node we are trying to remove
    else{
      //these if else statements are for if there is only one child
      if(n.getLeft() == null){
        return n.getRight();
      }
      else if(n.getRight() == null){
        return n.getLeft();
      }
      else{
        //want to find the smallest item in the right subtree
        n.setValue(minValue(n.getRight()));
        n.setRight(removeR(root.getValue(), root.getRight()));
      }
    }
    return n;
  }
}

/**
* This function serves as a caller for the recursive remove function.
* @param value is the value we are trying to remove
* @return the node that we removed.
*/
public Node remove(int value){
  Node returnNode = removeR(value, root);
  return returnNode;
}

/**
* Returns the minimum value stemming from the inputted node.
* @param n the node we are treating as a root.
* @return the value of the minimum node.
*/
public int minValue(Node n){
  int minimum = root.getValue();
  while(n.getLeft() != null){
    minimum = root.getLeft().getValue();
    n = n.getLeft();
  }
  return minimum;
}

public void traverseInOrder(Node n) {
  if (n != null) {
    traverseInOrder(n.getLeft());
    System.out.print(" " + n.getValue());
    traverseInOrder(n.getRight());
  }
}

/**
* Traverses the tree going root, left, right.
* @param n is the node we are traversing.
*/
public void traversePreOrder(Node n){
  if(n != null){
    System.out.print(" " + n.getValue());
    traversePreOrder(n.getLeft());
    traversePreOrder(n.getRight());
  }
}

/**
* Traverses the tree going left, right, root.
* @param n is the node we are traversing.
*/
public void traversePostOrder(Node n){
  if(n != null){
    traversePostOrder(n.getLeft());
    traversePostOrder(n.getRight());
    System.out.print(" " + n.getValue());
  }
}

}
