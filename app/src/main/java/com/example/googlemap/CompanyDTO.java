package com.example.googlemap;


public class CompanyDTO {

    private long id;

    private String owner;

    private String name;

    private String region;

    private String ownername;

    private String info;

    private float positionX;

    private float positionY;

    private String category;

    private int filter1;

    private int filter2;

    private int filter3;
    

    /**
 * @return the id
 */
public long getId() {
	return id;
}
    /**
 * @param region the region to set
 */
public void setRegion(String region) {
	this.region = region;
}
    /**
 * @return the region
 */
public String getRegion() {
	return region;
}
    /**
 * @param positionY the positionY to set
 */
public void setPositionY(float positionY) {
	this.positionY = positionY;
}
    /**
 * @return the positionY
 */
public float getPositionY() {
	return positionY;
}
    /**
 * @param positionX the positionX to set
 */
public void setPositionX(float positionX) {
	this.positionX = positionX;
}
    /**
 * @return the positionX
 */
public float getPositionX() {
	return positionX;
}
    /**
 * @param owner the owner to set
 */
public void setOwner(String owner) {
	this.owner = owner;
}
    /**
 * @return the owner
 */
public String getOwner() {
	return owner;
}
    /**
 * @param ownername the ownername to set
 */
public void setOwnername(String ownername) {
	this.ownername = ownername;
}
    /**
 * @return the ownername
 */
public String getOwnername() {
	return ownername;
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
 * @param logoImage the logoImage to set
 */

    /**
 * @param info the info to set
 */
public void setInfo(String info) {
	this.info = info;
}
    /**
 * @return the info
 */
public String getInfo() {
	return info;
}
    /**
 * @param image the image to set
 */

    /**
 * @param id the id to set
 */
public void setId(long id) {
	this.id = id;
}
    /**
 * @return the category
 */
public String getCategory() {
	return category;
}
    /**
 * @param filter3 the filter3 to set
 */

    /**
 * @param category the category to set
 */
public void setCategory(String category) {
	this.category = category;
}

    public int getFilter1() {
        return filter1;
    }

    public void setFilter1(int filter1) {
        this.filter1 = filter1;
    }

    public int getFilter2() {
        return filter2;
    }

    public void setFilter2(int filter2) {
        this.filter2 = filter2;
    }

    public int getFilter3() {
        return filter3;
    }

    public void setFilter3(int filter3) {
        this.filter3 = filter3;
    }
}
