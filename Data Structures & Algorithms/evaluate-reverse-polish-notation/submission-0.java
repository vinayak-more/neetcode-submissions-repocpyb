class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
		int a, b;
		for(String token : tokens){
			switch(token){
				case "+" : stack.push(stack.pop() + stack.pop()); break;
				case "-" : stack.push( - stack.pop() + stack.pop()); break;
				case "*" : stack.push(stack.pop() * stack.pop()); break;
				case "/" : b = stack.pop(); a = stack.pop(); stack.push( a / b); break;
				default : stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();

    }
}
