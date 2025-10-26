package com.epf.marmitax.DTO;

import com.epf.marmitax.models.ApprovalStatus;
import lombok.Builder;

import java.util.List;

@Builder
public record RecetteDto(
    Long idRecetteDto,
    String nomRecetteDto,
    List<IngredientDetailsDto> ingredientsDto,
    List<UstensileDto> ustensilesDto,
    Integer dureeRecetteDto,
    Integer difficulteRecetteDto,
    Integer prixRecetteDto,
    String imageRecetteDto,
    String contenuRecetteDto,
    ApprovalStatus approvalStatus
){}
