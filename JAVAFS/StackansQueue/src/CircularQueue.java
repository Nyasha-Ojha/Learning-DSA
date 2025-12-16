public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int front = 0;
    protected int end = 0;
    private int size = 0;
    public CircularQueue(int size){
        this.data = new int[size];
    }
    //If size is not provided
    public CircularQueue(){
        this(DEFAULT_SIZE);
    }
    public boolean isFull(){
        return size == data.length; //ptr is at the last index
    }
    public boolean isEmpty(){
        return size == 0; //ptr is at the last index
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty!");
        }
        int removed = data[front++]; //since, in queue the first element gets removed
        front = front % data.length;
        size--;
        return removed;
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty!");
        }
        return data[front];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Empty queue!");
            return;
        }
        int i = front;
        do{
            System.out.print(data[i] + " --> ");
            i++;
            i %= data.length;
        }while(i != end);
            System.out.println("END");
    }
    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(5);
        queue.insert(23);
        queue.insert(31);
        queue.insert(98);
        queue.insert(76);
        queue.insert(13);


        queue.display();





    }
}
