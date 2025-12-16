import java.util.Stack;

public class QueueWith2Stacks {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueWith2Stacks(){
        first = new Stack<>();
        second = new Stack<>();
    }
    //Insertion efficient
//    public void add(int item){
//        first.push(item);
//    }
//    public int remove() throws Exception{
//        while(!first.isEmpty()){
//            second.push(first.pop());
//        }
//        int removed = second.pop();
//        while(!second.isEmpty()){
//            first.push(second.pop());
//        }
//        return removed;
//    }
//    public int peek() throws Exception{
//        while(!first.isEmpty()){
//            second.push(first.pop());
//        }
//        int topItem = second.peek();
//        while(!second.isEmpty()){
//            first.push(second.pop());
//        }
//        return topItem;
//    }
    //Remove efficient
    public int remove(){
        return first.pop();
    }
    public void add(int item) throws Exception {
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        first.push(item);
        while(!second.isEmpty()){
            first.push(second.pop());
        }
    }
    public int peek(){
        return first.peek();
    }

    public boolean isEmpty(){
        return first.isEmpty();
    }

    public static void main(String[] args) throws Exception{
        QueueWith2Stacks queue = new QueueWith2Stacks();
        queue.add(5);
        queue.add(7);
        queue.add(9);

        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());

    }
}
