package com.example.coinbaselistener.repository;

import com.example.coinbaselistener.dto.InstrumentDto;

import java.util.Set;

public interface InstrumentRepository {
    void save(InstrumentDto instrument);
    Set<InstrumentDto> findAll();
}
