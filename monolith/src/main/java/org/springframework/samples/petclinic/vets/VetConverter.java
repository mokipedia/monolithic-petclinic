package org.springframework.samples.petclinic.vets;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VetConverter {

    private SpecialtyConverter specialtyConverter;

    public VetConverter(SpecialtyConverter specialtyConverter){
        this.specialtyConverter = specialtyConverter;
    }

    public List<VetDTO> modelToDTO(List<Vet> models){
        return models.stream()
                .map(this::modelToDTO)
                .collect(Collectors.toList());
    }
    public VetDTO modelToDTO(Vet model){
        VetDTO dto = new VetDTO();
        BeanUtils.copyProperties(model,dto);
        dto.setSpecialties(specialtyConverter.modelToDTO(model.getSpecialties()));
        return dto;
    }


}
