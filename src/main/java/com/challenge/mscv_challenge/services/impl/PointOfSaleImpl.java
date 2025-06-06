package com.challenge.mscv_challenge.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.challenge.mscv_challenge.model.entity.PointOfSale;
import com.challenge.mscv_challenge.model.request.PointOfSaleRequest;
import com.challenge.mscv_challenge.model.response.PointOfSaleResponse;
import com.challenge.mscv_challenge.repository.PointOfSaleRepository;
import com.challenge.mscv_challenge.services.SPointOfSale;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PointOfSaleImpl implements SPointOfSale {

    private PointOfSaleRepository repository;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void addPoint(PointOfSaleRequest pointOfSale) {
        repository.addPoint(PointOfSale.builder()
        .id(atomicInteger.incrementAndGet())
        .nombre(pointOfSale.getNombre())
        .build());
    }

    @Override
    public List<PointOfSaleResponse> listAllPointOfSales() {
       List<PointOfSale> pointOfSales = Optional.ofNullable(repository.listAllPointOfSales())
       .orElseThrow(() -> new RuntimeException("No se encontraron puntos de venta"));
       return pointOfSales.stream().map(point -> { 
        return new PointOfSaleResponse(point.getId()
        ,point.getNombre());
    }).toList();
    }

    @Override
    public boolean editPointOfSale(int id, PointOfSaleRequest pointOfSaleRecord) {
        PointOfSale pointOfSale = findPointOfSaleById(id);
        return repository.editPointOfSale(id, pointOfSale);
    }

    @Override
    public boolean deletePointOfSaleById(int id) {
        return repository.deletePointOfSaleById(id);
    }

    private PointOfSale findPointOfSaleById(int id){
        return repository.findPointOfSaleById(id)
        .orElseThrow(()-> new RuntimeException("no se encontró punto de venta para editar"));
    }
    
}
