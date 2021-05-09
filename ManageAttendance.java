public class ManageAttendance {
    private String[] queue;
    private int size;
    private int addElderly;
    private Client cli;

    public ManageAttendance(){
        cli = new Client("Lucas", 25);
    }

    public ManageAttendance(int size){
        this.queue = new String[size];
        this.addElderly = 0;
        this.size = 0;
    }

    
    public String[] getQueue() {
        return queue;
    }

    public int getSize(){
        return size;
    }

    public Client getCli() {
        return cli;
    }

    public int getAddelderly(){
        return addElderly;
    }

    public void setSize(int size) {
        this.size = size;
    }    

    public void setCli(Client cli) {
        this.cli = cli;
    }

    public void setAddelderly(int addElderly){
        this.addElderly++;
    }


    public boolean isEmpty(){
        return (size == 0);
    }
    
    public int numClients(){
        return size;
    }

    public int numElderlyClients(){
        return addElderly;
    }

    public void addClient(Client cli){
        queue[size] = cli;
        size++;
    }

    public Client showNext(){
        if(!isEmpty()){
            return queue[0];
        }
        return "vazia";
    }

    public Client getNext(){
        if(isEmpty()){
            return "vazia";
        }
        String aux = queue[0];
        for (int i = 0; i < (size - 1); i++){
            queue[i] = queue[i+1];
        }
        size--;
        return aux;
    }

    public boolean isFull(){
        if(size == queue.length){
            System.out.println("A fila está cheia, novo cliente não foi inserido.");
            return true;
        }
        return false;
    }

    public String showQueues(){
        String element = "";
        for (int i = 0; i < size; i++){
            if(queue[i] == " "){
                queue[i] = "vazia";
            }
            element = element + queue[i] + "-";
        }
        return element;
    }
}