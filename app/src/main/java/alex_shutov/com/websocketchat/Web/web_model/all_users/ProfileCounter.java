
package alex_shutov.com.websocketchat.web.web_model.all_users;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ProfileCounter {

    @SerializedName("replies")
    @Expose
    private Integer replies;
    @SerializedName("followings")
    @Expose
    private Integer followings;
    @SerializedName("knownFollowers")
    @Expose
    private Integer knownFollowers;
    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("collections")
    @Expose
    private Integer collections;
    @SerializedName("favorites")
    @Expose
    private Integer favorites;

    /**
     * 
     * @return
     *     The replies
     */
    public Integer getReplies() {
        return replies;
    }

    /**
     * 
     * @param replies
     *     The replies
     */
    public void setReplies(Integer replies) {
        this.replies = replies;
    }

    /**
     * 
     * @return
     *     The followings
     */
    public Integer getFollowings() {
        return followings;
    }

    /**
     * 
     * @param followings
     *     The followings
     */
    public void setFollowings(Integer followings) {
        this.followings = followings;
    }

    /**
     * 
     * @return
     *     The knownFollowers
     */
    public Integer getKnownFollowers() {
        return knownFollowers;
    }

    /**
     * 
     * @param knownFollowers
     *     The knownFollowers
     */
    public void setKnownFollowers(Integer knownFollowers) {
        this.knownFollowers = knownFollowers;
    }

    /**
     * 
     * @return
     *     The followers
     */
    public Integer getFollowers() {
        return followers;
    }

    /**
     * 
     * @param followers
     *     The followers
     */
    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    /**
     * 
     * @return
     *     The collections
     */
    public Integer getCollections() {
        return collections;
    }

    /**
     * 
     * @param collections
     *     The collections
     */
    public void setCollections(Integer collections) {
        this.collections = collections;
    }

    /**
     * 
     * @return
     *     The favorites
     */
    public Integer getFavorites() {
        return favorites;
    }

    /**
     * 
     * @param favorites
     *     The favorites
     */
    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }

}
