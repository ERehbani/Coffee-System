package com.CoffeeGroup.Coffee.System.features.category;

import com.CoffeeGroup.Coffee.System.common.exceptions.EntityNotFoundException;
import com.CoffeeGroup.Coffee.System.common.model.IMapper;
import com.CoffeeGroup.Coffee.System.features.category.domain.dto.CategoryRequest;
import com.CoffeeGroup.Coffee.System.features.category.domain.dto.CategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;
    private final IMapper<CategoryEntity, CategoryResponse> responseMapper;

    public List<CategoryResponse> getAllCategories(){
        return categoryRepository
                .findAll()
                .stream()
                .map(responseMapper::toDto)
                .toList();
    }

    public CategoryResponse getCategoryById(UUID categoryId){
        return categoryRepository.findById(categoryId)
                .map(responseMapper::toDto)
                .orElseThrow(() ->
                        new EntityNotFoundException("Category", "Category was not found", "categoryId", categoryId.toString()
                ));
    }

    public CategoryResponse save(CategoryRequest categoryRequest){
        CategoryEntity entity = CategoryEntity.builder()
                .externalId(UUID.randomUUID())
                .name(categoryRequest.name())
                .build();
        return responseMapper.toDto(categoryRepository.save(entity));
    }

    public List<CategoryResponse> searchByName(String name) {
        return categoryRepository
                .findByNameContainingIgnoreCase(name)
                .stream()
                .map(responseMapper::toDto)
                .toList();
    }

}
