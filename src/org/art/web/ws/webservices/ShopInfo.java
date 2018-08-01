package org.art.web.ws.webservices;

import org.art.web.ws.exceptions.InvalidInputException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ShopInfo {

    @WebMethod
    @WebResult(partName = "lookupOutput")
    public String getShopInfo(@WebParam(partName = "lookupInput") String property) throws InvalidInputException {
        String response = null;
        if ("shopName".equals(property)) {
            response = "Custom Mart";
        } else if ("since".equals(property)) {
            response = "since 2018";
        } else {
            throw new InvalidInputException("Invalid Input", property + " is not a valid input!");
        }
        return response;
    }
}
