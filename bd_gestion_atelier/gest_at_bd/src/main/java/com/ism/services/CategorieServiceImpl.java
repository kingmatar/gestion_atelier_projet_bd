package com.ism.services;

import java.util.ArrayList;

import com.ism.entities.Categorie;
import com.ism.repository.ITables;

public class CategorieServiceImpl implements CategorieService {

    //Couplage fort
    //private TableCategories categoriesRepository=new TableCategories();

    //couplage faible
    private ITables<Categorie> categoriesRepository;

    //injection de dependance via le constructeur
    public CategorieServiceImpl(ITables<Categorie> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    // injection de dependance via le setter
    public void setCategoriesRepository(ITables<Categorie> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }


    @Override
    public int add(Categorie categorie) {
       return categoriesRepository.insert(categorie);
    }

    @Override
    public ArrayList<Categorie> getAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public int update(Categorie categorie) {
         return categoriesRepository.update(categorie);
       
    }

    @Override
    public Categorie show(int id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public int remove(int id) {
       return categoriesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
          for (int id = 0; id < ids.length; id++) {
              if (categoriesRepository.delete(id)==0) {
                idsNotDelete[nbre++]=id;

              }
          }
          return idsNotDelete;
    }
    
}
