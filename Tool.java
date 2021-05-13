import java.util.Scanner;

public class Tool {
    
    public static int convertStringToInt(Scanner input) {
        boolean continueLoop = true;
        String optionAsString;
        int optionAsInt = 0;
        do {
            optionAsString = input.nextLine();
            try {
                optionAsInt = Integer.parseInt(optionAsString);
                continueLoop = false;
            } catch (Exception e) {
                System.out.println("Você não digitou um número! Digite novamente.");
                continueLoop = true;
            }
        } while (continueLoop);
        return optionAsInt;
    }
}
