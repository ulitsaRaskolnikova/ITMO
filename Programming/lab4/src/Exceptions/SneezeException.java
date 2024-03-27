package Exceptions;

public class SneezeException extends Exception{
    public SneezeException(){
        super("Человечек чихнул!");
    }
    public SneezeException(String gripe){
        super(gripe);
    }
}
