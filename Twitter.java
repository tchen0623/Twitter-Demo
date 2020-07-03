import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter{
    private static int timestamp = 0;
    private static class Tweet{}
    private static class User{}
    private HashMap<Integer,User> userMap = new HashMap<>();
    public void postTweet(int UserId,int tweetId){
        if(!userMap.containsKey(UserId)){
            userMap.put(UserId,new User(UserId));
        }
        User u = userMap.get(userid);
        u.post(tweetId);
    }
    public List<integer> getNewsFeed(int userId){
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)){
            return res;
        }
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(),(a,b)->(b.time - a.time));
        for(int id: users){
            Tweet twt = userMap.get(id).head;
            if(twt == null){
                continue;
            }
            pq.add(twt);
        }
        while(!pq.isEmpty()){
            if(res.size() == 10){
                break;
            }
            Tweet twt = pq.poll();
            res.add(twt.id);
            if(twt.next != null){
                pq.add(twt.next);
            }
        }
        return res;
    }

    public void follow(int followerId,int followeeId){
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId,u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId,u);
        }
        userMap.get(followerId).follow(followeeId);
    }


    public void unfollow(int followerId,int followeeId){
        if(userMap.containsKey(followerId)){
            User flwer = userMap.get(followerId);
            flwer.unfollow(followeeId);
        }
    }
}



