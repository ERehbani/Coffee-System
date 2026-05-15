package com.CoffeeGroup.Coffee.System.features.redemption.domain.Mappers;

import com.CoffeeGroup.Coffee.System.common.Model.IMapper;
import com.CoffeeGroup.Coffee.System.features.redemption.RedemptionEntity;
import com.CoffeeGroup.Coffee.System.features.redemption.domain.dto.RedemptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IRedemptionResponseMapper extends IMapper<RedemptionEntity, RedemptionResponse> {


    RedemptionEntity toEntity(RedemptionResponse redemptionResponse);
    RedemptionResponse toDto(RedemptionEntity redemptionEntity);
}
