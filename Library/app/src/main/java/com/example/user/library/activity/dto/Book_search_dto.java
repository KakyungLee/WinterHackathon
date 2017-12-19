package com.example.user.library.activity.dto;

import java.util.ArrayList;

/**
 * Created by mooka on 2017-12-20.
 */

public class Book_search_dto {
    public String word;
    public int page;
    public int max_page;
    public String next;
    public ArrayList<Book_dto> data=new ArrayList<Book_dto>();


}
