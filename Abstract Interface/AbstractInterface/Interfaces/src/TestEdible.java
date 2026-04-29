public class TestEdible {
}

class Animal {

}

class Chicken extends Animal implements Edible {
    public String howToEat() {
        return "Chicken: Fry It!";
    }
}

class Tiger extends Animal {

}

// subclasses of fruit must use interface
abstract class Fruit implements Edible {

}

class Apple extends Fruit {
    public String howToEat() {
        return "Apple: Make apple cidar";
    }
}

class Orange extends Fruit {
    public String howToEat() {
        return "Orange: Make orange juice";
    }
}

