// Noah Thompson
// 14 April 2026
// Homework8.java
// Checking words for correct position at the correct index

public class Homework8{
    public boolean check(char[] correctPositions, String word) {
        int index = 0;
        boolean checker = true;

        // iterate through correctPositons
        for (char i : correctPositions){
            // if position doesnt equal word at that index or correcPositions 
            // isnt a * return false
            if (!(word.charAt(index) == i || i == '*')){
                checker = false;
            }
            index += 1;
        }
        return checker;
    }

    public static void main(String[] args) {
            // testing sample outputs should be true
            char[] correctPositions = new char[]{ 'W', '*', 'R'};
            String word = "WoRdle";

            // have to create object of Homework8
            Homework8 func = new Homework8();
            boolean correct = func.check(correctPositions, word);
            System.out.println(correct);

            // second sample output should be false
            correctPositions = new char[]{ 'W', '*' };
            word = "wordle";
            correct = func.check(correctPositions, word);
            System.out.println(correct);

            // third sample output should be true
            correctPositions = new char[]{ 'S', '*', 'G', '*', 'R'}; 
            word = "SUGAR";
            correct = func.check(correctPositions, word);
            System.out.println(correct);

            // fourth sample output should be true
            correctPositions = new char[]{ }; 
            word = "";
            correct = func.check(correctPositions, word);
            System.out.println(correct);

            // fifth sample output should be true
            correctPositions = new char[]{ '*', '*', '*', '*', '*'}; 
            word = "PARADIGMS";  
            correct = func.check(correctPositions, word);
            System.out.println(correct);    
    }
}
