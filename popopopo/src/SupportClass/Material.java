/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClass;

import java.util.Date;

/**
 *
 * @author Julio Rafael LL
 */
public abstract class Material {

    String lote;

    String name;

    float price;

    Date insertDate;

    int insertCount;

    int currentCount;

    /**
     *
     * @param lote
     * @param name
     * @param price
     * @param insertDate
     * @param insertCount
     * @param currentCount
     */
    public Material(String lote, String name, float price, Date insertDate, int insertCount) {
        this.lote = lote;
        this.name = name;
        this.price = price;
        this.insertDate = insertDate;
        this.insertCount = insertCount;
        this.currentCount = insertCount;
    }

    /**
     * Get the value of currentCount
     *
     * @return the value of currentCount
     */
    public int getCurrentCount() {
        return currentCount;
    }

    /**
     * Set the value of currentCount
     *
     * @param currentCount new value of currentCount
     */
    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    /**
     * Get the value of insertCount
     *
     * @return the value of insertCount
     */
    public int getInsertCount() {
        return insertCount;
    }

    /**
     * Set the value of insertCount
     *
     * @param insertCount new value of insertCount
     */
    public void setInsertCount(int insertCount) {
        this.insertCount = insertCount;
    }

    /**
     * Get the value of insertDate
     *
     * @return the value of insertDate
     */
    public Date getInsertDate() {
        return insertDate;
    }

    /**
     * Set the value of insertDate
     *
     * @param insertDate new value of insertDate
     */
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of lote
     *
     * @return the value of lote
     */
    public String getLote() {
        return lote;
    }

    /**
     * Set the value of lote
     *
     * @param lote new value of lote
     */
    public void setLote(String lote) {
        this.lote = lote;
    }

    public abstract double sellValue();

    @Override
    public String toString() {
        return "Material{" + "lote=" + lote + ", name=" + name + ", price=" + price + ", insertDate=" + insertDate + ", insertCount=" + insertCount + ", currentCount=" + currentCount + '}';
    }
}
