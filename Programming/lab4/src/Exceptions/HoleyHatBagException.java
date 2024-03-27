package Exceptions;

public class HoleyHatBagException extends RuntimeException{
    public HoleyHatBagException(){
        super("Шляпа-багаж продырявилась и все вещи потерялись!");
    }
    public HoleyHatBagException(String gripe){
        super(gripe);
    }
}
