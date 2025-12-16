public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = 0;
    public CustomQueue(int size){
        this.data = new int[size];
    }
    //If size is not provided
    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public boolean isFull(){
        return end == data.length; //ptr is at the last index
    }
    public boolean isEmpty(){
        return end == 0; //ptr is at the last index
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
//        data[end] = item;
//        end++;
        data[end++] = item;
        return true;
    }
    //while removing, we remove the first element and then
    // shift every other element in the array to the left side by 1.
    //Therefore remove() --> O(n)
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty!");
        }
        int removed = data[0]; //since, in queue the first element gets removed
        //shift the elements to the left
        for(int i=1; i<end; i++){
            data[i-1] = data[i];
        }
        end--; //since one element has been removed
        return removed;
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty!");
        }
        return data[0];
    }
    public void display(){
        for (int i=0; i<end; i++){
            System.out.print(data[i] + " <-- ");
        }
        System.out.println(" <-- END");
    }

    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);
        queue.insert(23);
        queue.insert(31);
        queue.insert(98);
        queue.insert(76);
        queue.insert(13);
        queue.insert(12);

        queue.display();





    }
}
