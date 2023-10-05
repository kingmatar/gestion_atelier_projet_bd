package com.ism.repository.list;

import java.util.ArrayList;

import com.ism.entities.AbstractEntity;
import com.ism.repository.ITables;

public class AbstractTable<pro extends AbstractEntity> implements ITables<pro>{
    private ArrayList<pro> tables= new ArrayList<>();

    @Override
    public int insert(pro data) {
        tables.add(data);
        return 1;
    }

    @Override
    public int update(pro data) {
        int pos = indexOf(data.getId());
        if(pos!=-1){
            tables.set(pos,data);
            return 1;
        }
        return 0;
    }

    @Override
    public ArrayList<pro> findAll() {
        return tables;
    }

    @Override
    public pro findById(int id) {
        int pos = indexOf(id);
         if(pos!=-1){
            return tables.get(pos);
         }
         return null;
    }

    @Override
    public int delete(int id) {
        int pos=indexOf(id);
        if(pos!=-1){
            tables.remove(pos);
            return 1;
        }
        return 0;
    }

    @Override
    public int indexOf(int id) {
        int pos=0;
        for (pro cat : tables){
            if(cat.getId()==id){
                return pos;
            }   
        }
        return -1;
    }
    
}
