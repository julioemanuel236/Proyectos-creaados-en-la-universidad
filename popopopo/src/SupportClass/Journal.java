/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClass;

import java.util.Date;

/**
 *
 * @author DemonEdge
 */
public class Journal extends Material{
    
    int year;
    
    int frecuency;
    
    String topic;

    /**
     *
     * @param year
     * @param frecuency
     * @param topic
     * @param lote
     * @param name
     * @param price
     * @param insertDate
     * @param insertCount
     * @param currentCount
     */
    public Journal(int year, int frecuency, String topic, String lote, String name, float price, Date insertDate, int insertCount) {
        super(lote, name, price, insertDate, insertCount);
        this.year = year;
        this.frecuency = frecuency;
        this.topic = topic;
    }
    

    /**
     * Get the value of topic
     *
     * @return the value of topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Set the value of topic
     *
     * @param topic new value of topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }


    /**
     * Get the value of frecuency
     *
     * @return the value of frecuency
     */
    public int getFrecuency() {
        return frecuency;
    }

    /**
     * Set the value of frecuency
     *
     * @param frecuency new value of frecuency
     */
    public void setFrecuency(int frecuency) {
        this.frecuency = frecuency;
    }


    /**
     * Get the value of year
     *
     * @return the value of year
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the value of year
     *
     * @param year new value of year
     */
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public double sellValue() {
        return ((insertCount-currentCount)/(insertDate.getTime()/86400000)*0.8*frecuency);
    }

    @Override
    public String toString() {
        return super.toString()+ "Journal{" + "year=" + year + ", frecuency=" + frecuency + ", topic=" + topic + '}';
    }

    
}
