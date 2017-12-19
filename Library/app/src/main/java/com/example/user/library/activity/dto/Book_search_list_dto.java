package com.example.user.library.activity.dto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mooka on 2017-12-20.
 */

public class Book_search_list_dto {
    public String word;
    public String page;
    public String max_page;
    public String next;
    public ArrayList<Book_dto> data=new ArrayList<Book_dto>();


}
