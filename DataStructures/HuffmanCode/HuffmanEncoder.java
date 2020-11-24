import java.io.*;
import java.util.PriorityQueue;
public class HuffmanEncoder {

    //Stored Huffman Tree
    HuffmanNode tree;
    String filename;


    //Premade Constructor
    public HuffmanEncoder(String string){
        filename = string;
        this.tree = buildHuffmanTree(readFile(filename));
    }

    public HuffmanNode getLeftChild(){
      return tree.getLeftChild();
    }

    public HuffmanNode getRightChild(){
      return tree.getRightChild();
    }
    //Build Huffman Tree
    /**
    * Start by adding each character as a node into the tree (obviously ordered already)
    pop the bottom two then make a new node as the combo.
    */
    @SuppressWarnings("unchecked")
    public HuffmanNode buildHuffmanTree(String string){
      string = string.toLowerCase();
      PriorityQueue pQueue = baseBuilder(string);
      while(pQueue.size() > 1){
        HuffmanNode last = (HuffmanNode) pQueue.poll();
        HuffmanNode secondLast = (HuffmanNode) pQueue.poll();
        char[] characters = merge(last.getCharacters(), secondLast.getCharacters());
        int frequency = last.getFrequency() + secondLast.getFrequency();
        HuffmanNode newNode = new HuffmanNode(characters, frequency, last, secondLast);
        pQueue.add(newNode);
      }
      return (HuffmanNode) pQueue.poll();
    }

    public char[] merge(char[] a, char[] b){
      char[] c = new char[a.length+b.length];
      for(int i = 0; i < a.length; i++){
        c[i] = a[i];
      }
      for(int j = 0; j < b.length; j++){
        c[j+a.length] = b[j];
      }
      return c;
    }
    public PriorityQueue<HuffmanNode> baseBuilder(String string){
      PriorityQueue<HuffmanNode> pQueue = new PriorityQueue<HuffmanNode>();
      int arrayLength = countUniqueChars(string);
      char[] characters = new char[arrayLength];
      int[] frequency = new int[arrayLength];
      int pointer = 0;
      for(int i = 0; i < string.length(); i++){
        char x = string.charAt(i);
        int index = find(characters,x);
        if(index != -1){
          frequency[index]++;
        }
        else{
          characters[pointer] = x;
          frequency[pointer]++;
          pointer++;
        }
      }

      for(int j = 0; j < characters.length; j++){
        char[] node = new char[1];
        node[0] = characters[j];
        int f = frequency[j];
        HuffmanNode x = new HuffmanNode(node, f, null, null);
        pQueue.add(x);
      }
      System.out.println(pQueue);
      return pQueue;
    }

    public String charactersPrint(char[] characters){
      String returnString = "";
      for(int i = 0; i < characters.length; i++){
        returnString += characters[i] + " ";
      }
      return returnString;
    }
    public int countUniqueChars(String s){
      int count = s.length();
      char characters[] = s.toCharArray();
      for(int i = 0; i < s.length(); i++){
        if(i != s.indexOf(characters[i]))
          count--;
      }
      return count;
    }
    public int find(char[] characters, char x){
      for(int i = 0; i < characters.length; i++){
        if(x == characters[i])
          return i;
      }
      return -1;
    }

    //Encode
    public void encode(){

      String s = readFile(filename);
      writeTreeToFile();
      String encode = "";
      for(int i = 0; i < s.length(); i++){
        encode += tree.encode(s.charAt(i));
      }
      writeToFile(encode, "StringEncoded_encoded");
    }

    //Decode
    public String decode(){
      readTreeFromFile(filename);
      HuffmanNode pointer = tree;
      String s = readFile(filename);
      String returnString = "";
      String[] characters = new String[s.length()];
      for(int i = 0; i< s.length(); i++){
        if(pointer.isLeaf()){
          returnString += pointer.getCharacters()[0];
          pointer = tree;
        }
        if(s.charAt(i) == '0'){
          pointer = pointer.getLeftChild();
        }
        else if(s.charAt(i) == '1'){
          pointer = pointer.getRightChild();
        }
      }
      return returnString;

    }

