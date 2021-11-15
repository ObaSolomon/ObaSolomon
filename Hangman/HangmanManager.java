/*

Manages Hangman Game
*/
import java.util.*;
public class HangmanManager {
private int answerLength;
private int numGuesses;
private String pattern;
private Set<String> dictionary2; 
private Set<Character> pastGuess;
private Map<String,TreeSet<String>> maxPatt;

/*
expects guesses to be more than 0 and length to be 
greater than 1 
throws IllegalArgumentException if not
takes in a Collection representing a dictionary
takes in an int representing maximum guesses
takes in an int representing chosen hangman length
*/
public HangmanManager(Collection<String> dictionary, int length, int max) {
if(length < 1 || max <0) {
throw new IllegalArgumentException();
}
maxPatt = new TreeMap<String,TreeSet<String>>();
Iterator<String> getWords = dictionary.iterator();
pastGuess = new TreeSet<Character>();
dictionary2 = new TreeSet<String>();
answerLength = length;
numGuesses = max;
pattern = "-";
for(int i = 1; i < answerLength; i++) {
pattern += "-";
}

while(getWords.hasNext()) {
String word = getWords.next();
if(word.length() == answerLength) {
dictionary2.add(word);
} 
}
}
/*
returns as a Set list of words considered
as hangman answer
*/
public Set<String> words() {

return dictionary2;
}

/*
returns as int how many guesses player has left
*/
public int guessesLeft() {

return numGuesses;
}

/*
Expects non empty Set of words
throw new IllegalStateException
returns as a String the hangman pattern
*/
public String pattern() {
if(dictionary2.isEmpty()) {
throw new IllegalStateException();
}
return pattern;
}

/*
returns as a Set the letters character has guessed
*/
public Set<Character> guesses() {

return pastGuess;
}

/*
takes in a char representing a letter
returns as int number of letter in hangman "answer"
decides the set of words to be used for the next guesses
*/
public int record(char guess) {
errorChecker(guess);
int charFound = 0;
Map<String,Integer> patternNum= new TreeMap<String,Integer>();
for(String wordConsidered: dictionary2) {
for(int i = 0; i < answerLength;i++) {
if(guess == wordConsidered.charAt(i)) {
pattern += guess + "";
charFound++;
}else if (pastGuess.contains(wordConsidered.charAt(i))) {
pattern += wordConsidered.charAt(i);
}else {
pattern += "-";
}
}
makeMap(wordConsidered);
patternNum.put(pattern,charFound);
charFound = newWord(charFound);
}
String bigPatt = bigInMap();
goodGuess(patternNum,bigPatt);
dictionary2 = maxPatt.get(bigPatt);
pastGuess.add(guess);
charFound = (int)patternNum.get(bigPatt);
maxPatt.clear();

return charFound;
}

/*
takes in a character representing a letter
checks to see if Guesses are greater than 1 
and the letter hasn't been guessed before
throws IlegalArgument Exception if Set of words
is empty or Guesses aren't greater than 1 
throws IllegalStateException if letter has been
guess before
*/
private void errorChecker(char guess) {
if(numGuesses < 1 || dictionary2.isEmpty()) {
throw new IllegalArgumentException();
}
if(pastGuess.contains(guess)){
throw new IllegalStateException();
}

}

/*
takes in a Map representing how many guessed letters
were found in each pattern 
and a String representing the pattern
if the guessed letter count is 0
it takes a guess away 
*/
private void goodGuess(Map patternNum,String bigPatt) {
pattern = bigPatt;
if((int)patternNum.get(bigPatt) == 0) {
numGuesses--;
}
}

/*
takes in the guessed letter count 
returns 0
*/
private int newWord(int charFound) {
pattern = "";
return 0;
}

/*
returns as a String the pattern with the most words
*/
private String bigInMap() {
String bestPatt = "";
int currentLarge = 0;
for(String bestPattern: maxPatt.keySet()) {
int size = maxPatt.get(bestPattern).size();
if (size > currentLarge) {
currentLarge = size;
bestPatt = bestPattern;
}
}
System.out.println(bestPatt);
return bestPatt;
}

/*
takes in a word and if it matches a pattern it 
links them together
*/
private void makeMap(String matchPattern) {
if(maxPatt.containsKey(pattern)){
maxPatt.get(pattern).add(matchPattern);
} else{
maxPatt.put(pattern,new TreeSet<String>());
}

}

}