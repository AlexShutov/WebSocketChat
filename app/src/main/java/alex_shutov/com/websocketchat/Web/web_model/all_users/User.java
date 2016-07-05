
package alex_shutov.com.websocketchat.web.web_model.all_users;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class User {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("_rperm")
    @Expose
    private List<String> rperm = new ArrayList<String>();
    @SerializedName("_wperm")
    @Expose
    private List<String> wperm = new ArrayList<String>();
    @SerializedName("_acl")
    @Expose
    private Acl acl;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("_updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("_created_at")
    @Expose
    private String createdAt;
    @SerializedName("_hashed_password")
    @Expose
    private String hashedPassword;
    @SerializedName("ship_user_position_lon")
    @Expose
    private Double shipUserPositionLon;
    @SerializedName("ship_city_state")
    @Expose
    private String shipCityState;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("user_zip")
    @Expose
    private String userZip;
    @SerializedName("ship_address2")
    @Expose
    private String shipAddress2;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("ship_user_country")
    @Expose
    private String shipUserCountry;
    @SerializedName("ship_address1")
    @Expose
    private String shipAddress1;
    @SerializedName("city_state")
    @Expose
    private String cityState;
    @SerializedName("ship_user_position_lat")
    @Expose
    private Double shipUserPositionLat;
    @SerializedName("ship_user_zip")
    @Expose
    private String shipUserZip;
    @SerializedName("user_country")
    @Expose
    private String userCountry;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("location")
    @Expose
    private List<Object> location = new ArrayList<Object>();
    @SerializedName("block")
    @Expose
    private List<Object> block = new ArrayList<Object>();
    @SerializedName("follow")
    @Expose
    private List<Object> follow = new ArrayList<Object>();
    @SerializedName("profileCounter")
    @Expose
    private ProfileCounter profileCounter;
    @SerializedName("allowMyLocation")
    @Expose
    private Boolean allowMyLocation;
    @SerializedName("loginTime")
    @Expose
    private String loginTime;
    @SerializedName("groups")
    @Expose
    private List<Object> groups = new ArrayList<Object>();
    @SerializedName("user_position")
    @Expose
    private List<Object> userPosition = new ArrayList<Object>();
    @SerializedName("social_id")
    @Expose
    private String socialId;
    @SerializedName("social_data")
    @Expose
    private String socialData;
    @SerializedName("twitter")
    @Expose
    private Twitter twitter;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("user_password")
    @Expose
    private String userPassword;
    @SerializedName("_auth_data_google")
    @Expose
    private AuthDataGoogle authDataGoogle;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The rperm
     */
    public List<String> getRperm() {
        return rperm;
    }

    /**
     * 
     * @param rperm
     *     The _rperm
     */
    public void setRperm(List<String> rperm) {
        this.rperm = rperm;
    }

    /**
     * 
     * @return
     *     The wperm
     */
    public List<String> getWperm() {
        return wperm;
    }

    /**
     * 
     * @param wperm
     *     The _wperm
     */
    public void setWperm(List<String> wperm) {
        this.wperm = wperm;
    }

    /**
     * 
     * @return
     *     The acl
     */
    public Acl getAcl() {
        return acl;
    }

    /**
     * 
     * @param acl
     *     The _acl
     */
    public void setAcl(Acl acl) {
        this.acl = acl;
    }

    /**
     * 
     * @return
     *     The fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * 
     * @param fullname
     *     The fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * 
     * @param lastname
     *     The lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * 
     * @return
     *     The firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * 
     * @param firstname
     *     The firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * 
     * @return
     *     The phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * 
     * @param phonenumber
     *     The phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * 
     * @return
     *     The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 
     * @param updatedAt
     *     The _updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The _created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The hashedPassword
     */
    public String getHashedPassword() {
        return hashedPassword;
    }

    /**
     * 
     * @param hashedPassword
     *     The _hashed_password
     */
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    /**
     * 
     * @return
     *     The shipUserPositionLon
     */
    public Double getShipUserPositionLon() {
        return shipUserPositionLon;
    }

    /**
     * 
     * @param shipUserPositionLon
     *     The ship_user_position_lon
     */
    public void setShipUserPositionLon(Double shipUserPositionLon) {
        this.shipUserPositionLon = shipUserPositionLon;
    }

    /**
     * 
     * @return
     *     The shipCityState
     */
    public String getShipCityState() {
        return shipCityState;
    }

    /**
     * 
     * @param shipCityState
     *     The ship_city_state
     */
    public void setShipCityState(String shipCityState) {
        this.shipCityState = shipCityState;
    }

    /**
     * 
     * @return
     *     The address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * 
     * @param address2
     *     The address2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * 
     * @return
     *     The userZip
     */
    public String getUserZip() {
        return userZip;
    }

    /**
     * 
     * @param userZip
     *     The user_zip
     */
    public void setUserZip(String userZip) {
        this.userZip = userZip;
    }

    /**
     * 
     * @return
     *     The shipAddress2
     */
    public String getShipAddress2() {
        return shipAddress2;
    }

    /**
     * 
     * @param shipAddress2
     *     The ship_address2
     */
    public void setShipAddress2(String shipAddress2) {
        this.shipAddress2 = shipAddress2;
    }

    /**
     * 
     * @return
     *     The address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * 
     * @param address1
     *     The address1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * 
     * @return
     *     The shipUserCountry
     */
    public String getShipUserCountry() {
        return shipUserCountry;
    }

    /**
     * 
     * @param shipUserCountry
     *     The ship_user_country
     */
    public void setShipUserCountry(String shipUserCountry) {
        this.shipUserCountry = shipUserCountry;
    }

    /**
     * 
     * @return
     *     The shipAddress1
     */
    public String getShipAddress1() {
        return shipAddress1;
    }

    /**
     * 
     * @param shipAddress1
     *     The ship_address1
     */
    public void setShipAddress1(String shipAddress1) {
        this.shipAddress1 = shipAddress1;
    }

    /**
     * 
     * @return
     *     The cityState
     */
    public String getCityState() {
        return cityState;
    }

    /**
     * 
     * @param cityState
     *     The city_state
     */
    public void setCityState(String cityState) {
        this.cityState = cityState;
    }

    /**
     * 
     * @return
     *     The shipUserPositionLat
     */
    public Double getShipUserPositionLat() {
        return shipUserPositionLat;
    }

    /**
     * 
     * @param shipUserPositionLat
     *     The ship_user_position_lat
     */
    public void setShipUserPositionLat(Double shipUserPositionLat) {
        this.shipUserPositionLat = shipUserPositionLat;
    }

    /**
     * 
     * @return
     *     The shipUserZip
     */
    public String getShipUserZip() {
        return shipUserZip;
    }

    /**
     * 
     * @param shipUserZip
     *     The ship_user_zip
     */
    public void setShipUserZip(String shipUserZip) {
        this.shipUserZip = shipUserZip;
    }

    /**
     * 
     * @return
     *     The userCountry
     */
    public String getUserCountry() {
        return userCountry;
    }

    /**
     * 
     * @param userCountry
     *     The user_country
     */
    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    /**
     * 
     * @return
     *     The userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 
     * @param userType
     *     The user_type
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 
     * @return
     *     The location
     */
    public List<Object> getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(List<Object> location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The block
     */
    public List<Object> getBlock() {
        return block;
    }

    /**
     * 
     * @param block
     *     The block
     */
    public void setBlock(List<Object> block) {
        this.block = block;
    }

    /**
     * 
     * @return
     *     The follow
     */
    public List<Object> getFollow() {
        return follow;
    }

    /**
     * 
     * @param follow
     *     The follow
     */
    public void setFollow(List<Object> follow) {
        this.follow = follow;
    }

    /**
     * 
     * @return
     *     The profileCounter
     */
    public ProfileCounter getProfileCounter() {
        return profileCounter;
    }

    /**
     * 
     * @param profileCounter
     *     The profileCounter
     */
    public void setProfileCounter(ProfileCounter profileCounter) {
        this.profileCounter = profileCounter;
    }

    /**
     * 
     * @return
     *     The allowMyLocation
     */
    public Boolean getAllowMyLocation() {
        return allowMyLocation;
    }

    /**
     * 
     * @param allowMyLocation
     *     The allowMyLocation
     */
    public void setAllowMyLocation(Boolean allowMyLocation) {
        this.allowMyLocation = allowMyLocation;
    }

    /**
     * 
     * @return
     *     The loginTime
     */
    public String getLoginTime() {
        return loginTime;
    }

    /**
     * 
     * @param loginTime
     *     The loginTime
     */
    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 
     * @return
     *     The groups
     */
    public List<Object> getGroups() {
        return groups;
    }

    /**
     * 
     * @param groups
     *     The groups
     */
    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    /**
     * 
     * @return
     *     The userPosition
     */
    public List<Object> getUserPosition() {
        return userPosition;
    }

    /**
     * 
     * @param userPosition
     *     The user_position
     */
    public void setUserPosition(List<Object> userPosition) {
        this.userPosition = userPosition;
    }

    /**
     * 
     * @return
     *     The socialId
     */
    public String getSocialId() {
        return socialId;
    }

    /**
     * 
     * @param socialId
     *     The social_id
     */
    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    /**
     * 
     * @return
     *     The socialData
     */
    public String getSocialData() {
        return socialData;
    }

    /**
     * 
     * @param socialData
     *     The social_data
     */
    public void setSocialData(String socialData) {
        this.socialData = socialData;
    }

    /**
     * 
     * @return
     *     The twitter
     */
    public Twitter getTwitter() {
        return twitter;
    }

    /**
     * 
     * @param twitter
     *     The twitter
     */
    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    /**
     * 
     * @return
     *     The avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 
     * @param avatar
     *     The avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 
     * @return
     *     The userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 
     * @param userPassword
     *     The user_password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 
     * @return
     *     The authDataGoogle
     */
    public AuthDataGoogle getAuthDataGoogle() {
        return authDataGoogle;
    }

    /**
     * 
     * @param authDataGoogle
     *     The _auth_data_google
     */
    public void setAuthDataGoogle(AuthDataGoogle authDataGoogle) {
        this.authDataGoogle = authDataGoogle;
    }

}
