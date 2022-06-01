package org.springframework.samples.petclinic.vets;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class SpecialtyConverter {
    public List<SpecialtyDTO> modelToDTO(List<Specialty> models){
        return models.stream()
                .map(this::modelToDTO)
                .collect(Collectors.toList());
    }
    public SpecialtyDTO modelToDTO(Specialty model){
        SpecialtyDTO dto = new SpecialtyDTO();
        BeanUtils.copyProperties(model,dto);
        return dto;
    }
}
