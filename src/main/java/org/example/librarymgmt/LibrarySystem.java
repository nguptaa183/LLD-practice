package org.example.librarymgmt;

import java.util.ArrayList;
import java.util.List;

abstract class Item {

    private final long id;
    private final String title;

    Item(long id, String title){
        this.id=id;
        this.title=title;
    }

    long getId(){
        return id;
    }

    String getTitle(){
        return title;
    }

    abstract void displayDetails();

}

class Book extends Item{
    private final String author;
    private final String bookType;

    Book(long id, String title, String author, String bookType) {
        super(id,title);
        this.author=author;
        this.bookType=bookType;
    }

    void displayDetails(){
        System.out.println(getId()+ " " + getTitle() + " " + author + " " + bookType);
    }
}

class Dvd extends Item{
    private final double size;

    Dvd(long id, String title,double size){
        super(id, title);
        this.size=size;
    }

    void displayDetails(){
        System.out.println(getId()+ " " + getTitle() + " " + size);
    }
}

class Library {

    private final List<Item> itemList = new ArrayList<>();

    void addItems(Item item) {
        itemList.add(item);
    }

    void removeItems(long id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                itemList.remove(item);
                System.out.println("Item " + id + " Removed!");
            }
        }
    }

    void displayItems() {
        for (Item item : itemList) {
            item.displayDetails();
        }
    }

}

public class LibrarySystem{
    public static void main(String[] args){
        Library library = new Library();
        Item book1 = new Book(1,"Atomic Habits","James","Hardbind");
        Item book2 = new Book(2,"Harry Porter","JK Rowling","Kindle");

        Item dvd1 = new Dvd(3,"3 Idiots",4.7);
        Item dvd2 = new Dvd(4,"De Dana Dan",1.5);

        library.addItems(book1);
        library.addItems(book2);
        library.addItems(dvd1);
        library.addItems(dvd2);

        library.displayItems();

        library.removeItems(3);

        library.displayItems();

    }

}
