package ca.cmpt213.asn5;

public class Tokimon {

    private String id;
    private String name;
    private int weight;
    private int height;
    private int fly;
    private int fire;
    private int water;
    private int electric;
    private int freeze;
    private int strength;
    private String color;

    public Tokimon() {
    }

    public Tokimon(String id, String name, int weight, int height, int fly, int fire, int water, int electric, int freeze, int strength, String color) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.fly = fly;
        this.fire = fire;
        this.water = water;
        this.electric = electric;
        this.freeze = freeze;
        this.strength = strength;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFly() {
        return fly;
    }

    public void setFly(int fly) {
        this.fly = fly;
    }

    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    public int getFreeze() {
        return freeze;
    }

    public void setFreeze(int freeze) {
        this.freeze = freeze;
    }

    @Override
    public String toString() {
        return "Tokimon{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", fly=" + fly +
                ", fire=" + fire +
                ", water=" + water +
                ", electric=" + electric +
                ", freeze=" + freeze +
                ", strength=" + strength +
                ", color='" + color + '\'' +
                '}';
    }
}
