
package alex_shutov.com.websocketchat.web.web_model.all_users;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Acl {

    @SerializedName("sZbHjor6HK")
    @Expose
    private SZbHjor6HK sZbHjor6HK;
    @SerializedName("asterisk")
    @Expose
    private Asterisk asterisk;

    /**
     * 
     * @return
     *     The sZbHjor6HK
     */
    public SZbHjor6HK getSZbHjor6HK() {
        return sZbHjor6HK;
    }

    /**
     * 
     * @param sZbHjor6HK
     *     The sZbHjor6HK
     */
    public void setSZbHjor6HK(SZbHjor6HK sZbHjor6HK) {
        this.sZbHjor6HK = sZbHjor6HK;
    }

    /**
     * 
     * @return
     *     The asterisk
     */
    public Asterisk getAsterisk() {
        return asterisk;
    }

    /**
     * 
     * @param asterisk
     *     The asterisk
     */
    public void setAsterisk(Asterisk asterisk) {
        this.asterisk = asterisk;
    }

}
