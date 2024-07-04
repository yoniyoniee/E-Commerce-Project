package com.example.ecommerce.product.controller;

import com.example.ecommerce.balance.dto.BalancesHistoryRequestDTO;
import com.example.ecommerce.balance.dto.BalancesHistoryResponseDTO;
import com.example.ecommerce.balance.entity.BalancesHistory;
import com.example.ecommerce.product.dto.ProductsRequestDto;
import com.example.ecommerce.product.dto.ProductsResonseDto;
import com.example.ecommerce.product.entity.Products;
import com.example.ecommerce.product.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/api/products-list")
    public ResponseEntity<List<ProductsResonseDto>> getProductsList() {
        List<ProductsResonseDto> products = productsService.getAllProducts();
        List<ProductsResonseDto> productsResonseDtos = products.stream()
                .map(product -> new ProductsResonseDto(
                        product.getProductCode(),
                        product.getSeq(),
                        product.getProductName(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getStock()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(productsResonseDtos);
    }

//    @PostMapping("/api/balance/{userId}/charge")
//    public ResponseEntity<BalancesHistoryResponseDTO> addBalanceHistory(@PathVariable String userId, @RequestBody BalancesHistoryRequestDTO request) {
//        request.setUserId(userId);
//        BalancesHistory savedHistory = balancesService.addBalanceHistory(request.toEntity());
//        BalancesHistoryResponseDTO response = new BalancesHistoryResponseDTO(savedHistory);
//        return ResponseEntity.ok(response);
//    }
    @PostMapping("/api/register-product")
    public ResponseEntity<ProductsResonseDto> registerProduct(@RequestBody ProductsRequestDto request) {
        Products newProduct = productsService.registerProduct(request.toEntity());
        ProductsResonseDto resonseDto = new ProductsResonseDto(newProduct);
        return ResponseEntity.ok(resonseDto);
    }

}
