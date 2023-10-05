package com.ism.repository;
import java.util.ArrayList;
import com.ism.entities.AbstractEntity;

public interface ITables<T extends AbstractEntity>{
   int insert (T data) ;
   int update (T data);
   ArrayList<T>findAll ();
   T findById (int id);
   int delete (int id);
   int indexOf(int id);
}

