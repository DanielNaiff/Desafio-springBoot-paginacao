package com.example.produtos.service;

import com.example.produtos.dto.ProductDTO;
import com.example.produtos.pagination.PageResponse;
import com.example.produtos.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductRepository repository;

    public PageResponse<ProductDTO> list(Pageable pageable){
        Pageable safe = PageRequest.of(
                pageable.getPageNumber(),
                Math.min(pageable.getPageSize(), 100)
                );

        return PageResponse.of(repository.findAll(safe).map(ProductDTO::from ));
    }
}
