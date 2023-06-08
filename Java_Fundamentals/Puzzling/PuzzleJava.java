import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class PuzzleJava {
    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for (int i=0; i < 10; i++){
            rolls.add(randMachine.nextInt(21));
        }
        return rolls;
    }

    public char getRandomLetter() {
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        return alphabet[randMachine.nextInt(alphabet.length)];
    }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int numPasswords) {
        ArrayList<String> passwordList = new ArrayList<String>();
        for (int i = 0; i < numPasswords; i++) {
            passwordList.add(generatePassword());
        }
        return passwordList;
    }

    public ArrayList<Object> shuffleArray(ArrayList<Object> arr) {
        Collections.shuffle(arr);
        return arr;
    }
}