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
public class Book extends Material{
    
    String author;
    
    int pagesCount;
    
    String gender;
    
    int editionNumber;
    
    String collection;

    /**
     *
     * @param author
     * @param pagesCount
     * @param gender
     * @param editionNumber
     * @param collection
     * @param lote
     * @param name
     * @param price
     * @param insertDate
     * @param insertCount
     * @param currentCount
     */
    public Book(String author, int pagesCount, String gender, int editionNumber, String collection, String lote, String name, float price, Date insertDate, int insertCount) {
        super(lote, name, price, insertDate, insertCount);
        this.author = author;
        this.pagesCount = pagesCount;
        this.gender = gender;
        this.editionNumber = editionNumber;
        this.collection = collection;
    }

   
    
    /**
     * Get the value of collection
     *
     * @return the value of collection
     */
    public String getCollection() {
        return collection;
    }

    /**
     * Set the value of collection
     *
     * @param collection new value of collection
     */
    public void setCollection(String collection) {
        this.collection = collection;
    }


    /**
     * Get the value of editionNumber
     *
     * @return the value of editionNumber
     */
    public int getEditionNumber() {
        return editionNumber;
    }

    /**
     * Set the value of editionNumber
     *
     * @param editionNumber new value of editionNumber
     */
    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }


    /**
     * Get the value of gender
     *
     * @return the value of gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set the value of gender
     *
     * @param gender new value of gender
     */
    public void setGener(String gender) {
        this.gender = gender;
    }

    

    /**
     * Get the value of pagesCount
     *
     * @return the value of pagesCount
     */
    public int getPagesCount() {
        return pagesCount;
    }

    /**
     * Set the value of pagesCount
     *
     * @param pagesCount new value of pagesCount
     */
    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }


    /**
     * Get the value of author
     *
     * @return the value of author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set the value of author
     *
     * @param author new value of author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public double sellValue() {
        return (insertCount-currentCount)/((System.currentTimeMillis()-insertDate.getTime())/86400000);
    }

    @Override
    public String toString() {
        return super.toString()+"Book{" + "author=" + author + ", pagesCount=" + pagesCount + ", gender=" + gender + ", editionNumber=" + editionNumber + ", collection=" + collection + '}';
    }

    
}
