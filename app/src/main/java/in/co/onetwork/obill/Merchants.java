package in.co.onetwork.obill;

/**
 * Created by abhi on 25/9/17.
 */

public class Merchants {
    String uid,name,org,address,email;
    Merchants(){}
    Merchants(String uid,String name,String org,String address,String email){
        this.uid=uid;
        this.name=name;
        this.org=org;
        this.address=address;
        this.email=email;
    }
    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getOrg() {
        return org;
    }

    public String getUid() {
        return uid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
