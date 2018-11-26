package com.example.lenovo.sama.interfaces;

import android.content.Context;

import java.util.ArrayList;

public interface MVP {
    public interface interfaces {
        interface  View
        {
            void element();
            void setviewdata(ArrayList data);
        }
        interface Model{
            ArrayList getdata();
        }
        interface presenter{
            void getData();
        }

    }
}
