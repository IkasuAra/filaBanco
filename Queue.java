public class Queue {
    private Client[] array;
    private int indexEnd;

    public Queue(int size) {
        array = new Client[size];
        indexEnd = 0;
    }

    public boolean isEmpty() {
        return indexEnd == 0;
    }

    public boolean isFull() {
        return indexEnd == array.length;
    }

    public void enqueue(Client value) {
        if(isFull()) {
            return; 
        }
        array[indexEnd] = value;
        indexEnd++; 
    }
    
    public Client dequeue() {
        if(isEmpty()) {
            return null;
        }
        Client aux = array[0];
        for (int i = 0; i < indexEnd - 1; i++) {
            array[i] = array[i+1];
        }
        indexEnd--;
        return aux;
    }

    public Client peek() {
        if(!isEmpty()) {
            return array[0];
        }
        return null;
    }

    public int size() {
        return indexEnd;
    }

    public String show() {
        String elem = "";
        if(isEmpty()){
            elem = "vazia;";
        }
        for (int i = 0; i < indexEnd; i++) {
            elem = elem + array[i].getName() + ":" + array[i].getAge();
            if(i == indexEnd - 1) {
                elem += ";";
            }
            else {
                elem += "-";
            }
        }
        return elem;
    }
}
