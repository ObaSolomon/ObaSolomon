
//use BNF to generate sentences

import java.util.*;
public class GrammarSolver {
   private Map<String,List<String>> grammarMap;
   private String[] termDivider;
   private String[] phraseArray;
   
   
   /*
   expects non null or real list and expects
   unique terminals to be taken it
   throws Illegal Argument Exception if condition not met
   takes in a string
   
   splits the terminals from the nonterminals
   */
   public GrammarSolver(List<String> grammar) {
      if(grammar.isEmpty()) {
         throw new IllegalArgumentException();
      }
      grammarMap = new TreeMap<String, List<String>>();
      List<String> listOfTerminals = new ArrayList<String>();
      termDivider = new String[]{"::=","[|]","[ \t]+"};
      
      for(String checkEntries:grammar) {
         containsKey(checkEntries.split(termDivider[0]));
      }
      
      for(String entries:grammar) {
         String[] stringParter = entries.split(termDivider[0]);
         String theTerminal = stringParter[1];
         String[] theTerminals =  theTerminal.trim().split(termDivider[1]);
         for(String terminals : theTerminals) {
            listOfTerminals.add(terminals.trim());
         }
         grammarMap.put(stringParter[0], listOfTerminals);
      }
   }
   
   /*
   expects non null and real symbol throws IllegalArgumentException
   if condition not met
   returns true if String exists, false if not
   */
   public boolean grammarContains(String symbol) {
      symbolExists(symbol);
      return grammarMap.containsKey(symbol);
   }
   
   /*
   returns non terminals list as a String
   */
   public String getSymbols() {
      String theSymbol = "[";
      
      for (String s : grammarMap.keySet()) {
         theSymbol += s + ",";
      }
      return theSymbol.substring(0,theSymbol.length()-1) + "]";
   }
   
   /*
   expects nonterminal symbol to exist
   expects times to be more than 0
   throws IllegalArgumentException if condition not met
   randomly generates sentence based on BNF rules
   returns sentence as String[]
   
   */
   public String[] generate(String symbol,int times) {
      if (times < 0 || !grammarContains(symbol)) {
         throw new IllegalArgumentException();
      }
      phraseArray = new String[times];
      for(int i = 0; i<times; i++) {
         phraseArray[i] = giveSentence(symbol);
      }
      return phraseArray;
   }
   
   /*
   takes in symbol as a String and choose the path of BNF
   to pick word group
   returns word group as String
   */
   private String giveSentence(String symbol) {
      String genRecurse = "";
      if(!grammarContains(symbol)) {
         return symbol;
      }
      Random rand = new Random();
      
      List<String> termList = grammarMap.get(symbol);
      int randChoice = rand.nextInt(termList.size());
      String randomChoice = termList.get(randChoice);
      
      String[] ruleList = randomChoice.split(termDivider[2]);
      
      for(String terminal : ruleList) {
         genRecurse += giveSentence(terminal);
         
      }
      return genRecurse.trim();
   }
   
   /*
   checks to see if grammar doesn't already contain
   the same terminal
   throws IllegalArgumentException if conditions not met
   */
   private void containsKey(String[] rePeat) {
      if(grammarMap.containsKey(rePeat[0])) {
         throw new IllegalArgumentException();
      }
   }
   
   /*
   checks to see if symbol exists and if it doesn't
   throws IllegalArgumentException
   */
   private void symbolExists(String symbol) {
      if(symbol == null || symbol.length() == 0) {
         throw new IllegalArgumentException();
      }
   }
}