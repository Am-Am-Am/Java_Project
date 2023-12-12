package AmAmAm.demo.controllers;


import AmAmAm.demo.models.Product;
import AmAmAm.demo.services.ProductServices;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
//@RequestMapping
public class ProductController {

    private final ProductServices productService;

    @GetMapping("/")
    public String products(Model model){
        model.addAttribute("products", productService.list());
        return "products";
    }
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("products", productService.list());
        return "product-info";
    }
    @PostMapping("/product/create")
    public String createProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }
    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}

