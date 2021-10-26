package com.example.googlemap;




public class CustomDTO {

    private long id;

    private long companyfk;

    private String name;

    private String kinds;

    private String userfk;

    private long orderfk;

    private String image;
    
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
 * @param orderfk the orderfk to set
 */
public void setOrderfk(long orderfk) {
	this.orderfk = orderfk;
}
    /**
 * @return the orderfk
 */
public long getOrderfk() {
	return orderfk;
}
    /**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
    /**
 * @return the name
 */
public String getName() {
	return name;
}
    /**
 * @param kinds the kinds to set
 */
public void setKinds(String kinds) {
	this.kinds = kinds;
}
    /**
 * @return the kinds
 */
public String getKinds() {
	return kinds;
}
    /**
 * @param image the image to set
 */
public void setImage(String image) {
	this.image = image;
}
    /**
 * @return the image
 */
public String getImage() {
	return image;
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
