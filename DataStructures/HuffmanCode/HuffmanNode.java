public class HuffmanNode implements Comparable<HuffmanNode> {

    //The number of times the characters appear in the string
    private int frequency;
    //The list of characters contained in this node
    private char[] characters;
    //Left and right children
    private HuffmanNode leftChild, rightChild;


    public HuffmanNode(char character, int frequency){
      characters = new char[0];
      characters[0] = character;
      this.frequency =frequency;
      leftChild = null;
      rightChild = null;
    }
    //Constructor
    public HuffmanNode(char[] characters, int frequency, HuffmanNode leftChild, HuffmanNode rightChild){
      this.characters = characters;
      this.frequency = frequency;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
    }

    public char[] getCharacters(){
      return characters;
    }
    public int getFrequency(){
      return frequency;
    }
    public HuffmanNode getLeftChild(){
      return leftChild;
    }
    public HuffmanNode getRightChild(){
      return rightChild;
    }
    public void setLeftChild(HuffmanNode newNode){
      leftChild = newNode;
    }
    public void setRightChild(HuffmanNode newNode){
      rightChild = newNode;
    }
    public void setCharacters(char[] chars){
      characters = chars;
    }
    public void setFrequency(int freq){
      frequency = freq;
    }
    //Method to tell whether or not the node is a leaf
    public boolean isLeaf(){
      if(leftChild == null && rightChild == null){
        return true;
      }
      return false;
    }

    //CompareTo method for natural ordering Priority queue
    public int compareTo(HuffmanNode node){
      return this.frequency - node.frequency;
    }



    //Using this node as the root, find the encoding of a single character strng of 0's and 1's.
    //x = leftChild
    //get rid of accessors
    public String encode(char character){
      HuffmanNode x = this;
      HuffmanNode lc = leftChild;
      HuffmanNode rc = rightChild;
      String s = "";
      while(!x.isLeaf()){
        if(lc != null && lc.contains(character)){
          x = x.getLeftChild();
          lc = x.getLeftChild();
          rc = x.getRightChild();
          s += "0";
        }
        else if(rc != null && rc.contains(character)){
          x = x.getRightChild();
          lc = x.getLeftChild();
          rc = x.getRightChild();
          s+= "1";
        }
      }
      return s;
    }

    public boolean contains(char character){
      for(int i = 0; i < characters.length; i++){
        if(characters[i] == character)
          return true;
      }
      return false;
    }
    public String toString(){
      String returnString = "";
      for(int i = 0; i < characters.length; i++){
        returnString += characters[i];
      }
      returnString += " frequency: " + frequency;
      return returnString;
    }
}
