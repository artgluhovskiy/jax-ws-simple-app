package org.art.web.ws;

import org.art.web.ws.clients.catalog_service.CustomCatalog;
import org.art.web.ws.clients.catalog_service.CustomCatalogService;
import org.art.web.ws.clients.catalog_service.Product;
import org.art.web.ws.clients.info_service.InvalidInputException_Exception;
import org.art.web.ws.clients.info_service.ShopInfo;
import org.art.web.ws.clients.info_service.ShopInfoService;
import org.art.web.ws.webservices.ProductCatalog;

import javax.xml.ws.Endpoint;
import java.util.List;

public class WebserviceClientTest {

    public static void main(String[] args) {

        //Services Launching Test (without GlassFish deployment)
        Endpoint.publish("http://localhost:1234/productcatalog", new ProductCatalog());

        //ProductCatalog service test
        CustomCatalogService customCatalogService = new CustomCatalogService();
        CustomCatalog productCatalogPort = customCatalogService.getCustomCatalogPort();
        List<String> categories = productCatalogPort.fetchCategories();
        System.out.println(categories);

        List<Product> products = productCatalogPort.getProducts("category");
        System.out.println(products);

        //ShopInfo service test
        ShopInfoService shopInfoService = new ShopInfoService();
        ShopInfo shopInfoPort = shopInfoService.getShopInfoPort();
        try {
            String shopName = shopInfoPort.getShopInfo("shopName");
            System.out.println(shopName);
            String invalid = shopInfoPort.getShopInfo("invalid");
            System.out.println(invalid);
        } catch (InvalidInputException_Exception e) {
            System.out.println("Exception was caught: " + e);
        }
    }
}
