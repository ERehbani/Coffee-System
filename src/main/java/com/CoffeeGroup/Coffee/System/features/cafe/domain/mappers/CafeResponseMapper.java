package com.CoffeeGroup.Coffee.System.features.cafe.domain.mappers;

import com.CoffeeGroup.Coffee.System.common.Model.IMapper;
import com.CoffeeGroup.Coffee.System.features.cafe.CafeEntity;
import com.CoffeeGroup.Coffee.System.features.cafe.domain.dto.CafeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "sprint")
public interface CafeResponseMapper extends IMapper<CafeEntity, CafeResponse> {
    CafeEntity toEnity(CafeResponse cafeResponse);
    CafeResponse toDto(CafeEntity cafeEntity);

}
