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
        if(numElderlyClients() > 0 && elderlyCounter < 2 || normal.isEmpty()) {            
            nextClient = true;
            return;
        }
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
        elderlyCounter = 0;
        return normal.dequeue();
    }

    public String showQueues() {
        String output = "\n*Filas*\nidoso:";
        output += elderly.show();
        output += "normal:" + normal.show();
        return output;
    }
}
