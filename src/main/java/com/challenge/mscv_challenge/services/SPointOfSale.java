package com.challenge.mscv_challenge.services;

import java.util.List;

import com.challenge.mscv_challenge.model.request.PointOfSaleRequest;
import com.challenge.mscv_challenge.model.response.PointOfSaleResponse;


public interface SPointOfSale {

    void addPoint(PointOfSaleRequest pointOfSale);
    List<PointOfSaleResponse> listAllPointOfSales();
    boolean editPointOfSale(int id, PointOfSaleRequest pointOfSale);
    boolean deletePointOfSaleById(int id);

}
