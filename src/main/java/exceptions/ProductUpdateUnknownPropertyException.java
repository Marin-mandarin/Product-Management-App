package exceptions;

public class ProductUpdateUnknownPropertyException extends ProductNotFoundExceptions {
    public ProductUpdateUnknownPropertyException (String message){
        super(message);

    }
}
