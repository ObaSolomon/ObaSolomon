/*

represents Questions as nodes
*/
public class QuestionNode {
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