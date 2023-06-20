package com.design.atgg.pattern.chatgpt.factorypattern;

public class Main {
	public static void main(String[] args) {
		PizzaFactory factory = new PizzaFactory();
		Pizza cheesePizza = factory.createPizza("cheese");
		cheesePizza.prepare();
		cheesePizza.bake();
		cheesePizza.cut();
		cheesePizza.box();

		Pizza pepperoniPizza = factory.createPizza("pepperoni");
		pepperoniPizza.prepare();
		pepperoniPizza.bake();
		pepperoniPizza.cut();
		pepperoniPizza.box();
	}
}
