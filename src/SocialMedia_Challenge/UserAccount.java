package SocialMedia_Challenge;

public class UserAccount {
    private final String email;
    private final String userName;
    private final Post[] timeLine;
    private final Post[] myPosts;
    private final UserAccount[] myFriends;
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
        if (myFriendsIdx == myFriends.length){
            System.out.println("Your friend list is full!");
            return;
        }

        for (int i = 0; i < myFriendsIdx; i++) {
            if (myFriends[i] == newFollower){
                System.out.println("This friend is already on your list!");
                return;
            }
        }

        myFriends[myFriendsIdx] = newFollower;
        myFriendsIdx++;
    }

    public void blockFollower(UserAccount follower){
        if (myFriendsIdx == 0){
            System.out.println("There are no followers to block!");
            return;
        }

        for (int i = 0; i < myFriendsIdx; i++) {
            if (myFriends[i] == follower){
                for (int j = i; j < myFriendsIdx - 1; j++) {
                    myFriends[j] = myFriends[j + 1];
                }

                myFriends[myFriendsIdx - 1] = null;
                myFriendsIdx--;
                System.out.println("User successfully blocked!");
                return;
            }
        }
    }

    public String showTimeline(){
        StringBuilder output =  new StringBuilder();

        output.append("------------------Time Line--------------------\n");

        for (int i = 0; i < timeLineIdx; i++) {
            output.append(timeLine[i].show()).append("\n");
        }

        output.append("--------------------------------------\n");

        return output.toString();
    }

    public String showMyPosts(){
        StringBuilder output =  new StringBuilder();

        output.append("------------------My Posts--------------------\n");

        for (int i = 0; i < myPostsIdx; i++) {
            output.append(myPosts[i].show()).append("\n");
        }

        output.append("--------------------------------------\n");

        return output.toString();
    }

    public String showMyFriends(){
        StringBuilder output = new StringBuilder();

        output.append("------------------My Friends--------------------\n");

        for (int i = 0; i < myFriendsIdx; i++) {
            output.append(myFriends[i].userName).append(" | ").append(myFriends[i].email).append("\n");
        }

        output.append("--------------------------------------\n");

        return output.toString();
    }

    public String getUserName(){
        return userName;
    }
}
