package org.art.web.ws.webservices;

import org.art.web.ws.model.Product;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(
        name = "CustomCatalog",
        targetNamespace = "http://www.custom-catalog.com"
)
public interface ProductCatalogIF {

    @WebMethod(
            action = "fetch_categories",
            operationName = "fetchCategories"
    )
    List<String> getCategories();

    @WebMethod
    @WebResult(name = "Product")
    List<Product> getProducts(String category);
}
