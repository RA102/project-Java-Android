package com.example.finaltask.Model;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class BooksXmlParser
{
    private ArrayList<Book> books;

    public BooksXmlParser()
    {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks()
    {
        return books;
    }

    public boolean parse(String xmlData)
    {
        boolean status = true;
        Book currentBook = null;
        boolean inEntry = false;
        String textValue = "";

        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){

                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if("book".equalsIgnoreCase(tagName)){
                            inEntry = true;
                            currentBook = new Book();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(inEntry){
                            if("book".equalsIgnoreCase(tagName)){
                                books.add(currentBook);
                                inEntry = false;
                            } else if("id".equalsIgnoreCase(tagName)){
                                currentBook.setId(textValue);
                            } else if("title".equalsIgnoreCase(tagName)){
                                currentBook.setTitle(textValue);
                            }
                        }
                        break;
                    default:
                }
                eventType = xpp.next();
            }
        }
        catch (Exception e){
            status = false;
            e.printStackTrace();
        }
        return status;
    }

}
