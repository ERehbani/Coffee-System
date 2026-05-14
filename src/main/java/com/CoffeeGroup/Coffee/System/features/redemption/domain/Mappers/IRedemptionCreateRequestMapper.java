package com.CoffeeGroup.Coffee.System.features.redemption.domain.Mappers;

import com.CoffeeGroup.Coffee.System.common.Model.IMapper;
import com.CoffeeGroup.Coffee.System.features.redemption.RedemptionEntity;
import com.CoffeeGroup.Coffee.System.features.redemption.domain.dto.RedemptionCreateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRedemptionCreateRequestMapper extends IMapper<RedemptionEntity, RedemptionCreateRequest> {
    RedemptionEntity toEntity(RedemptionCreateRequest redemptionCreateRequest);
    RedemptionCreateRequest toDto(RedemptionEntity redemptionEntity);
}
