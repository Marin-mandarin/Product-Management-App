package exceptions;

public class ProductManagementRuntimeException extends RuntimeException{

    public ProductManagementRuntimeException (){
        super();
    }

    public  ProductManagementRuntimeException(String message){
        super(message);
    }

}
