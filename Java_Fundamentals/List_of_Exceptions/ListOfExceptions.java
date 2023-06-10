import java.util.ArrayList;

public class ListOfExceptions {
    public static void main (String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        Integer castedValue;

        for (int i = 0; i < myList.size(); i++) {
            try {
                castedValue = (Integer) myList.get(i);
            } catch (ClassCastException e) {
                try {
                    castedValue = Integer.valueOf((String) myList.get(i));
                } catch (NumberFormatException e2) {
                    System.out.println("There was an error!");
                    System.out.printf("Index : %d, Value : %s\n\n", i, myList.get(i));
                    continue;
                }
            }
            System.out.printf("Index %d has been casted to %d\n\n", i, castedValue);
        }
    }
}