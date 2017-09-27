package in.co.onetwork.obill;

/**
 * Created by abhi on 25/9/17.
 */

public class Bill {
    String name,add,mob,tax,disc,amount,date,bid;
    Bill(){

    }
    Bill(String name,String add,String mob,String tax,String disc, String amount,String date, String bid){
        this.name=name;
        this.add=add;
        this.mob=mob;
        this.tax=tax;
        this.disc=disc;
        this.amount=amount;
        this.date=date;
        this.bid=bid;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public String getAmount() {
        return amount;
    }

    public String getBid() {
        return bid;
    }

    public String getDisc() {
        return disc;
    }

    public String getMob() {
        return mob;
    }

    public String getName() {
        return name;
    }

    public String getTax() {
        return tax;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }
}
