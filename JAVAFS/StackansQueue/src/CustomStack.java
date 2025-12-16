public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    //If size is provided by the user
    public CustomStack(int size){
        this.data = new int[size];
    }
    //If size is not provided
    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    int ptr = -1;
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is FULL!");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Can't pop from an empty Stack!");
        }
//        int removed = data[ptr];
//        ptr--;
//        return removed;
        return data[ptr--];
    }

    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Can't peek from an empty Stack!");
        }
        return data[ptr];
    }
    public boolean isFull(){
        return ptr == data.length - 1; //ptr is at the last index
    }
    public boolean isEmpty(){
        return ptr == -1; //ptr is at the last index
    }

    public static void main(String[] args) throws Exception {
        CustomStack stack = new DynamicStack(5);
        stack.push(32);
        stack.push(21);
        stack.push(14);
        stack.push(9);
        stack.push(98);
        stack.push(56);


        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }
}
