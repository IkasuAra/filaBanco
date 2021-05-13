import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        System.out.println("*****Banco Dinheiro na Mão*****");
        ManageAttendance manager = new ManageAttendance(2);
        Scanner input = new Scanner(System.in);
        boolean endOfProgram = true;
        int option = 0, age;
        Client newClient;
        String name;
        Client auxiliar;

        do {
            System.out.println("\nEscolha uma das opções abaixo: ");
            System.out.println("1 - Chegada do cliente à agência");
            System.out.println("2 - Verificar quem é o próximo a ser atendido");
            System.out.println("3 - Atender um cliente");
            System.out.println("4 - Exibir as filas (idoso e não idoso)");
            System.out.println("5 - Finalizar o programa (só poderá ser finalizado caso não tenha mais clientes aguardando)");
            System.out.print("Opção: ");
            
            option = Tool.testarInteiro(input);            
  
            switch (option) {
                case 1:
                    do{
                        System.out.print("Insira o nome: ");
                        name = input.nextLine();
                    }while(!Client.validationName(name));
                    do{
                        System.out.print("Insira a idade: ");
                        age = Tool.testarInteiro(input);
                    }while(!Client.validationAge(age));
                    newClient = new Client(name, age);                            
                    manager.addClient(newClient);
                    break;
                case 2:
                    System.out.println("\nPróximo cliente a ser atendido: ");
                    System.out.println("Nome: " + manager.showNext().getName() + "/Idade:" + manager.showNext().getAge());
                    break;
                case 3:
                    auxiliar = manager.getNext(); 
                    System.out.println("\nCliente atendido: ");
                    System.out.println("Nome: " + auxiliar.getName() + "/Idade:" + auxiliar.getAge());
                    break;
                case 4:
                    System.out.println(manager.showQueues());   
                    break;
                case 5:
                    endOfProgram = !(manager.numClients() == 0);
                    break;
                default:
                    System.out.println("Selecione uma opção válida!");
                    break;
            }

        } while (endOfProgram);
        input.close();
    }
}