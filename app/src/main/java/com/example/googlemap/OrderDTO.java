package com.example.googlemap;


import java.sql.Timestamp;

public class OrderDTO {
    

    private long id;
    

    private String userfk;
    

    private long companyfk;


    private long customfk;
    

    private int count;
    

    private long cost;

    private Timestamp timestamp;
    
    /**
 * @param userfk the userfk to set
 */
public void setUserfk(String userfk) {
	this.userfk = userfk;
}
    /**
 * @return the userfk
 */
public String getUserfk() {
	return userfk;
}
    /**
 * @param timestamp the timestamp to set
 */
public void setTimestamp(Timestamp timestamp) {
	this.timestamp = timestamp;
}
    /**
 * @return the timestamp
 */
public Timestamp getTimestamp() {
	return timestamp;
}
    /**
 * @param id the id to set
 */
public void setId(long id) {
	this.id = id;
}
 /**
 * @return the id
 */
public long getId() {
	return id;
}
    /**
 * @param customfk the customfk to set
 */
public void setCustomfk(long customfk) {
	this.customfk = customfk;
}
    /**
 * @return the customfk
 */
public long getCustomfk() {
	return customfk;
}
    /**
 * @param count the count to set
 */
public void setCount(int count) {
	this.count = count;
}
    /**
 * @return the count
 */
public int getCount() {
	return count;
}
    /**
 * @param cost the cost to set
 */
public void setCost(long cost) {
	this.cost = cost;
}
    /**
 * @return the cost
 */
public long getCost() {
	return cost;
}
    /**
 * @param companyfk the companyfk to set
 */
public void setCompanyfk(long companyfk) {
	this.companyfk = companyfk;
}
    /**
 * @return the companyfk
 */
public long getCompanyfk() {
	return companyfk;
}
    
}