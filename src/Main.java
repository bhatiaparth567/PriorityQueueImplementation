public class Main {

    public static void main(String[] args) {
	// write your code here
        PriorityQueue heap=new PriorityQueue();
        for(int i=1;i<=10;i++){
            heap.add(i);
        }

        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
