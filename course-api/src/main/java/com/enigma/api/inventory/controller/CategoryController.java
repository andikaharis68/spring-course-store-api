package com.enigma.api.inventory.controller;


import com.enigma.api.inventory.entities.Category;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.models.PagedList;
import com.enigma.api.inventory.models.ResponsMessage;
import com.enigma.api.inventory.models.category.CategoryModel;
import com.enigma.api.inventory.models.category.CategorySearch;
import com.enigma.api.inventory.services.categoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    private categoryService service;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponsMessage<CategoryModel> add(@RequestBody CategoryModel model) {
        Category entity = modelMapper.map(model, Category.class);
        entity = service.save(entity);
        CategoryModel data = modelMapper.map(entity, CategoryModel.class);
        return ResponsMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponsMessage edit(@PathVariable Integer id, @RequestBody CategoryModel model) {
        Category entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        modelMapper.map(model, entity);
        entity = service.save(entity);
        CategoryModel data = modelMapper.map(entity, CategoryModel.class);
        return ResponsMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponsMessage<Object> removeById(@PathVariable Integer id) {
        Category entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return ResponsMessage.success(entity);
    }

    @GetMapping("/{id}")
    public ResponsMessage<Object> findById(@PathVariable Integer id) {
        Category entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return ResponsMessage.success(entity);
    }

    @GetMapping()
    public ResponsMessage<PagedList<CategoryModel>> findAll(@Valid CategorySearch model) {
        Category search = modelMapper.map(model, Category.class);
        Page<Category> entityPage = service.findAll(search, model.getPage(), model.getSize(), model.getSort());
        List<Category> entities = entityPage.toList();
        List<CategoryModel> models = entities.stream()
                .map(e -> modelMapper.map(e, CategoryModel.class))
                .collect(Collectors.toList());
        PagedList<CategoryModel> data = new PagedList<>(models, entityPage.getNumber(), entityPage.getSize(), entityPage.getTotalElements());
        return ResponsMessage.success(data);
    }

    @GetMapping("/count")
    public ResponsMessage countCategory() {
        Integer entity = service.countCategory();
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return ResponsMessage.success(entity);
    }
}
















