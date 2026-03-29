class Twitter {

    Map<Integer, Deque<int[]>> userToTweetMap;
    Map<Integer, Set<Integer>> userToFollowerMap;
    int counter;
    public Twitter() {
        userToTweetMap = new HashMap<>();
        userToFollowerMap = new HashMap<>();
        counter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userToTweetMap.putIfAbsent(userId, new LinkedList<>()); 
        userToTweetMap.get(userId).addLast(new int[]{counter, tweetId});
        if(userToTweetMap.get(userId).size() > 10){
            userToTweetMap.get(userId).removeFirst();
        }
        counter++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> users = userToFollowerMap.getOrDefault(userId, new HashSet<>());
        users.add(userId);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(Integer user : users){
            pq.addAll(userToTweetMap.getOrDefault(user, new LinkedList<>()));
            while(pq.size() > 10) pq.poll();
        }
        LinkedList<Integer> result = new LinkedList<>();
        while(!pq.isEmpty()) result.addFirst(pq.poll()[1]);
        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {
        userToFollowerMap.putIfAbsent(followerId, new HashSet<>());
        userToFollowerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userToFollowerMap.containsKey(followerId)){
            userToFollowerMap.get(followerId).remove(followeeId);
        }
    }
}
