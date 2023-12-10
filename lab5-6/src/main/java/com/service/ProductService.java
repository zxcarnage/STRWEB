package com.service;

import com.Model.Product;
import com.dao.ProductDao;
import java.util.List;
public class ProductService
{


        private ProductDao productDao = new ProductDao();

        public ProductService()
        {
        }

        public Product findProduct(String name) {
            return productDao.findByName(name);
        }

        public void addProduct(Product product) {
            productDao.add(product);
        }

        public void deleteProduct(Product product) {
            productDao.delete(product);
        }

        public void updateProduct(Product product) {
            productDao.update(product);
        }

        public List<Product> findAllProducts() {
            return productDao.findAll();
        }

}
