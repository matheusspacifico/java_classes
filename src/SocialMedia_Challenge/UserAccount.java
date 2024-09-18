package SocialMedia_Challenge;

public class UserAccount {
    private String email;
    private String userName;
    private Post[] timeLine;
    private Post[] myPosts;
    private UserAccount[] myFriends;
    private int timeLineIdx;
    private int myPostsIdx;
    private int myFriendsIdx;

    public UserAccount(String email, String userName) {
        this.email = email;
        this.userName = userName;

        this.timeLine = new Post[10];
        this.myPosts = new Post[50];
        this.myFriends = new UserAccount[50];
    }

    public void publish(String quote){
        Post newPost = new Post(this, quote);

        if (myPostsIdx < myPosts.length){
            myPosts[myPostsIdx] = newPost;
            myPostsIdx++;
        } else {
            System.out.println("Post limit reached!");
        }

        for (int i = 0; i < myFriendsIdx; i++) {
            myFriends[i].updateTimeline(newPost);
        }
    }

    public void updateTimeline(Post newPost){
        if (timeLineIdx < timeLine.length){
            timeLine[timeLineIdx] = newPost;
            timeLineIdx++;
        } else {
            timeLine[0] = newPost;

            for (int i = 1; i < timeLine.length; i++) {
                timeLine[i - 1] = timeLine[i];
            }
            timeLine[timeLine.length - 1] = newPost;
        }
    }

    public boolean delete(int postIdx){
        if (myPostsIdx == 0){
            System.out.println("There are no posts to delete!");
            return false;
        }

        if (postIdx < 0 || postIdx >= myPostsIdx) {
            System.out.println("Invalid index provided!");
            return false;
        }

        for (int i = postIdx; i < myPostsIdx - 1; i++) {
            myPosts[i] = myPosts[i + 1];
        }
        myPosts[myPostsIdx - 1] = null;
        myPostsIdx--;

        System.out.println("Post successfully deleted!");
        return true;
    }

    public void clapPost(int postIdx){
        if (timeLineIdx == 0){
            System.out.println("There are no posts to clap!");
            return;
        }

        if (postIdx < 0 || postIdx >= timeLineIdx) {
            System.out.println("Invalid index provided!");
            return;
        }

        if (timeLine[postIdx] == null){
            System.out.println("There are no posts at this index!");
            return;
        }

        timeLine[postIdx].clap();
        System.out.println("Post successfully clapped!");
    }

    public void booPost(int postIdx){
        if (timeLineIdx == 0){
            System.out.println("There are no posts to boo!");
            return;
        }

        if (postIdx < 0 || postIdx >= timeLineIdx) {
            System.out.println("Invalid index provided!");
            return;
        }

        if (timeLine[postIdx] == null){
            System.out.println("There are no posts at this index!");
            return;
        }

        timeLine[postIdx].boo();
        System.out.println("Post successfully booed!");
    }

    public void acceptFollower(UserAccount newFollower){

    }

    public void blockFollower(UserAccount follower){

    }

    public String showTimeline(){

    }

    public String showMyPosts(){

    }

    public String showMyFriends(){

    }

    public String getUserName(){
        return userName;
    }
}
