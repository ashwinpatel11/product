package com.example.assigmment.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){
        super("Product not found");
    }

    public ProductNotFoundException(String msg){
        super(msg);

    }
}
