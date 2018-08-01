package org.art.web.ws.services;

import org.art.web.ws.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalogServiceImpl {

    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Books");
        categories.add("Music");
        categories.add("Movies");
        return categories;
    }

    public List<Product> getProducts(String category) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Java Brains Book", "1234", 100));
        productList.add(new Product("Another Book", "abc", 150));
        return productList;
    }
}
