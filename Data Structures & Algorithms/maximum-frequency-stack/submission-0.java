class FreqStack {
    TreeMap<Integer, Deque<Integer>> treeMap = new TreeMap<>((a,b) -> b - a);
    Map<Integer, Integer> freqMap = new HashMap<>();
    public FreqStack() {
        
    }
    
    public void push(int val) {
        int oldFreq = freqMap.getOrDefault(val, 0);
        freqMap.put(val, oldFreq + 1);
        treeMap.compute(oldFreq + 1, (key, stack)->{
            if(stack == null){
                stack = new LinkedList<>();
            }
            stack.push(val);
            return stack;
        });
    }
    
    public int pop() {
        int maxFreq = treeMap.firstKey();
        int result = treeMap.get(maxFreq).pop();
        if(treeMap.get(maxFreq).isEmpty()){
            treeMap.remove(maxFreq);
        }
        freqMap.compute(result, (key, count) -> count == 1 ? null : count - 1);
        return result;
    }
}



/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */