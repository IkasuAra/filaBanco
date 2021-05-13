import java.util.Scanner;

public class Ferramenta {
    
    public static int testarInteiro(Scanner input) {
        boolean testeInteiro = true;
        String testeEscolha;
        int escolha = 0;
        do {
            testeEscolha = input.nextLine();
            try {
                escolha = Integer.parseInt(testeEscolha);
                testeInteiro = false;
            } catch (Exception e) {
                System.out.println("Você não digitou um número! Digite novamente.");
                testeInteiro = true;
            }
        } while (testeInteiro);
        return escolha;
    }
}
