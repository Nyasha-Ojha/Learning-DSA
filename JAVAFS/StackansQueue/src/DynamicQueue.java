public class DynamicQueue extends CircularQueue {
    public DynamicQueue(){
        super(); //calls the CustomStack() constructor
    }
    public DynamicQueue(int size){
        super(size); //calls the CustomStack(int size) constructor

    }
    @Override
    public boolean insert(int item){
        if(this.isFull()){
            //double the array size
            int[] temp = new int[data.length * 2];
            //copy all the previous items into the new array
            for(int i=0; i<data.length; i++){
                temp[i] = data[front+i] % data.length;
            }
            //Or we can use
            //System.arraycopy(data, 0, temp, 0, data.length);
            //instead of the above for loop
            front = 0;
            end = data.length;
            data = temp;
        }
        return super.insert(item);
    }
}
