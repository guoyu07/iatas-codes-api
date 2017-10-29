package com.github.pablocloud.iataapi.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pablocloud.iataapi.domain.Iata;
import com.github.pablocloud.iataapi.repositories.IataRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

@Component
class IataInflater {

    private final IataRepository iataRepository;

    public IataInflater(IataRepository iataRepository) {
        this.iataRepository = iataRepository;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @PostConstruct
    void init() {
        InputStream resourceAsStream = getClass().getResourceAsStream("/airports.json");
        try {
            ArrayList<HashMap> list = new ObjectMapper().readValue(resourceAsStream, ArrayList.class);
            list.forEach(o -> {
                try {
                    Iata iata = new Iata();
                    if (o.containsKey("iata")) {
                        iata.setCode(o.get("iata").toString());
                    }
                    if (o.containsKey("name")) {
                        iata.setName(o.get("name").toString());
                    }
                    if (o.containsKey("type")) {
                        iata.setType(o.get("type").toString());
                    }
                    if (o.containsKey("continent")) {
                        iata.setCountry(o.get("continent").toString());
                    }
                    iataRepository.save(iata);
                } catch (Exception ex) {
                    System.out.println(o);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
