package creational;

/** https://javarush.com/groups/posts/2370-pattern-proektirovanija-factory */
public class FactoryMethod {
    public static void main(String[] args) {

    }
}

class CoffeeFactory{

    public Coffee orderCoffee(CoffeeType type){
          Coffee coffee = null;

          switch (type){
              case ESPRESSO -> coffee = new Espresso();
              case AMERICANO -> coffee = new Americano();
              case CAPPUCCINO -> coffee = new Cappuccino();
              case CAFFE_LATTE -> coffee = new CaffeLatte();
          }

          return coffee;
    }
}

class Coffee {
    public void grindCoffee(){
        // перемалываем кофе
    }
    public void makeCoffee(){
        // делаем кофе
    }
    public void pourIntoCup(){
        // наливаем в чашку
    }
}

class Americano extends Coffee {}
class Cappuccino extends Coffee {}
class CaffeLatte extends Coffee {}
class Espresso extends Coffee {}

enum CoffeeType {
    ESPRESSO,
    AMERICANO,
    CAFFE_LATTE,
    CAPPUCCINO
}