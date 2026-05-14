package com.CoffeeGroup.Coffee.System.features.category;

import com.CoffeeGroup.Coffee.System.features.category.domain.dto.CategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> getCategoryById(@RequestParam UUID categoryId){
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

}
