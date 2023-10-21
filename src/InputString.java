import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputString {
    public InputString() {
    }
    private static boolean checkSquareNumber(int n) {
        return Math.sqrt(n) * Math.sqrt(n) == n;
    }
    private static void getNumber(String inputString) {
        HashMap<String, ArrayList<Integer>> hmNumber = new HashMap<>();
        String number = inputString.replaceAll("\\D+", ",");
        if (number.charAt(0) == ',') {
            number = number.substring(1);
        }
        if (number.charAt(number.length() - 1) == ',') {
            number = number.substring(0, number.length() - 1);
        }
        String[] listNumber = number.split(",");
        int lenNumber = listNumber.length;

        ArrayList<Integer> liPerfectSquare = new ArrayList<>();
        ArrayList<Integer> liOdd = new ArrayList<>();
        ArrayList<Integer> liEven = new ArrayList<>();
        ArrayList<Integer> liAll = new ArrayList<>();
        for (int i = 0; i < lenNumber; i++) {
            int numberCheck = Integer.parseInt(listNumber[i]);
            if (numberCheck % 2 == 1) liOdd.add(numberCheck);
            if (numberCheck % 2 == 0) liEven.add(numberCheck);
            if (checkSquareNumber(numberCheck)) liPerfectSquare.add(numberCheck);
            liAll.add(numberCheck);
        }
        hmNumber.put("Perfect Square Numbers: ", liPerfectSquare);
        hmNumber.put("Odd Numbers: ", liOdd);
        hmNumber.put("Even Numbers: ", liEven);
        hmNumber.put("All Numbers: ", liAll);

        for (Map.Entry m : hmNumber.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
    private static void getCharacter(String inputString) {
        HashMap<String, String> hmString = new HashMap<>();
        String upcs = inputString.replaceAll("\\W| [0-9]|[a-z]" , "");
        String lwcs = inputString.replaceAll("\\W| [0-9]|[A-Z]" , "");
        String spec = inputString.replaceAll("\\w", "");
        String allCharacter = inputString.replaceAll("\\W", "");
        hmString.put("Uppercase: ", upcs);
        hmString.put("Lowercase: ", lwcs);
        hmString.put("Special: ", spec);
        hmString.put("All Character: ", allCharacter);
        for (Map.Entry m : hmString.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
    public String getInputString() {
        System.out.print("Input String: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void display() {
        System.out.println("===== Analysis String program ====");
        String inputString = getInputString();
        System.out.println("-----Result Analysis------");
        getNumber(inputString);
        getCharacter(inputString);
    }
}