import java.util.*;
public class AssassinManager {
   private AssassinNode theGraveyard;
   private AssassinNode theStalked;
   
   public AssassinManager(List<String> names) {
      theStalked = new AssassinNode(names.get(0), new AssassinNode(names.get(1)));
      AssassinNode ringPointer = theStalked;
      for(int i = 1; i<=names.size()-2; i++){
         ringPointer.next = new AssassinNode(names.get(i), new AssassinNode(names.get(i+1)));
         ringPointer=ringPointer.next;
      }
      
      //theStalked(names(names.length()-1),theStalked);
   }
   
   public void printKillRing() {
      AssassinNode ringPointer = theStalked;
      if(theStalked.next == null) {
         
         System.out.println("     " + theStalked.name + " is stalking " + theStalked.name);
      } else {
         while(ringPointer.next != null) {
            System.out.println("    " +  ringPointer.name + " is stalking " + ringPointer.next.name);
            
            
            ringPointer=ringPointer.next;
         }
         System.out.println("    " +  ringPointer.name + " is stalking " + theStalked.name);
         
      }
   }
   
   
   public void printGraveyard() {
      AssassinNode gravePrinter = theGraveyard;
      while(gravePrinter != null) {
         System.out.println("    " +  gravePrinter.name + " was killed by " + gravePrinter.killer);
         gravePrinter = gravePrinter.next;
      }
      
   }
   
   public boolean killRingContains(String name) {
   
   return nameCheck(theStalked,name);   
   }
   
   public boolean graveyardContains(String name) {
      if(theGraveyard == null) { return false;}
      return nameCheck(theGraveyard,name);
   }
   
   public boolean gameOver() {
      return theStalked.next == null;
   }
   
   public String winner() {
      if(gameOver()) {
         return theStalked.name;
      }
      return null;
   }
   
   public void kill(String name) {
      AssassinNode theKiller = theOneBefore(theStalked,name);
      AssassinNode graveFinder = theGraveyard;

      
      AssassinNode theKilled = theKiller.next;
      if(theStalked.name.equalsIgnoreCase(name)) {
      AssassinNode theDead = theStalked; 
                  System.out.println("front");
         if(theGraveyard == null) {
            theGraveyard = theStalked;
            theStalked = theStalked.next;
            theGraveyard.next = null;
         }else{
         theStalked=theStalked.next;
          theDead.next= theGraveyard;
         }

         theGraveyard.killer = theKiller.name;

         //run after for loop w indexOf check to see if the Killer.next == null
      }else if(theKilled.next == null){
         System.out.println("end");
         if(theGraveyard == null) {
            
            theGraveyard = theKilled;
            theGraveyard.killer = theStalked.name;
            
         }else {
            
            theKilled.next =theGraveyard;
            theGraveyard =theKilled;
            theGraveyard.killer = theStalked.name;
         }
         theKiller.next = null;
         
      }else {
           System.out.println("middle");
         if(theGraveyard == null){
            theGraveyard= theKilled;
            theGraveyard.killer = theKiller.name;
            theKiller.next=theKiller.next.next;
            theGraveyard.next = null;
         }else {
            
            theKilled.next = theGraveyard;
            theGraveyard.killer = theKiller.name;
            theKiller.next=theKiller.next.next;
            theGraveyard=theKilled;
         }
         
      }
      
   }
   
   
   private AssassinNode theOneBefore(AssassinNode field,String name) {
      AssassinNode nameFinder= field;
      while(nameFinder.next != null) {
         if (nameFinder.next.name.equalsIgnoreCase(name)) {
            return nameFinder;
         }
         nameFinder = nameFinder.next;
      }
      
      return nameFinder;
   }
   
   private boolean nameCheck(AssassinNode field, String name) {
     AssassinNode ringPointer = field;
     if (ringPointer.name.equalsIgnoreCase(name)) {
     return true;
     }
     while(ringPointer.next != null) {
         if (ringPointer.next.name.equalsIgnoreCase(name) || ringPointer.name.equalsIgnoreCase(name)) {
            return true;
         }   
           ringPointer = ringPointer.next;

      }
      return false;
}
}