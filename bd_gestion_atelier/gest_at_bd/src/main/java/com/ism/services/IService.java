package com.ism.services;

import java.util.ArrayList;


public interface IService<N> {
    int add(N data);
    ArrayList<N>getAll();
    int update(N data);
    N show(int id);
    int remove(int id);
    int[]  remove (int[] ids);
}
