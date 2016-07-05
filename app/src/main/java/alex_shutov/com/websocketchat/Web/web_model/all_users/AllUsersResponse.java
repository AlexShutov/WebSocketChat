
package alex_shutov.com.websocketchat.web.web_model.all_users;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AllUsersResponse {

    @SerializedName("users")
    @Expose
    private List<User> users = new ArrayList<User>();

    /**
     * 
     * @return
     *     The users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * 
     * @param users
     *     The users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

}
