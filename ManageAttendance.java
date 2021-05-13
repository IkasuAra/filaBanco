public class ManageAttendance {
    private Queue elderly;
    private Queue normal;
    private int elderlyCounter;
    private boolean nextClient;
    private Client inexistent;

    public ManageAttendance(int size) {
        this.elderly = new Queue(size);
        this.normal = new Queue(size);
        this.elderlyCounter = 0;
        this.inexistent = new Client("Não há", 0);
    }

    
    public boolean isEmpty() {
        return (elderly.isEmpty() && normal.isEmpty());
    }

    public int numClients() {
        return (elderly.size() + normal.size());
    }

    public int numElderlyClients() {
        return elderly.size();
    }

    public void addClient(Client cli) {
        if(cli.isElderly() && !elderly.isFull()) {
            elderly.enqueue(cli);
            return;
        }
        else if(!cli.isElderly() && !normal.isFull()) {
            normal.enqueue(cli);
            return;
        }
        System.out.println("Fila de atendimento cheia. Volte em outro horário");        
    }

    public void decideNextClient() {
        if(numElderlyClients() > 0 && elderlyCounter < 2) {            
            nextClient = true;
            return;
        }
        elderlyCounter = 0;
        nextClient = false;
    }

    public Client showNext() {
        decideNextClient();
        if(elderly.isEmpty() && normal.isEmpty()) {
            return inexistent;
        }
        if(nextClient) {
            return elderly.peek();
        }
        return normal.peek();
    }

    public Client getNext() {
        decideNextClient();
        if(elderly.isEmpty() && normal.isEmpty()) {
            return inexistent;
        }
        if(nextClient) {
            elderlyCounter++;
            return elderly.dequeue();
        }
        return normal.dequeue();
    }

    public String showQueues() {
        String saida = "\n*Filas*\nidoso:";
        saida += elderly.show();
        saida += "normal:" + normal.show();
        return saida;
    }
}
