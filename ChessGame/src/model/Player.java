package model;

public class Player {
    public String getName() {
        return name;
    }

    String name;
    COLOR color;

    public Player(String name, COLOR color) {
        this.name = name;
        this.color = color;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}
