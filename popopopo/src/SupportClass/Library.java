/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClass;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author DemonEdge
 */
public class Library {
    
    List<Material> materials = new List<>();

    public Library() {
    }
    
    public void Add(Material m){
        materials.Add(m);
    }
    
    public void Sell(Material m, int buyCount) throws Exception{
        int position = materials.indexOf(m);
        if (materials.get(position).getCurrentCount()<buyCount) throw new Exception("Don't have many resources.");
        materials.get(position).setCurrentCount(materials.get(position).getCurrentCount()-buyCount);
        SaveSell(m.getName(),m.getPrice(),buyCount,(m.getPrice()* buyCount));
        if (m.getCurrentCount()==0) {
            materials.remove(m);
        }
    }

    private void SaveSell(String name, float price, int buyCount, float f) throws IOException {
        try (FileWriter fw = new FileWriter("src/SavedSells.txt",true)) {
            fw.write(name+"-"+price+"-"+buyCount+"-"+f);
        }
    }
    
    public List<Book> findBooks(String author){
        List<Book> books = new List<>();
        
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Book) {
                if (((Book)materials.get(i)).getAuthor().equals(author)) {
                    books.Add((Book)materials.get(i));
                }
            }
        }
        
        return books;
    }
    
    public List<Book> findBooksAt(String category){
        List<Book> books = new List<>();
        
        if (category.equals("Infantil")) {
            for (int i = 0; i < materials.size(); i++) {
                if (materials.get(i) instanceof Book) {
                    if (((Book)materials.get(i)) instanceof ChildsBook) {
                        books.Add((Book)materials.get(i));
                    }
                }
            } 
        } else {
            for (int i = 0; i < materials.size(); i++) {
                if (materials.get(i) instanceof Book) {
                    if (!(((Book)materials.get(i)) instanceof ChildsBook)) {
                        books.Add((Book)materials.get(i));
                    }
                }
            }
        }
        
        return books;
    }
    
    public List<Book> findBooks(String author, String category){
        List<Book> books = new List<>();
        
        if (category.equals("Infantil")) {
            for (int i = 0; i < materials.size(); i++) {
                if (materials.get(i) instanceof Book) {
                    if (((Book)materials.get(i)) instanceof ChildsBook) {
                        if (((Book)materials.get(i)).getAuthor().equals(author)) {
                            books.Add((Book)materials.get(i));
                        }
                    }
                }
            } 
        } else {
            for (int i = 0; i < materials.size(); i++) {
                if (materials.get(i) instanceof Book) {
                    if (!(((Book)materials.get(i)) instanceof ChildsBook)) {
                        if (((Book)materials.get(i)).getAuthor().equals(author)) {
                            books.Add((Book)materials.get(i));
                        }
                    }
                }
            }
        }
        
        return books;
    }
    
    public List<Book> findBooksAtCollection(String collection){
        List<Book> books = new List<>();
        
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Book) {
                if (((Book)materials.get(i)).getCollection().equals(collection)) {
                    books.Add((Book)materials.get(i));
                }
            }
        }
        
        return books;
    }
    
    public int findBooksAtGender(String Gender){
        int books = 0;
        
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Book) {
                if (((Book)materials.get(i)).getGender().equals(Gender)) {
                    books++;
                }
            }
        }
        
        return books;
    }
    
    public void Sell(List<Book> books,int[] counts) throws Exception{
        for (int i = 0; i < books.size(); i++) {
            Sell(books.get(i),counts[i]);
        }
    }
    
    public List<Book> findRecomendedChildsBooksTo(int agemin,int agemax ){
        List<Book> books = new List<>();
        
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Book)
                if (((Book)materials.get(i)) instanceof ChildsBook)
                    if (((ChildsBook)materials.get(i)).getAgeLimitBottom()>agemin && ((ChildsBook)materials.get(i)).getAgeLimitBottom()<agemax)
                        books.Add((Book) materials.get(i));
        }
        
        return books;
    }
    
    public List<Material> mustSellMaterials(){
        List<Material> mates = new List<>();
        
        for (int i = 0; i < materials.size(); i++) {
            for (int j = 0; j < materials.size(); j++) {
                int sellCounti = materials.get(i).getInsertCount() - materials.get(i).getCurrentCount();
                int sellCountj = materials.get(j).getInsertCount() - materials.get(j).getCurrentCount();
                if (sellCountj>sellCounti) {
                    materials.swap(i,j);
                }
            }
        }
        
        for (int i = 0; i < 10; i++) {
            mates.Add(materials.get(i));
        }
        
        return mates;
    }
    
    public List<Material> mustOldMaterials(){
        List<Material> mates = new List<>();
        
        for (int i = 0; i < materials.size(); i++) {
            for (int j = 0; j < materials.size(); j++) {
                Date datei = materials.get(i).getInsertDate();
                Date datej = materials.get(j).getInsertDate();
                if (datej.before(datei)) {
                    materials.swap(i,j);
                }
            }
        }
        
        for (int i = 0; i < 10; i++) {
            mates.Add(materials.get(i));
        }
        
        return mates;
    }
    
    public List<Journal> getJournals(){
        List<Journal> journals = new List<>();
        
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Journal) {
                journals.Add((Journal) materials.get(i));
            }
        }
        
        return journals;
    }
    
    public List<Book> getBooks(){
        List<Book> books = new List<>();
        
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Book) {
                books.Add((Book) materials.get(i));
            }
        }
        
        return books;
    }
    
    public float getTotalPrice(){
        float sum = 0;
        
        for (int i = 0; i < materials.size(); i++) {
            sum += materials.get(i).getPrice();
        }
        
        return sum;
    }
    
    public float getTotalImportAt(String collection){
        float sum = 0;
        
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Book) {
                if (((Book) materials.get(i)).getCollection().equals(collection)) {
                    sum += materials.get(i).getPrice();
                }
            }
        }
        
        return sum;
    }
    
    public List<Material> SellRanking(){
        List<Material> mates = new List<>();
        
        for (int i = 0; i < materials.size(); i++) {
            for (int j = 0; j < materials.size(); j++) {
                if (materials.get(j).sellValue()>materials.get(i).sellValue()) {
                    materials.swap(i,j);
                }
            }
        }
        
        for (int i = 0; i < materials.size(); i++) {
            mates.Add(materials.get(i));
        }
        
        return mates;
    }
    
}
