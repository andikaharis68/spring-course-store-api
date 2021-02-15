package com.enigma.api.inventory.configs;

import com.enigma.api.inventory.entities.Category;
import com.enigma.api.inventory.models.category.CategoryModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.typeMap(CategoryModel.class, Category.class).addMappings(mapper -> {
            mapper.skip(com.enigma.api.inventory.entities.Category::setId);
        });
        return modelMapper;
    }
}
