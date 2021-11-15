/*

reads and makes tree from file
asks user to play 20 questions
then lets user put in results
to improve its guessing abilities
*/
import java.io.*;
import java.util.*;

public class QuestionTree{
   private Scanner console;
   private QuestionNode mainRoot;
   private boolean notDone;
   /*
   initializes questions starts off representing the object computer
   */
   public QuestionTree(){
      console = new Scanner(System.in);
      mainRoot = new QuestionNode("computer");
      notDone = !notDone;
      
   }
   /*
   takes in a text file represented as a Scanner
   to replace tree with user tree
   */
   public void read(Scanner input) {
      mainRoot = createHolder(mainRoot, input);
   }
   
   /*
   takes in an empty file as a PrintStream
   puts tree into empty file
   */
   public void write(PrintStream out) {
      mainRoot = printTree(mainRoot, out);
   }
   
   /*
   plays game of 20 questions
   */
   public void askQuestion(){
      QuestionNode questionPointer = mainRoot;
      while(notDone){
         if(yesTo(questionPointer.data)){
            if(questionPointer.getLeft() != null){
               questionPointer = questionPointer.getLeft();
            }else{
               System.out.println("Great, I got it right");
               notDone = !notDone;
            }
         }else{
            if(questionPointer.getRight() != null){
               questionPointer = questionPointer.getRight();
            }else{
               System.out.println("What is the name of your object");
               String item = console.nextLine().trim().toLowerCase();
               System.out.println("Please give me a yes/no question which distinguishes your obejct from mine?");
               String question = console.nextLine().trim().toLowerCase();
               QuestionNode setQuestion = new QuestionNode(question);
               QuestionNode itemName = new QuestionNode(item);
               questionPointer.setRight(questionNode);
               if(yesTo("And what is the answer of your object?")){
                  questionPointer.getRight.nodeControl((itemName),false);
                  notDone = !notDone;
               }else{
                  questionPointer.getRight().nodeControl((itemName),true);
                  notDone = !notDone;
               }
            }
         }
      }
      if(yesTo("Do you want to do it again")){
         askQuestion();
      }
   }
   
   
   


/*
helper method
takes in empty file as printStream
and tree as QuestionNode
prints All questions and answer to files
returns tree as QuestionNode
*/
private QuestionNode printTree(QuestionNode node, PrintStream out) {
   if (node != null) {
      
      if (!node.isLeafNode()) {
         out.println("Q:");
         out.println(node.data);
      } else {
         out.println("A:");
         out.println(node.data);
      }
      
      node.nodeControl(printTree(node.getLeft(), out),false);
      node.nodeControl(printTree(node.getRight(), out),true);
   }
   return root;
}



/*
helper for read methods
takes in a node to see if it's null
takes in a user inputs represented as a Scanner
puts questions at the bottom of Tree
returns tree as QuestionNode
*/
private QuestionNode createHolder(QuestionNode node, Scanner input) {
   
   if (node == null) {
      node = new QuestionNode();
   }
   String userQ = input.nextLine().trim().toUpperCase();
   String qAnswer = input.nextLine();
   if (userQ.equals("A:")) {
      return new QuestionNode(qAnswer);
   }
   node.nodeControl(buildTree(node.getLeft(), input),false);
   node.setObject(qAnswer);
   node.nodeControl(buildTree(node.getRight(), input),true);
   return node;
}

// post: asks the user a question, forcing an answer of "y " or "n";

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
}