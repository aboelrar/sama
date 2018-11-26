package com.example.lenovo.sama;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by admin on 02/05/2018.
 */

public class expand extends ExpandableGroup {
    int id;
    String title;
    int img;

    public expand(String title, List items,int img) {
        super(title, items);
        this.img=img;
    }


}
