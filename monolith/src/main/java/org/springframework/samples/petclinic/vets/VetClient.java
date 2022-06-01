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


@ConditionalOnProperty(havingValue = "microservice",prefix = "vetservice",name = "name",matchIfMissing = true)
@Service
public class VetClient implements VetService {

    @Override
    public Collection<VetDTO> allVets() {
        String url = "http://localhost:8081/vets";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println("--------------------------------------------------");
            System.out.println("CLIENT");
            System.out.println("--------------------------------------------------");
            return objectMapper.readValue(response.getBody(),new TypeReference<List<VetDTO>>() { });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
