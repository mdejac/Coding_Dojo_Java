import java.util.ArrayList;

public class TestPuzzleJava {
    public static void main (String[] args) {
        
        PuzzleJava puzzle = new PuzzleJava();

        System.out.println("\n----- Test Ten Rolls -----");
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        rolls = puzzle.getTenRolls();
        System.out.println(rolls);

        System.out.println("\n----- Test Random Letter -----");
        System.out.println(puzzle.getRandomLetter());

        System.out.println("\n----- Test Generate Password -----");
        System.out.println(puzzle.generatePassword());

        System.out.println("\n----- Test New Get Password Set -----");
        System.out.println(puzzle.getNewPasswordSet(4));

        System.out.println("\n----- Test Shuffle Array -----");
        ArrayList<Object> arr = new ArrayList<Object>();
        arr.add(1);
        arr.add("Hello");
        arr.add(3.2);
        arr.add(false);
        arr.add("Something");
        arr.add(44);
        arr.add('!');
        System.out.println("Pre-shuffle : " + arr);
        System.out.println("Post-shuffle : " + puzzle.shuffleArray(arr));
    }
}