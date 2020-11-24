public class CreateBST{
  public static void main(String[] args){
    BinarySearchTree bt = new BinarySearchTree();

    bt.add(50);
    bt.add(17);
    bt.add(72);
    bt.add(12);
    bt.add(23);
    bt.add(54);
    bt.add(76);
    bt.add(9);
    bt.add(14);
    bt.add(67);

    System.out.println(bt.getRoot().getValue());
    System.out.println("Is 8 in this tree? " + bt.find(8));
    System.out.println("Is 14 in this tree? " + bt.find(14));
    System.out.println("Is 9 in this tree? " + bt.find(9));
    System.out.println("Is 99 in this tree? " + bt.find(99));
    System.out.println("Pre Order traversal: ");
    bt.traversePreOrder(bt.getRoot());
    System.out.println();
    System.out.println("Post Order traversal: ");
    bt.traversePostOrder(bt.getRoot());
    System.out.println();
    
    bt.remove(50);
    System.out.println("Removed 50: ");
    bt.traverseInOrder(bt.getRoot());
    System.out.println();
    bt.remove(54);
    System.out.println("Removed 54: ");
    bt.traverseInOrder(bt.getRoot());
    System.out.println();

  }
}
