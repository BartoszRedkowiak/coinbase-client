package com.example.coinbaselistener.repository;

import com.example.coinbaselistener.constant.Instrument;
import com.example.coinbaselistener.dto.InstrumentDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class InMemoryInstrumentRepository implements InstrumentRepository {

    private Map<Instrument, InstrumentDto> repo = new HashMap<>();

    @Override
    public void save(InstrumentDto instrument) {
        repo.put(instrument.getInstrument(), instrument);
    }

    @Override
    public Set<InstrumentDto> findAll() {
        return repo.values().stream().collect(Collectors.toSet());
    }
}
