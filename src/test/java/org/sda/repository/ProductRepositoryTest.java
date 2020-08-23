package org.sda.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sda.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({SpringExtension.class})
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Test product not found with not-existing ID")
    public void testProductNotFoundWithNotExistingId() throws IOException {
        //Given
        File dataJson = Paths.get("src", "test", "resources", "products.json").toFile();
        Product[] products = new ObjectMapper().readValue(dataJson, Product[].class);

        Arrays.stream(products).forEach(productRepository::save);

        //When
        Product obtainedProduct = productRepository.findProductById(10000L);

        //Then
        Assertions.assertNull(obtainedProduct);
    }

}
