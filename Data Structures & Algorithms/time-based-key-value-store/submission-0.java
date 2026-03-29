public class TimeMap{
	
	Map<String,List<Pair>> map;

    	public TimeMap() {
        	map = new HashMap<>();
    	}
    
    	public void set(String key, String value, int timestamp) {
        	map.putIfAbsent(key, new ArrayList<>());
		map.get(key).add(new Pair(value, timestamp));
    	}
    
    	public String get(String key, int timestamp) {
		if(!map.containsKey(key)) return "";
		List<Pair> pairs = map.get(key);
		Pair pair = binarySearch(pairs, timestamp);
		if(pair == null) return "";
		return pair.value;
    	}

	private Pair binarySearch(List<Pair> pairs, int target){
		int left = 0, right = pairs.size() - 1, mid;
		while(left <= right){
			mid = (left + right) / 2;
			if(pairs.get(mid).timestamp == target) return pairs.get(mid);
			if(pairs.get(mid).timestamp < target ) left = mid + 1;
			else right = mid - 1;
		}
		if(right < 0) return null;
		if(left >= pairs.size()) return pairs.get(pairs.size() - 1);
		return pairs.get(right);
	}
}
class Pair{
	String value;
	int timestamp;
	Pair(String value, int timestamp){
		this.value = value;
		this.timestamp = timestamp;
	}
}