package com.CoffeeGroup.Coffee.System.features.redemption;

import com.CoffeeGroup.Coffee.System.features.redemption.domain.dto.RedemptionCreateRequest;
import com.CoffeeGroup.Coffee.System.features.redemption.domain.dto.RedemptionResponse;
import com.CoffeeGroup.Coffee.System.features.redemption.domain.dto.RedemptionUpdateRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/redemption")
public class RedemptionController {

    private final IRedemptionService redemptionService;

    @PostMapping("/create")
    ResponseEntity<RedemptionResponse> createRedemption(@Valid @RequestBody RedemptionCreateRequest redemptionCreateRequest){
        return new ResponseEntity<>(redemptionService.save(redemptionCreateRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RedemptionResponse>> findAll() {
        return ResponseEntity.ok(redemptionService.findAll());
    }

    @PutMapping("/{redemtionId}")
    ResponseEntity<RedemptionResponse> update(@PathVariable UUID externalId, @RequestBody RedemptionUpdateRequest redemptionUpdateRequest) {
        return ResponseEntity.ok(redemptionService.update(externalId, redemptionUpdateRequest));
    }

    @DeleteMapping("/{redemtionId}")
    ResponseEntity<Void> delete(@PathVariable UUID exteralId) {
        redemptionService.deleteByid(exteralId);
        return ResponseEntity.noContent().build();
    }


}
