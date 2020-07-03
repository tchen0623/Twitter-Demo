import java.security.Timestamp;
import java.util.HashSet;
import java.util.Set;

class User {
    private int id;
    public Set<Integer> followed;
    public Tweet head;
    public User(int userId){
        followed = new HashSet<>();
        this.id = userId;
        this.head = null;
        follow(id);
    }
    public void follow(int userId){
        followed.add(userId);
    }
    public void unfollow(int userId){
        if(userId != this.id){
            followed.remove(userId);
        }
    }
    public void post(int tweetId){
        Tweet twt = new Tweet(tweetId,timestamp);
        timestamp++;
        twt.next = null;
        head = twt;
    }
}