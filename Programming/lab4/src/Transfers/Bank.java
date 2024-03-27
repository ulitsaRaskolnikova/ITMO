package Transfers;

import Persons.Person;

import java.util.HashMap;

public class Bank {
    private final HashMap<Person, Integer> bank = new HashMap<>();
    public void addMoney(Person person, int money){
        bank.put(person, (bank.get(person) == null ? 0 : bank.get(person)) + money);
    }
    public void spendMoney(Person person, int money){
        bank.put(person, (bank.get(person) == null ? 0 : bank.get(person)) - money);
    }
    public int getPersonsMoney(Person person){
        return bank.get(person);
    }
    public HashMap<Person, Integer> getBankInfo(){
        return bank;
    }
}
