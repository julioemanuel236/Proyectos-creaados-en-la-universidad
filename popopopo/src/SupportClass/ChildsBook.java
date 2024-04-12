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
public class ChildsBook extends Book{
    
    int ageLimitBottom;
    
    int ageLimitTop;

    /**
     *
     * @param ageLimitBottom
     * @param ageLimitTop
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
     */
    public ChildsBook(int ageLimitBottom, int ageLimitTop, String author, int pagesCount, String gender, int editionNumber, String collection, String lote, String name, float price, Date insertDate, int insertCount) {
        super(author, pagesCount, gender, editionNumber, collection, lote, name, price, insertDate, insertCount);
        this.ageLimitBottom = ageLimitBottom;
        this.ageLimitTop = ageLimitTop;
    }    

    /**
     * Get the value of ageLimitTop
     *
     * @return the value of ageLimitTop
     */
    public int getAgeLimitTop() {
        return ageLimitTop;
    }

    /**
     * Set the value of ageLimitTop
     *
     * @param ageLimitTop new value of ageLimitTop
     */
    public void setAgeLimitTop(int ageLimitTop) {
        this.ageLimitTop = ageLimitTop;
    }

    
    /**
     * Get the value of ageLimitBottom
     *
     * @return the value of ageLimitBottom
     */
    public int getAgeLimitBottom() {
        return ageLimitBottom;
    }

    /**
     * Set the value of ageLimitBottom
     *
     * @param ageLimitBottom new value of ageLimitBottom
     */
    public void setAgeLimitBottom(int ageLimitBottom) {
        this.ageLimitBottom = ageLimitBottom;
    }

}
