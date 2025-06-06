package com.challenge.mscv_challenge.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.mscv_challenge.services.SPointOfSale;
import com.challenge.mscv_challenge.model.request.PointOfSaleRequest;
import com.challenge.mscv_challenge.model.response.PointOfSaleResponse;
import com.challenge.mscv_challenge.model.response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pointOfSale")
@RequiredArgsConstructor
public class PointOfSaleController {

    private final SPointOfSale pointOfSaleService;

    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<RestResponse<Boolean>> addPointOfSale(
        @RequestBody PointOfSaleRequest pointOfSaleRequest){
            pointOfSaleService.addPoint(pointOfSaleRequest);
            return ResponseEntity.ok(new RestResponse(true));
        }

    @GetMapping(path = "/listALLPoints", produces = "application/json")
    public ResponseEntity<RestResponse<List<PointOfSaleResponse>>> getAllPoints(){
        List<PointOfSaleResponse> pointOfSaleRecords = pointOfSaleService.listAllPointOfSales();
        return ResponseEntity.ok(new RestResponse(pointOfSaleRecords));
    }

    @PostMapping(path = "/editPointOfSale/{pointId}", produces = "application/json")
    public ResponseEntity<RestResponse<Boolean>> editPointOfSale(
        @PathVariable("pointId") int pointId,
        @RequestBody PointOfSaleRequest pointOfSaleRequest
    ){
        return ResponseEntity.ok(new RestResponse<>(pointOfSaleService.editPointOfSale(pointId,pointOfSaleRequest)));
    }

    @DeleteMapping(path = "/deletePoint/{pointId}", produces = "application/json")
    public ResponseEntity<RestResponse<Boolean>> deletePointOfSale(
        @PathVariable("pointId") int point
    ){
        return ResponseEntity.ok(new RestResponse<>(pointOfSaleService.deletePointOfSaleById(point)));

    }

}