package org.art.web.ws.webservices;

import org.art.web.ws.model.Product;
import org.art.web.ws.services.ProductCatalogServiceImpl;

import javax.jws.WebService;
import java.util.List;

@WebService(
        endpointInterface = "org.art.web.ws.webservices.ProductCatalogIF",
        portName = "CustomCatalogPort",
        serviceName = "CustomCatalogService"
)
public class ProductCatalog implements ProductCatalogIF {

    private ProductCatalogServiceImpl productCatalogService = new ProductCatalogServiceImpl();

    @Override
    public List<String> getCategories() {
        return productCatalogService.getCategories();
    }

    @Override
    public List<Product> getProducts(String category) {
        return productCatalogService.getProducts(category);
    }
}
