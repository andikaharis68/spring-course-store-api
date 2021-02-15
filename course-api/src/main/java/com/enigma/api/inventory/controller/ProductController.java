package com.enigma.api.inventory.controller;

import com.enigma.api.inventory.entities.Category;
import com.enigma.api.inventory.entities.Product;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.models.*;
import com.enigma.api.inventory.models.product.ProductElement;
import com.enigma.api.inventory.models.product.ProductRequest;
import com.enigma.api.inventory.models.product.ProductResponse;
import com.enigma.api.inventory.models.product.ProductSearch;
import com.enigma.api.inventory.services.FileService;
import com.enigma.api.inventory.services.ProductService;
import com.enigma.api.inventory.services.categoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private categoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponsMessage<Object> add(@Valid @RequestBody ProductRequest model) {
        Product entity = modelMapper.map(model, Product.class);
        Category category = categoryService.findById(model.getCategoryId());
        entity.setCategory(category);
        entity = productService.save(entity);
        ProductResponse data = modelMapper.map(entity, ProductResponse.class);
        return ResponsMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponsMessage<Object> edit(@PathVariable Integer id, @RequestBody ProductRequest model) {
        Product entity = productService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        Category category = categoryService.findById(model.getCategoryId());
        entity.setCategory(category);
        modelMapper.map(model, entity);
        entity = productService.save(entity);
        ProductResponse data = modelMapper.map(entity, ProductResponse.class);
        return ResponsMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponsMessage<Object> removeById(@PathVariable Integer id) {
        Product entity = productService.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return ResponsMessage.success(entity);
    }

    @GetMapping("/{id}")
    public ResponsMessage<Object> findById(@PathVariable Integer id) {
        Product entity = productService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return ResponsMessage.success(entity);
    }

    @GetMapping()
    public ResponsMessage<PagedList<ProductElement>> findAll(@Valid ProductSearch model) {
        Product search = modelMapper.map(model, Product.class);
        Page<Product> entityPage = productService.findAll(search, model.getPage(), model.getSize(), model.getSort());
        List<Product> entities = entityPage.toList();
        List<ProductElement> models = entities.stream()
                .map(e -> modelMapper.map(e, ProductElement.class))
                .collect(Collectors.toList());
        PagedList<ProductElement> data = new PagedList<>(models, entityPage.getNumber(), entityPage.getSize(), entityPage.getTotalElements());
        return ResponsMessage.success(data);
    }

    @PostMapping(value = "/{id}/image", consumes = "multipart/form-data")
    public ResponsMessage<Object> upload(@PathVariable Integer id, @Valid ImageUploadRequest model) throws IOException {
        Product entity = productService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        fileService.upload(entity, model.getFile().getInputStream());
        return ResponsMessage.success(true);
    }

    @GetMapping("/{id}/image")
    public void download(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        Product entity = productService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" + entity.getId() + "\"");
        fileService.download(entity, response.getOutputStream());
    }

    @GetMapping("/count")
    public ResponsMessage countProduct() {
        Integer entity = productService.countProduct();
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return ResponsMessage.success(entity);
    }
    @GetMapping("/average")
    public ResponsMessage averageProduct() {
        Integer entity = productService.averageProduct();
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return ResponsMessage.success(entity);
    }
}















