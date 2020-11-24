/**
* HashMapExercise
* @author Monica Chan
* @version 1.0
*/


import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;


public class HashMapExercise{
  public static void main(String args[]){
    ArrayList<Integer> asciiValues = new ArrayList<Integer>();
    String file = "RandomText.txt";
    readFile(file, asciiValues);

    if(asciiValues.size() == 0){
      System.out.println("There is nothing in your file!");
    }

    else{
      ArrayList<String> values = convertToString(asciiValues);
      HashMap<String, Integer> occurrence = convertHashMap(values);
      System.out.println(occurrence);
    }
  }

  /**
  * This function takes an ascii integer array list and converts it into a string array list
  of words that correspond to the ascii characters. Uses the fact that a space
  has an ascii value of 32 to differentiate between different words.
  * @param ascii the integer ascii array ArrayList
  * @return string array list with the words of the ascii list.
  */
  public static ArrayList<String> convertToString(ArrayList<Integer> ascii){
    ArrayList<String> asciiString = new ArrayList<String>();
    int asciiLength = ascii.size();
    String addWord = "";

    for(int i = 0; i < asciiLength; i ++){
      int curr = ascii.get(i);
      if(curr == 32){
        asciiString.add(addWord);
        addWord = "";
      }
      else{
        addWord += Character.toString((char)curr);
      }
    }
    asciiString.add(addWord);

    return asciiString;
  }


  /**
  * This function converts a string array list of words into a hash map and their frequency.
  * @param values the string array list.
  * @return a hash map with the key (the word) and a value (the frequency they appear in)
  */
  public static HashMap<String, Integer> convertHashMap(ArrayList<String> values){
    int wordLength = values.size();
    HashMap<String, Integer> words = new HashMap<>(wordLength);
    for(int j = 0; j < wordLength; j++){
      String curString = values.get(j);
      if(words.get(curString) == null){
        words.put(curString, 1);
      }
      else{
        int val = words.get(curString);
        words.put(curString, val+1);
      }
    }
    return words;
  }


  /**
  * This function reads the .txt file that we are trying to read from. Converts
  the characters it sees with Scanner into ascii values and adds each ascii value
  into an integer array list.
  * @param filename name of the file we are trying to read from.
  * @param list the array list we are add ascii values into.
  */
  public static void readFile(String filename, ArrayList<Integer> list)
  {
    list.clear();
    File file = new File(filename);
    Scanner input = null;
    try
    {
      input = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println(" Cannot open " + filename );
      System.exit(1);
    }
    while(input.hasNextLine())
    {
      String s = input.nextLine();
      for(int i = 0; i < s.length(); i++)
        list.add((int)s.charAt(i));
      list.add(32);
    }
  }

}
