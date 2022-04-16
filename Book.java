/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManagement;

/**
 *
 * @author user
 */
public class Book {
    private String codeString;
    private String titleString;
    private int qua;
    private double price;
    
    public Book() {
        
    }
    
    public Book(String codeString, String titleString, int qua, double price) {
        this.codeString = codeString;
        this.titleString = titleString;
        this.qua = qua;
        this.price = price;
    }

    public String getCodeString() {
        return codeString;
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    public String getTitleString() {
        return titleString;
    }

    public void setTitleString(String titleString) {
        this.titleString = titleString;
    }

    public int getQua() {
        return qua;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return codeString+";"+titleString+";"+qua+";"+price;
    }
    
    
}
