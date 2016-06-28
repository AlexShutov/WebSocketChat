package alex_shutov.com.websocketchat.Web;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class LoginData {

    @SerializedName("Vendor")
    @Expose
    private String vendor;
    @SerializedName("Username")
    @Expose
    private String username;
    @SerializedName("Password")
    @Expose
    private String password;

    /**
     *
     * @return
     * The vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     *
     * @param vendor
     * The Vendor
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The Username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The Password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}