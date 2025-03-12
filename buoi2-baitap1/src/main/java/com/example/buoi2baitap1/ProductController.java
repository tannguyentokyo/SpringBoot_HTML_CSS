package com.example.buoi2baitap1;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Bài 1: Restful API:
//        -	Yêu cầu: Tạo các API liên quan tới sản phẩm gồm có các field (id, name, quantity, price). Vì chưa có DB nên cần tạo 1 List product và các request mapping sẽ thao tác với nó
//
//-	Các http request:
//        -	GET /api/products → Trả về danh sách sản phẩm dưới dạng JSON.
//-	GET /api/products/{id} → Trả về thông tin sản phẩm theo id.
//        -	POST /api/products → Thêm sản phẩm mới (Dữ liệu từ body JSON).
//        -	PUT /api/products/{id} → Update sản phẩm theo id
//-	DELETE /api/products/{id} → Xóa sản phẩm theo id.
//
//-	Yêu cầu thêm:
//        -	Sử dụng ResponseEntity để trả về dữ liệu JSON.
//-	Khi sản phẩm không tồn tại, trả về 404 Not Found.

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private List<Product> listProduct = new ArrayList<Product>();

    public ProductController() {               //contructor để khởi tạo giá trị của object từ đầu, sẽ chạy đầu tiên khi class này chạy và không cần return về 
        listProduct.add(new Product("SP001", "ABC", "good", "1200"));
        listProduct.add(new Product("SP002", "ABC", "good", "1800"));
        listProduct.add(new Product("SP003", "ABC", "low", "1000"));
        listProduct.add(new Product("SP004", "ABC", "good", "1500"));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("check status", "OK");

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(listProduct);
    }

    @PostMapping
    public ResponseEntity<List<Product>> createProduct(@RequestBody Product product) {
        listProduct.add(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(listProduct);
    }

    @PutMapping("/{idabc}")
    public ResponseEntity<String> updateProduct(@PathVariable("idabc") String id, @RequestBody Product product) { //pathvariable sẽ lấy giá trị của endpoint và truyền vào biến phía sau

        int check = 0;
        for (Product i : listProduct) {
            if (i.getId().equals(id)) {
                check = 1;
                i.setName(product.getName());
                i.setQuantity(product.getQuantity());
                i.setPrice(product.getPrice());
                break;
            }
        }

        if (check == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("mã sản phẩm: " + id + " ko tồn tại");
        }
        return ResponseEntity.status(HttpStatus.OK).body("đã sửa mã sản phẩm: " + id + " thành công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String id) {

        int check = 0;
        for (Product i : listProduct) {
            if (i.getId().equals(id)) {
                check = 1;
                listProduct.remove(i);
                break;
            }
        }

        if (check == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("mã sản phẩm: " + id + " ko tồn tại");
        }
        return ResponseEntity.status(HttpStatus.OK).body("đã xóa mã sản phẩm: " + id + " thành công");
    }

}
