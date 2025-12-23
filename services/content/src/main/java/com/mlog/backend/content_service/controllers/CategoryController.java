package com.mlog.backend.content_service.controllers;

import com.mlog.backend.content_service.dtos.responses.CategoryResponse;
import com.mlog.backend.content_service.entities.Category;
import com.mlog.backend.content_service.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.getAllCategories().stream().map(cat -> CategoryResponse.builder()
                .id(cat.getId())
                .name(cat.getName())
                .description(cat.getDescription())
                .createdAt(cat.getCreatedAt())
                .updatedAt(cat.getUpdatedAt())
                .createdBy(cat.getCreatedBy())
                .updatedBy(cat.getUpdatedBy())
                .build()).collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id).map(cat -> ResponseEntity.ok(CategoryResponse.builder()
                .id(cat.getId())
                .name(cat.getName())
                .description(cat.getDescription())
                .createdAt(cat.getCreatedAt())
                .updatedAt(cat.getUpdatedAt())
                .createdBy(cat.getCreatedBy())
                .updatedBy(cat.getUpdatedBy())
                .build())).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody Category category) {
        Category created = categoryService.createCategory(category);
        CategoryResponse response = CategoryResponse.builder()
                .id(created.getId())
                .name(created.getName())
                .description(created.getDescription())
                .createdAt(created.getCreatedAt())
                .updatedAt(created.getUpdatedAt())
                .createdBy(created.getCreatedBy())
                .updatedBy(created.getUpdatedBy())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        try {
            Category updated = categoryService.updateCategory(id, category);
            CategoryResponse response = CategoryResponse.builder()
                    .id(updated.getId())
                    .name(updated.getName())
                    .description(updated.getDescription())
                    .createdAt(updated.getCreatedAt())
                    .updatedAt(updated.getUpdatedAt())
                    .createdBy(updated.getCreatedBy())
                    .updatedBy(updated.getUpdatedBy())
                    .build();
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
