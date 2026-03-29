class ListNode{
	int key;
	int val;
	ListNode next;
	ListNode prev;
	ListNode(){}
	ListNode(int key, int val){ this.key = key; this.val = val; }
}

public class LRUCache {
	
	Map<Integer, ListNode> map;
	ListNode head;
	ListNode tail;
	int capacity;

	public LRUCache(int capacity) {
        	map = new HashMap<>();
		head = new ListNode();
		tail = new ListNode();
		head.next = tail;
		tail.prev = head;
		this.capacity = capacity;
    	}
    
    	public int get(int key) {
        	if(!map.containsKey(key)) return -1;
		ListNode node = map.get(key);
		moveToFront(node);
		return node.val;
    	}
    
    	public void put(int key, int value) {
        	ListNode node;
		if(map.containsKey(key)){
			node = map.get(key);
			node.val = value;
			moveToFront(node);
		}	
		else {
			node = new ListNode(key, value);
			addToFront(node);
		}

		map.put(key, node);
		if(map.size() > capacity){
			node = deleteLast();
			map.remove(node.key);
		}
    	}

	private void moveToFront(ListNode node){
		deleteNode(node);
		addToFront(node);
	}
	
	private void deleteNode(ListNode node){
		ListNode prev = node.prev;
		ListNode next = node.next;
		prev.next = next;
		next.prev = prev;
		node.next = null;
		node.prev = null;
	}
	
	private void addToFront(ListNode node){
		ListNode next = head.next;
		head.next = node;
		node.next = next;
		node.prev = head;
		next.prev = node;
	} 
	
	private ListNode deleteLast(){
		ListNode node = tail.prev;
		deleteNode(node);
		return node;
	}
}
