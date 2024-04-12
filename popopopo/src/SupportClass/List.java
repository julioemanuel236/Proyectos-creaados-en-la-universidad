/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClass;

/**
 *
 * @author DemonEdge
 * @param <T>
 */
public class List<T> {
    T[] elements;
    int realCount;

    public List() {
        this.elements = (T[]) new Object[1000];
        this.realCount = 0;
    }
    
    public void Add(T element){
        elements[realCount] = element;
        realCount++;
    }
    
    public int indexOf(T element){
        for (int i = 0; i < realCount; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    
    public T get(int index){
        return elements[index];
    }
    
    /**
     *
     * @param index
     * @throws IndexOutOfBoundsException
     */
    public void remove(int index) throws IndexOutOfBoundsException{
        if (index<0 || index>=realCount) throw new IndexOutOfBoundsException();
        for (int i = index; i < realCount-1; i++) {
            elements[i] = elements[i+1];
        }
        realCount--;
    }
    
    public void remove(T element) throws IndexOutOfBoundsException{
        int index = indexOf(element);
        remove(index);
    }
    
    public int size(){
        return realCount;
    }
    
    public boolean isEmpty(){
        return (realCount==0);
    }
    
    public void swap(int i, int j){
        T aux = elements[i];
        elements[i] = elements[j];
        elements[j] = aux;
    }
}
