package com.example.lenovo.sama.presenter;

import android.content.Context;

import com.example.lenovo.sama.Model.tripsModel;
import com.example.lenovo.sama.interfaces.MVP;

import java.util.ArrayList;

public class tripPresenter implements MVP.interfaces.presenter {
    private MVP.interfaces.Model model;
    private MVP.interfaces.View views;
    Context context;


    public tripPresenter(MVP.interfaces.View view,Context context) {
        this.views = view;
        this.context=context;
        initPresenter();
    }
    private void initPresenter() {
        model = new tripsModel(context);
        views.element();
    }


    @Override
    public void getData() {
        ArrayList<tripsModel>mylist=model.getdata();
        views.setviewdata(mylist);
    }
}
