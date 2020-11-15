package com.example.coinbaselistener.service;

import com.example.coinbaselistener.dto.InstrumentDto;
import com.example.coinbaselistener.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class InstrumentServiceImpl implements InstrumentCrudService {

    @Autowired
    InstrumentRepository repository;

    public void saveInstrument(InstrumentDto instrument){
        repository.save(instrument);
    }

    public Set<InstrumentDto> getAll(){
        return repository.findAll();
    }

}
