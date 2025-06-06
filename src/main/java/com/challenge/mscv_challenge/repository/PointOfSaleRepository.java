package com.challenge.mscv_challenge.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.challenge.mscv_challenge.model.entity.PointOfSale;

import java.util.List;
import java.util.Optional;

@Repository
public class PointOfSaleRepository {

    @Autowired
    private List<PointOfSale> pointOfSaleList;

    public void addPoint(PointOfSale pointOfSale){
     this.pointOfSaleList.add(pointOfSale);
    };

    public List<PointOfSale> listAllPointOfSales(){
    return this.pointOfSaleList;
    }

    public boolean editPointOfSale (int id, PointOfSale pointOfSale){
        for(int i = 0; i<pointOfSaleList.size(); i ++){
            if(pointOfSaleList.get(i).getId() == 0){
                pointOfSaleList.set(i, pointOfSale);
                return true;

            }
        };
        return false;
        }

    public boolean deletePointOfSaleById(int id){
       return pointOfSaleList.removeIf(point -> point.getId() == id);
    }
    public Optional<PointOfSale> findPointOfSaleById(int id){
        return Optional.ofNullable(pointOfSaleList.stream()
        .filter(point -> point.getId() == id).findFirst().get());
    }

    }


