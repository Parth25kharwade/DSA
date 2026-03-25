class Twitter {
    private static int timeStamp=0;
    private class User{
        int id;
        Set<Integer> followed;
        Tweet tweetHead;
          
        public User(int id){
            this.id=id;
            followed=new HashSet<>();
            follow(id);
            tweetHead=null;
        }

        public void follow(int id){
            followed.add(id);
        }
        public void unfollow(int id){
            if(id!=this.id){
                followed.remove(id);
            }
        }
        public void post(int id){
        Tweet newTweet=new Tweet(id);
        newTweet.next=tweetHead;
        tweetHead=newTweet;
        }

    }
    private class Tweet{
        int id;
        int time;
        Tweet next;
        public Tweet(int id){
            this.id=id;
            time=timeStamp++;
            next=null;
        }
    }
    private Map<Integer,User> userMap;
    public Twitter() {
        userMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
           User newUser=new User(userId);
           userMap.put(userId,newUser);
        }
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        if (!userMap.containsKey(userId)) return res;

        Set<Integer> users = userMap.get(userId).followed;

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        for (int uid : users) {
            if (userMap.containsKey(uid)) {
                Tweet t = userMap.get(uid).tweetHead;
                if (t != null) pq.add(t);
            }
        }

        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            count++;

            if (t.next != null) {
                pq.add(t.next);
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
         if (!userMap.containsKey(followerId)) return;
        userMap.get(followerId).unfollow(followeeId);
    
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */