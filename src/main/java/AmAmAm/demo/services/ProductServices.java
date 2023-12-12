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
        products.add(new Product(++ID,"2114", "ласточка", 20000, "Екатеринбург", "Я"));
        products.add(new Product(++ID,"2113", "ласточка", 25000, "Екатеринбург", "Я"));
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
