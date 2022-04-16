/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class BookList {
    
    public void Display(ArrayList<Book> list) {
        for(Book b : list) {
            System.out.println(b);
        }
    }
    
    public Book Search(ArrayList<Book> list) {
        Book bk = new Book();
        String code = new Scanner(System.in).nextLine();
        boolean find = false;
        for(Book s : list) {
            if(s.getCodeString().equals(code)){
                bk = s;
                find = true;
            }
        }
        if(find == false)
            System.out.println("The library don't have that book!");
        return bk;
    }
    
    public void Update(ArrayList<Book> list) {
        System.out.println("----What Book's code you want to update?--");
        Book uBook = new Book();
        uBook = Search(list);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the new Book's title: ");
        String titleString = sc.nextLine();
        uBook.setTitleString(titleString);
            
        System.out.println("Input the new Book's qua: ");
        int qua = sc.nextInt(); sc.nextLine();
        uBook.setQua(qua);
        
        System.out.println("Input the new Book's price: ");
        double price = sc.nextDouble(); sc.nextLine();
        uBook.setPrice(price);
        System.out.println("Update successfully! ");
    }

    
    public void MaxP(ArrayList<Book> list) {
        Book f = list.get(0);
        for(Book s : list) {
            if(s.getPrice() > f.getPrice())
                f = s;
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the new Book's title: ");
        String titleString = sc.nextLine();
        
        f.setTitleString(titleString);
        
    }
    
    public void SortAccending(ArrayList<Book> list) {
        Collections.sort(list,new Comparator<Book>() {
            @Override
		public int compare(Book o1, Book o2) {
			return o1.getTitleString().compareTo(o2.getTitleString());
		}	
	});
	Display(list); 
    }
    
    public void SortQuanAccending(ArrayList<Book> list) {
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o2, Book o1 ) {
//                return (int) (o1.getQua()- o2.getQua());
                return (int) (o1.getPrice()- o2.getPrice());
            }
        });
	Display(list); 
    }
    
    void loadFile(String fname, ArrayList<Book> list) throws IOException {
        
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String [] u; 
        String s; 
        Book x;
        String xCode; 
        String xTitle; 
        int xQua;
        double xPrice;
        
        int i=0;
        while(true) {
          s = br.readLine();
          if(s==null) 
              break; 
          s = s.trim();
          u = s.split("[ | ]+");
          if(u.length <2 ) 
              break;
          xCode = u[0];
          xTitle = u[1];
          xQua = Integer.parseInt(u[2].trim());
          xPrice = Double.parseDouble(u[3].trim());
          x = new Book(xCode, xTitle, xQua, xPrice);
          list.add(x);
        }
        fr.close();
        br.close();
  }
    
    public static void main(String[] args) throws IOException {
        ArrayList<Book> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        BookList booklist = new BookList();
        String fname = "Book.txt";
        booklist.loadFile(fname, list);
        do {
            System.out.println("Menu:");
            System.out.println("1. Load & display.");
            System.out.println("2. Sort by title & display.");
            System.out.println("3. Sort by quantity descendingly & display.");
            System.out.println("4. Find the max price and change title to XX then display.");
            System.out.println("0. Exit.");
            System.out.println("-----------------------------------");
            System.out.println("What is your choice ? ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1: 
                {
//                    booklist.loadFile(fname, list);
                    booklist.Display(list);
                    break;
                }
                case 2:
                {   
                    
                    booklist.SortAccending(list);
                    System.out.println("------------------------------------------");
                    break;
                }
                case 3: 
                {
                    
                    booklist.SortQuanAccending(list);
                    System.out.println("------------------------------------------");
                    break;
                }
                case 4:
                {
                    
                    booklist.MaxP(list);
                    System.out.println("------------------------------------------");
                    break;
                }
                
                case 0: {
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("You haven't choiced! Please try again! ");
                    System.out.println("------------------------------------------");
                    break;
                }
            }
        }while(true);
    }
    
}
