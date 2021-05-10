import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*****Banco Dinheiro na Mão*****");
        ManageAttendance manager = new ManageAttendance(2);
        boolean endOfProgram = true;
        Client newClient;
        Scanner input = new Scanner(System.in);
        String name;
        int age, numNewClients;
        do {
            System.out.println("\n\nQuantos clientes chegaram? ");
            numNewClients = input.nextInt();
            for(int i = 0; i < numNewClients; i++) {
                System.out.println("Insira seu nome: ");
                name = input.next();
                System.out.println("Insira sua idade: ");
                age = input.nextInt();
                
                newClient = new Client(name, age);
                manager.addClient(newClient);
            }

            System.out.println(manager.showQueues());
            manager.decideNextClient();
            System.out.println("\nPróximo cliente a ser atendido: ");
            System.out.println("Nome: " + manager.showNext().getName() + "/Idade:" + manager.showNext().getAge());
            manager.getNext();  

            System.out.println(manager.showQueues());

            if(manager.numClients() == 0) {
                endOfProgram = false;
            }

        } while (endOfProgram);

        input.close();
    }
}
