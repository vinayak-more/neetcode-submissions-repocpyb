class Solution {
    public int[] topKFrequent(int[] nums, int k) {
Map<Integer, Item> map = new HashMap<>();
for(int num : nums){
	map.putIfAbsent(num, new Item(num, 0));
	map.get(num).freq += 1;
}
Collection<Item> items = map.values();
Queue<Item> queue = new PriorityQueue<>();
for(Item item : items){
	queue.offer(item);
	if(queue.size() > k){
		queue.poll();
}
}
int[] result = new int[k];
int counter = 0;
while(!queue.isEmpty()){
	result[counter++] = queue.poll().value;
}
return result;
    }
}
class Item implements Comparable<Item>{
	int freq;
	int value;
	Item(int value, int freq){
		this.value = value;
		this.freq = freq;
}


public int compareTo(Item other){
	return this.freq - other.freq;
}
}


