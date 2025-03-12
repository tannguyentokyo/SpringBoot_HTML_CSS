package com.example.crudexample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final List<Product> products;

  public ProductController() {
    this.products = new ArrayList<>();
    this.products.add(new Product("1", "Product 1", 100.0));
    this.products.add(new Product("2", "Product 2", 200.0));
    this.products.add(new Product("3", "Product 3", 300.0));
  }

  @GetMapping
  public ResponseEntity<List<Product>> getProducts() {
    // Kiểm tra nếu không có sản phẩm nào thì trả về status code 404
    if (products.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(products);
    }

    // Ngược lai, trả về status code 200 và danh sách sản phẩm
    return ResponseEntity.status(HttpStatus.OK).body(products);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getProductById(@PathVariable String id) {
    // Tìm kiếm sản phẩm theo id
    // Cách 1: Sử dụng vòng lặp
    //    Product product = null;
    //    for (Product p : products) {
    //      if (p.getId().equals(id)) {
    //        product = p;
    //        break;
    //      }
    //    }

    // Cách 2: Sử dụng Stream API
    Product product = products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);

    // Kiểm tra nếu không tìm thấy sản phẩm thì trả về status code 404G
    if (product == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }

    // Ngược lai, trả về status code 200 và sản phẩm tìm thấy
    return ResponseEntity.status(HttpStatus.OK).body(product);
  }

  @PostMapping
  public ResponseEntity<String> createProduct(@RequestBody Product product) {
    // Kiểm tra nếu sản phẩm đã tồn tại thì trả về status code 400
    // Cách 1: Sử dụng vòng lặp
    //    for (Product p : products) {
    //      // Phát hiện sản phẩm đã tồn tại => trả về status code 400 và thông báo lỗi
    //      if (p.getId().equals(product.getId())) {
    //        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product already exists");
    //      }
    //    }

    // Cách 2: Sử dụng Stream API
    if (products.stream().anyMatch(p -> p.getId().equals(product.getId()))) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product already exists");
    }

    // Tạo mới sản phẩm và thêm vào danh sách
    products.add(product);

    // Trả về status code 201 và sản phẩm vừa tạo
    return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateProduct(@PathVariable String id,
      @RequestBody Product product) {
    // Tìm kiếm sản phẩm theo id
    // Cách 1: Sử dụng vòng lặp
    //    Product existingProduct = null;
    //    for (Product p : products) {
    //      if (p.getId().equals(id)) {
    //        existingProduct = p;
    //        break;
    //      }
    //    }

    // Cách 2: Sử dụng Stream API
    Product existingProduct =
        products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);

    // Kiểm tra nếu không tìm thấy sản phẩm thì trả về status code 404
    if (existingProduct == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }

    // Cập nhật thông tin sản phẩm
    existingProduct.setName(product.getName());
    existingProduct.setPrice(product.getPrice());

    // Trả về status code 200 và thông báo cập nhật thành công
    return ResponseEntity.status(HttpStatus.OK).body("Product updated successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteProduct(@PathVariable String id) {
    // Tìm kiếm sản phẩm theo id
    // Cách 1: Sử dụng vòng lặp
    //    Product product = null;
    //    for (Product p : products) {
    //      if (p.getId().equals(id)) {
    //        product = p;
    //        break;
    //      }
    //    }

    // Cách 2: Sử dụng Stream API
    Product product = products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);

    // Kiểm tra nếu không tìm thấy sản phẩm thì trả về status code 404
    if (product == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }

    // Xóa sản phẩm khỏi danh sách
    products.remove(product);

    // Trả về status code 200 và thông báo xóa thành công
    return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
  }
}
