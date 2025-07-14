package com.example.produtos.Controller;

import com.example.produtos.dto.ProductDTO;
import com.example.produtos.pagination.PageResponse;
import com.example.produtos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    public PageResponse<ProductDTO> list(Pageable pageable){
        return service.list(pageable);
    }
}
