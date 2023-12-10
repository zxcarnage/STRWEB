package com.start;

import com.Model.Product;
import com.dao.ProductDao;
import com.service.ProductService;

import java.util.List;

public class Start
{
    public static void main(String[] args)
    {
        ProductService productService = new ProductService();
        Product product1 = new Product("кресло","мебель", 3, 750);
       productService.addProduct(product1);
      // Product product2 = productService.findProduct("razer viper");
        //System.out.println(product2.getName() +"\t" +product2.getType()+"\t" +product2.getCount() +"\t" + product2.getPrice() );
        List<Product> productList= productService.findAllProducts();
        for (Product p: productList)
        {
            System.out.println(p.getName() +"\t" +p.getType()+"\t" +p.getCount() +"\t" + p.getPrice()  );
        }
    }
}
