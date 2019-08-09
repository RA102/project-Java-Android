package com.example.finaltask;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView browser=(WebView)findViewById(R.id.webBrowser);
        browser.loadUrl("https://books.google.com/books/feeds/volumes?q=php");
        String xmldata = "https://books.google.com/books/feeds/volumes?q=php";





    }

}

