package com.CoffeeGroup.Coffee.System.features.redemption;

import com.CoffeeGroup.Coffee.System.common.Exception.EntityNotFoundException;
import com.CoffeeGroup.Coffee.System.features.benefit.BenefitEntity;
import com.CoffeeGroup.Coffee.System.features.benefit.IBenefitRepository;
import com.CoffeeGroup.Coffee.System.features.client.ClientEntity;
import com.CoffeeGroup.Coffee.System.features.client.IClientRepository;
import com.CoffeeGroup.Coffee.System.features.purchase.IPurchaseRepository;
import com.CoffeeGroup.Coffee.System.features.purchase.PurchaseEntity;
import com.CoffeeGroup.Coffee.System.features.redemption.domain.Mappers.IRedemptionCreateRequestMapper;
import com.CoffeeGroup.Coffee.System.features.redemption.domain.Mappers.IRedemptionResponseMapper;
import com.CoffeeGroup.Coffee.System.features.redemption.domain.dto.RedemptionCreateRequest;
import com.CoffeeGroup.Coffee.System.features.redemption.domain.dto.RedemptionResponse;
import com.CoffeeGroup.Coffee.System.features.redemption.domain.dto.RedemptionUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RedemptionService implements IRedemptionService {

    private final IRedemptionRepository redemptionRepository
            ;
    private final IRedemptionCreateRequestMapper createRequestIMapper;
    private final IRedemptionResponseMapper responseIMapper;

    private final IClientRepository clientRepository;
    private final IPurchaseRepository purchaseRepository;
    private final IBenefitRepository benefitRepository;

    @Override
    @Transactional
    public RedemptionResponse save(RedemptionCreateRequest redemptionCreateRequest) {
        ClientEntity clientAux = clientRepository.findByExternalId(redemptionCreateRequest.clientid()).
                orElseThrow(()-> new EntityNotFoundException("Client not found"));

        BenefitEntity benefitAux = benefitRepository.findByExternalId(redemptionCreateRequest.benefitid())
                .orElseThrow(() -> new EntityNotFoundException("Benefit not found"));
        PurchaseEntity purchaseAux= null;

        if (redemptionCreateRequest.purchaseid() != null){
            purchaseAux = purchaseRepository.findByExternalId(redemptionCreateRequest.purchaseid())
                    .orElseThrow(()-> new EntityNotFoundException("Purchase not found"));
        }
        Integer pointsCost = benefitAux.getPointsCost();
        if (clientAux.getCurrentPoints() < pointsCost){
            throw new IllegalStateException("The customer does not have enough points");
        }

        clientAux.setCurrentPoints(clientAux.getCurrentPoints() - pointsCost);
        clientRepository.save(clientAux);

        RedemptionEntity redemptionEntity = createRequestIMapper.toEntity(redemptionCreateRequest);

        redemptionEntity.setClient(clientAux);
        redemptionEntity.setBenefit(benefitAux);
        redemptionEntity.setPurchase(purchaseAux);
        redemptionEntity.setState(true);
        redemptionEntity.setDate(LocalDateTime.from(LocalDate.now()));
        redemptionEntity.setValidationCode(String.valueOf(UUID.randomUUID()));
        redemptionEntity.setUsedPoints(pointsCost);

        redemptionRepository.save(redemptionEntity);
        return responseIMapper.toDto(redemptionEntity);
    }

    @Override
    @Transactional
    public RedemptionResponse update(UUID externalId, RedemptionUpdateRequest redemptionUpdateRequest) {
        RedemptionEntity save = redemptionRepository.findByExternalId(externalId)
                .orElseThrow(()-> new EntityNotFoundException("Redemption not found"));
        save.setState(redemptionUpdateRequest.state());
        save.setExternalId(redemptionUpdateRequest.externalId());

        redemptionRepository.save(save);
        return responseIMapper.toDto(save);
    }

    @Override
    public RedemptionResponse findByid(UUID externalId) {
        return redemptionRepository.findByExternalId(externalId).map(responseIMapper::toDto)
                .orElseThrow(()-> new EntityNotFoundException("Redemption not found"));
    }

    @Override
    @Transactional
    public void deleteByid(UUID externalId) {
        RedemptionEntity redemptionEntity = redemptionRepository.findByExternalId(externalId)
                .orElseThrow(()-> new EntityNotFoundException("Redemption not found"));

        redemptionRepository.delete(redemptionEntity);
    }

    @Override
    public List<RedemptionResponse> findAll() {
        return redemptionRepository.findAll().stream().map(responseIMapper::toDto).toList();
    }
}
