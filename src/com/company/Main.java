package com.company;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;

interface InOutBook{
    public List<String> addToList();
    public void checkFileForWrite() throws IOException;
    public void checkFileForRead() throws IOException;
    public void writeToFile(String filename) throws IOException;
    public String [] readFromFile() throws IOException;
    public void printBooks() throws IOException;
}
abstract class Book{
public String bookname;
public String author;
public String genre;
public int year;

    public void setName(String bookname){
    this.bookname=bookname;
    }
    public String getBookName(){
    return bookname;
    }

    public void setAuthor(String author){
        this.author=author;
    }
    public String getAuthor(){
        return author;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }
    public String getGenre(){
        return genre;
    }
    public void setYear(int year){
    this.year=year;
    }
    public int getYear(){
    return year;
    }


    /*public String toString(){
       return bookname+"_"+author+"_"+year;
    }*/

}

class Literature extends Book implements InOutBook{
private String bookname;
private String author;
private String genre;
private int year;


    @Override
    public void setName(String bookname) {
        super.setName(bookname);
        this.bookname=bookname;
        //System.out.println(bookname);
    }

    @Override
    public String getBookName() {
        //System.out.println("Book name: " + getBookName());
        return getBookName();
    }

    @Override
    public void setAuthor(String author) {
        super.setAuthor(author);
        this.author=author;
    }

    @Override
    public String getAuthor() {
        //System.out.println("Book author: " + getAuthor());
        return getAuthor();
    }

    @Override
    public void setGenre(String genre) {
        super.setGenre(genre);
        this.genre=genre;
    }

    @Override
    public String getGenre() {
        return super.getGenre();
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
        this.year=year;
    }

    @Override
    public int getYear() {
       // System.out.println("Book year: " + getYear());
        return getYear();
    }

    /*public String toString(){
        return bookname+"_"+author+"_"+year;
    }*/

    public List<String> addToList() {
        //String text=toString();
        //text=text.replace(",","");
        //Literature obj = new Literature();
        ArrayList<String> list=new ArrayList<String>();
        list.add(0,bookname);
        list.add(1,author);
        list.add(2,genre);
        list.add(3,String.valueOf(year));
        //System.out.println(list);
        return list;
    }

    public void checkFileForRead() throws IOException {
        final String filename="C:/Users/Shirin/Desktop/OOP/lab1/Books.txt";
        File file=new File(filename);
        if(file.exists()){
            readFromFile();
        }
        else {
            Files.createFile(Paths.get(filename));
            readFromFile();
        }
    }
    public void checkFileForWrite() throws IOException {
        final String filename="C:/Users/Shirin/Desktop/OOP/lab1/Books.txt";
        File file=new File(filename);
        if(file.exists()){
            writeToFile(filename);
        }
        else {
            Files.createFile(Paths.get(filename));
            writeToFile(filename);
        }
    }

    public void writeToFile(String filename) throws IOException{

        File outputfilename= new File(filename);
        List<String> list=new ArrayList<String>();
        list=addToList();
        System.out.println(list);
        try (BufferedWriter writer=new BufferedWriter(new FileWriter(outputfilename,true))){
            if(outputfilename.length()==0)  {writer.newLine();}
            for(String value:list){
                writer.write(value + "_");
                //writer.newLine();
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

      public String[] readFromFile() throws IOException {

        String text="";
        //String [] strarr = new String[10];//=new String[];
          //String str="";
          StringBuilder resultStringBuilder=new StringBuilder();
        try (BufferedReader reader=new BufferedReader(new FileReader("C:/Users/Shirin/Desktop/OOP/lab1/Books.txt"))){

            while ((text=reader.readLine())!=null){
                resultStringBuilder.append(text).append("\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        String [] words=resultStringBuilder.toString().split("_");
        return words;
      }

      public void printBooks() throws IOException {
        String [] books=readFromFile();
          for(String value: books){
              System.out.print(value + " ");
          }
      }
}


public class Main {

    public static void main(String[] args) throws IOException {
	Literature lit=new Literature();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите название книги:");  //Любовь к жизни
        String bookname=scanner.nextLine();
	    lit.setAuthor("Джек Лондон");
	    lit.setName(bookname);
	    lit.setGenre("Рассказ");
	    lit.setYear(1907);
	//System.out.println(lit.toString());
	//lit.addToList();
	//lit.writeToFile();
	//lit.readFromFile();
        lit.checkFileForWrite();
    }
}
