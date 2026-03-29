//import java.util.*;

public class MinStack{
	
	Deque<Pair> stack;

	public MinStack(){
		stack = new LinkedList<>();
	}

	public void push(int value){
		Pair pair;
		if(stack.isEmpty()){
			pair = new Pair(value, value);
		} else {
			pair = new Pair(value, Math.min(value, this.getMin()));
		}
		stack.push(pair);
	}

	public void pop(){
		stack.pop();
	}

	public int top(){
		return stack.peek().getValue();
	}

	public int getMin(){
		return stack.peek().getMin();
	}
}

class Pair{
	int value;
	int min;
	
	Pair(int value, int min){
		this.value = value;
		this.min = min;
	}
	
	public int getValue(){ return this.value; }
	
	public int getMin(){ return this.min; }
}