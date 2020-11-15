package com.example.coinbaselistener.service;

import com.example.coinbaselistener.dto.InstrumentDto;

import java.util.Set;

public interface InstrumentCrudService {

    public void saveInstrument(InstrumentDto instrument);
    public Set<InstrumentDto> getAll();
}
