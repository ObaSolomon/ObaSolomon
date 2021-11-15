/*

reads and makes tree from file
asks user to play 20 questions
then lets user put in results
to improve its guessing abilities
*/
import java.io.*;
import java.util.*;

public class QuestionsGame{
   private Scanner console;
   private QuestionNode mainRoot;
   /*
   initializes questions starts off representing the object computer
   */
   public QuestionsGame(){
      console = new Scanner(System.in);
      mainRoot = new QuestionNode("computer");
      
      
   }
   /*
   takes in a text file represented as a Scanner
   to replace tree with user tree
   */
   public void read(Scanner input) {
      mainRoot = ;
   }
   
   /*
   takes in an empty file as a PrintStream
   puts tree into empty file
   */
   public void write(PrintStream out) {
      mainRoot = );
   }
   
   /*
   plays game of 20 questions
   */
   public void askQuestions(){
      QuestionNode questionPointer = mainRoot;

   }
   
   
   





    // post: asks the user a question, forcing an answer of "y" or "n";
    //       returns true if the answer was yes, returns false otherwise
    public boolean yesTo(String prompt) {
        System.out.print(prompt + " (y/n)? ");
        String response = console.nextLine().trim().toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            System.out.println("Please answer y or n.");
            System.out.print(prompt + " (y/n)? ");
            response = console.nextLine().trim().toLowerCase();
        }
        return response.equals("y");
    }
    private static class QuestionNode {
     public String data;
   public QuestionNode left;
   public QuestionNode right;
   
   
   /*
   construct leafNode
   takes in string as data
   */
   public QuestionNode(String data) {
      this(data, null, null);
   }
   
   /*
   Construct branchNode
   takes in  2 QuestionNode
   as connecting nodes and string as data
   */
   public QuestionNode(String data, QuestionNode left,
   QuestionNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
   
   /*
   changes a connecting node of branch
   takes in QuestionNode as what to change branch to
   takes in boolean position as what direction is changed
   if true changes right
   if false changes left
   */
   public void nodeControl(QuestionNode direction, boolean position) {
      if(position) {
         this.left = direction;
      }else {
         this.right = direction;
      }
   }
   /*
   returns the right Node as QuestionNode
   */
   public QuestionNode getRight() {
      return right;
   }
   
   /*
   return Left Node as QuestionNode
   */
   public QuestionNode getLeft() {
      return left;
      
   }
   /*
   sets data to be object data
   takes in String
   */
   public void setObject(String object) {
      this.data = object;
   }
   
   /*
   returns as boolean
   (true) if Node is a leafNode
   (false) if otherwise
   */
   public boolean isLeafNode() {
      
      return (this.left == null || this.right == null);
   }

    }
}