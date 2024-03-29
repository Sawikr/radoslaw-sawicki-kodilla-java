package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private final String bun;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients;

    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac {" +
                "bun = '" + bun + '\'' +
                ", burgers = " + burgers +
                ", sauce = '" + sauce + '\'' +
                ", ingredients = '" + ingredients + '\'' +
                '}';
    }

    static class BigmacBuilder {

        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder getBun(String bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder getBurgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder getSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder getIngredients(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if (!(bun.isEmpty() || burgers == 0 || sauce.isEmpty() || ingredients.isEmpty())) {
                return new Bigmac(bun, burgers, sauce, ingredients);
            }
            else
                throw new RuntimeException("Bad composition! Bigmac was not prepared.");
        }

        @Override
        public String toString() {
            return "BigmacBuilder {" +
                    "burgers = " + burgers +
                    '}';
        }
    }
}
