package org.springframework.samples.petclinic.vets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ConditionalOnProperty(havingValue = "monolith",prefix = "vetservice",name = "name")
@Service
public class VetServiceImpl implements VetService {
    private final VetRepository vets;
    private final VetConverter converter;

    public VetServiceImpl(VetRepository vets, VetConverter converter) {
        this.vets = vets;
        this.converter = converter;
    }

    @Override
    public Collection<VetDTO> allVets() {
        System.out.println("--------------------------------------------------");
        System.out.println("IMPL");
        System.out.println("--------------------------------------------------");
        return this.converter.modelToDTO(
                new ArrayList<>(this.vets.findAll())
        );
    }

}
