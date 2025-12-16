public class DynamicStack extends CustomStack{
    public DynamicStack(){
        super(); //calls the CustomStack() constructor
    }
    public DynamicStack(int size){
        super(size); //calls the CustomStack(int size) constructor

    }
    @Override
    public boolean push(int item){
        //The below statement will execute when the array is full
        if(this.isFull()){
            //double the array size
            int[] temp = new int[data.length * 2];
            //copy all the previous items into the new array
            for(int i=0; i<data.length; i++){
                temp[i] = data[i];
            }
            //Or we can use
            //System.arraycopy(data, 0, temp, 0, data.length);
            //instead of the above for loop
            data = temp;
        }
        //At this point we know that the array is not full
        //insert item
        return super.push(item);

    }
}
