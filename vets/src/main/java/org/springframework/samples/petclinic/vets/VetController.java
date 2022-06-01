package org.springframework.samples.petclinic.vets;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping("/vets")
    public ResponseEntity<List<VetDTO>> getVets() {
        return new ResponseEntity<>(new ArrayList<>(vetService.allVets()), HttpStatus.OK);
    }
}
