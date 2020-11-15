package com.example.coinbaselistener.api;

import com.example.coinbaselistener.dto.InstrumentDto;
import com.example.coinbaselistener.service.InstrumentCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class InstrumentController {

    @Autowired
    InstrumentCrudService service;

    @GetMapping("api/prices")
    public ResponseEntity getPrices(){
        Set<InstrumentDto> instruments = service.getAll();
        return ResponseEntity.ok(instruments);
    }

}
