package AmAmAm.demo.services;

import AmAmAm.demo.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;
    {
        products.add(new Product(++ID,"2114", "ласточка1", 20000, "Екатеринбург", "Я","https://a.d-cd.net/SqAAAgA4muA-1920.jpg"));
        products.add(new Product(++ID,"2113", "ласточка2", 25000, "Екатеринбург", "Я","https://versiya.info/uploads/posts/2020-02/1581959833_ddaa699s-1920.jpg"));
        products.add(new Product(++ID,"2114", "ласточка3", 20000, "Екатеринбург", "Я","https://a.d-cd.net/e307ges-1920.jpg"));
        products.add(new Product(++ID,"2113", "ласточка4", 25000, "Екатеринбург", "Я","https://a.d-cd.net/QYAAAgOzGuA-1920.jpg"));
    }

    public List<Product> list(){return products;}

    public void saveProduct(Product product){
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products){
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
