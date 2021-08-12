import java.util.*;
public class PriorityQueue {

    ArrayList<Integer> data;
    public PriorityQueue(){
        data=new ArrayList<>();
    }

    public int size(){
        return data.size();
    }

    public boolean isEmpty(){
        return data.size()==0;
    }

    public int peek(){
        if(data.size()==0){
            return -1;
        }
        return data.get(0);
    }

    public void add(int val){
        data.add(val);
        //when we add a value, we make sure that is does not break the heap property
        upheapify(data.size()-1);
    }

    private void upheapify(int index){
        if(index<=0){
            return;
        }

        //we will check with the parent value, and if we found out that we have a higher priority than our parent, we will swap
        int pi=(index-1)/2;
        if(data.get(pi)>data.get(index)){
            swap(index,pi);
            upheapify(pi);
        }
    }

    private void swap(int i,int j){
        int temp=data.get(i);
        data.set(i,data.get(j));
        data.set(j,temp);
    }

    public int poll(){
        if(data.size()==0){
            return -1;
        }
        //we swapped last node since deletion of last node in arraylist will take o(1) time whereas if we delete the element
        // it will take o(n) to shift the indices
        swap(0,data.size()-1);
        int val=data.get(data.size()-1);
        data.remove(data.size()-1);
        downHeapify(0);
        return val;
    }

    private void downHeapify(int index){
        int mini=index;
        int leftIndex=2*index+1;
        int rightIndex=2*index+2;
        //check for left and right nodes and swap with the minimum one
        if(leftIndex<data.size() && data.get(leftIndex)<data.get(mini)){
            mini=leftIndex;
        }

        if(rightIndex<data.size() && data.get(rightIndex)<data.get(mini)){
            mini=rightIndex;
        }

        if(mini!=index) {
            //if this condition does not satisfy we will simply return since this can only be when there is a leaf node
            // or that the node fits our given condition
            swap(index, mini);
            //now fixing this fix for the child nodes
            downHeapify(mini);
        }

    }

}