    //Name of the folder containing these files
//Leave empty if not working in an IDE
private final String DIR = "";

/**
* A pre-written method for writing the tree contained in the encoder to a file
*/
private void writeTreeToFile(){

   //Initializing an empty string
   String toWrite = "";

   //Writes the characters and their Hufffman encoding to a file, separated by the character '|'
   for(char c: tree.getCharacters()){
       toWrite += Character.toString(c);
       toWrite += "|";
       toWrite += tree.encode(c);
       toWrite += "|";
   }
   writeToFile(toWrite, this.filename + "_tree");
}

/**
* A pre-written method for reading a tree from a file
*/
public void readTreeFromFile(){

   //Reading in the exported tree
   String toParse = readFile(filename + "_tree");

   //Initialize variables for the construction of the tree

   //Create a root node and a reference to the current node in the loop
   HuffmanNode root = new HuffmanNode(toParse.charAt(0), 1);
   HuffmanNode current = root;

   //Empty character array to initialize a blank HuffmanNode
   char[] empty = {};

   //Char that tracks the character currently being placed into the tree
   char currentChar = toParse.charAt(0);

   //Boolean that tracks whether a char or address is being read
   boolean encoding = false;

   //Loop that reconstructs the tree
   //The string contains each character followed by its huffman encoding

   for(char c: toParse.substring(1).toCharArray()){

       //First if statements determine if a breaker character has been read (in this case it's a bar)

       if(c == '|'){
           encoding = !encoding;
       }

       //If it isn't a break, it is either a character or an encoding

       else {
           if (encoding) {

               //In the case where an encoding is being parsed
               //Traces down the tree, setting the current node to the left or right child for 0 and 1 respectively
               //Creates a new empty HuffmanNode if appropriate

               if (c == '0') {
                   if (current.getLeftChild() == null) {
                       current.setLeftChild(new HuffmanNode(empty, 0, null, null));
                       current = current.getLeftChild();
                   } else {
                       current = current.getLeftChild();
                   }
               } else if (c == '1') {
                   if (current.getRightChild() == null) {
                       current.setRightChild(new HuffmanNode(empty, 0, null, null));
                       current = current.getRightChild();
                   } else {
                       current = current.getRightChild();
                   }
               }
           }

           //In the case where a new character is being parsed
           //Returns to the root and sets the current character

           else {
               currentChar = c;
               current = root;
           }

           //Appends the current character to the current node

           current.setCharacters(append(current.getCharacters(), currentChar));
           current.setFrequency(current.getFrequency() + 1);
       }

   }
   this.tree = root;
}

//Helper array append method
public char[] append(char[] arr, char c){
   char[] ret = new char[arr.length + 1];
   for(int i = 0; i < arr.length; i++){
       ret[i] = arr[i];
   }
   ret[arr.length] = c;
   return ret;
}

/**
* A pre-written method for writing to a file
* @param string the String to be written to the file
* @param filename the name of the file being written
*/
//Premade write method
public void writeToFile(String string, String filename){
   File file = new File((DIR + "io/" + filename + ".txt"));
   try {
       BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
       writer.write(string);
       writer.close();
   }
   catch(IOException e){
       System.err.println("Something has gone terribly wrong");
       System.exit(1);
   }
}

/**
* A pre-written method for reading from a file
* @param filename the name of the file to be read
*/
public String readFile(String filename){
   String string = "";
   File file = new File((DIR + "io/" + filename + ".txt"));
   try {
       BufferedReader br = new BufferedReader(new FileReader(file));

       String line;
       while ((line = br.readLine()) != null)
           string += line;
       return string;
   }
   catch(IOException e){
       System.err.println("File not found, exiting now");
       System.exit(1);
   }
   return string;
}

}
