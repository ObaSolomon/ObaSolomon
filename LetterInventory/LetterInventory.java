
// Stores the letters of a word and
// keeps track of them 

import java.util.*;

public class LetterInventory {
   private static final int ALPHA_COUNT = 26;
   private int[] storesLetters;
   private int size;
   
   /*
   takes in a string representing a word and 
   puts those letters into an inventory
   */
   public LetterInventory(String data) {
      storesLetters = new int[ALPHA_COUNT];
      data = data.toLowerCase();
      for(int i = 0; i < data.length(); i++) {
         if(realChar(data.charAt(i))) {
            storesLetters[data.charAt(i) - 'a']++;
            size++;
         }
      }
   }
   
   /*
   returns how many letters total are in the 
   inventory
   */   
   public int size() {
      return size;
   }
   
   /*
    returns true if the boolean is empty
    and returns false if not
   */
   public boolean isEmpty() {
      return (size == 0);
   }
    
    /*
    The preconditions are having a real letter of
    alphabet as the character.
    throws IllegalArgumentException if conditions aren't met
    
    takes a letter and returns how many types of this letters
    are in the inventory
   */
   public int get(char letter) {
      letter = Character.toLowerCase(letter);
      if(!realChar(letter)){
      throw new IllegalArgumentException();
      }
      return storesLetters[letter - 'a'];
   }
   
     /*
   The preconditions are having a real letter of
    alphabet as the character and having a value >0.
    throws IllegalArgumentException if conditions aren't met

   */
   public void set(char letter, int value) {
      letter = Character.toLowerCase(letter);
      if (!realChar(letter) || (value < 0)) {
         throw new IllegalArgumentException();
      }
      size = size - storesLetters[letter-'a'] + value; 
      storesLetters[letter-'a'] = value;
   }
     
     /*
   
   */
   public String toString() {
      String toString = "";
      for(int i = 0; i < ALPHA_COUNT; i++){
         for(int j = 0; j < storesLetters[i]; j++) {
            toString += (char) ('a' + i) + "";
         }
      }
      
      return "[" + toString + "]";
   }
   
      /*
   
   */
   public LetterInventory add(LetterInventory other) {
      LetterInventory addIt = new LetterInventory("");
      
      for (int i = 0; i < ALPHA_COUNT; i++) {
      addIt.set((char)('a' + i),(storesLetters[i] + other.get((char) ('a' + i))));
      }
      
      addIt.size = size() + other.size();
      return addIt;
   }
   
      /*
   
   */
      public LetterInventory subtract(LetterInventory other) {
      
      LetterInventory minusIt = new LetterInventory("");
      for ( int i = 0; i < ALPHA_COUNT; i++) {
      int subtract = storesLetters[i] - other.get((char) ('a' + i));
      
      if (!valueChecker(subtract)){
      return null; 
      }
      minusIt.set((char)('a' + i),subtract);
      }
      
      minusIt.size = size() - other.size();
      return minusIt;
   }
    
      /*
   
   */
   private boolean valueChecker(int data) {
   return (data >= 0);
   }
    
   /*
   
   */
   private boolean realChar(char letter) {
      return !((letter  > 'z')||(letter < 'a')) ;
   }
}