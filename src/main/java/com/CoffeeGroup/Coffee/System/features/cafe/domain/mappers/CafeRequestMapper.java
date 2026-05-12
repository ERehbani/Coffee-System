package com.CoffeeGroup.Coffee.System.features.cafe.domain.mappers;

import com.CoffeeGroup.Coffee.System.common.Model.IMapper;
import com.CoffeeGroup.Coffee.System.features.cafe.CafeEntity;
import com.CoffeeGroup.Coffee.System.features.cafe.domain.dto.CafeRequest;
import com.CoffeeGroup.Coffee.System.features.cafe.domain.dto.CafeResponse;

public interface CafeRequestMapper extends IMapper<CafeEntity, CafeRequest> {
    CafeEntity toEnity(CafeRequest cafeRequest);
    CafeRequest toDto(CafeEntity cafeEntity);
}
