package DesignPatterns.CreationalDesignPattern;

public class ProtoTypeDesignPattern {

    public static void main(String[] args) throws CloneNotSupportedException {

        CharacterFactory factory = new CharacterFactory();
        Characters nameCharacter = factory.getNameCharacter("Alex");
        Characters powerCharacter = factory.getPowerCharacter(0);
        Characters healthCharacter = factory.getHealthCharacter(0);

        System.out.println(nameCharacter);
        System.out.println(powerCharacter);
        System.out.println(healthCharacter);

    }

}

class CharacterFactory {

    Characters protoTypCharacter;

    CharacterFactory() {
        protoTypCharacter = new Characters("Default", 0, 0, 0);
    }

    public Characters getNameCharacter(String name) throws CloneNotSupportedException {

        Characters clonedCharacter = protoTypCharacter.clone();
        clonedCharacter = new Characters(name, clonedCharacter.health, clonedCharacter.health, clonedCharacter.power);
        return clonedCharacter;

    }

    public Characters getPowerCharacter(int power) throws CloneNotSupportedException {
        Characters clonedCharacter = protoTypCharacter.clone();
        clonedCharacter = new Characters(clonedCharacter.name, clonedCharacter.health, clonedCharacter.health, power);
        return clonedCharacter;
    }

    public Characters getHealthCharacter(int health) throws CloneNotSupportedException {
        Characters clonedCharacter = protoTypCharacter.clone();
        clonedCharacter = new Characters(clonedCharacter.name, clonedCharacter.health, health, clonedCharacter.power);
        return clonedCharacter;
    }

}

// ==================PROTOTYPE APPROACH=========================
class Characters implements Cloneable {

    public String name;
    public int health;
    public int attack;
    public int power;

    public Characters(String name, int health, int attack, int power) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Character [name=" + name + ", health=" + health + ", attack=" + attack + ", power=" + power + "]";
    }

    @Override
    protected Characters clone() throws CloneNotSupportedException {
        return (Characters) super.clone();
    }

}

// ========================================TRADATIONAL
// APPROACH======================================
class Character {

    private String name;
    private int health;
    private int attack;
    private int power;

    public Character(String name, int health, int attack, int power) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Character [name=" + name + ", health=" + health + ", attack=" + attack + ", power=" + power + "]";
    }

    public Character getNameCharacter(String name) {
        return new Character(name, 100, 50, 1);
    }

    public Character getPowerCharacter(int power) {
        return new Character("NullByte", 100, 50, power);
    }

    public Character getHealthCharacter(int health) {
        return new Character("Alex", 100, 50, health);
    }

    // More and more methods for every possible variation...

}
