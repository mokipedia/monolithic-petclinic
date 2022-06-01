package org.springframework.samples.petclinic.vets;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class VetService {
    private final VetRepository vets;
    private final VetConverter converter;

    public VetService(VetRepository vets, VetConverter converter) {
        this.vets = vets;
        this.converter = converter;
    }

    public Collection<VetDTO> allVets() {
        return this.converter.modelToDTO(
                new ArrayList<>(this.vets.findAll())
        );
    }
}
