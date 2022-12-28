package com.kodilla.stream.beautifier;

import java.util.Locale;

public class PoemBeautifier{

    public static void main(String[] args) {

    PoemBeautifier newText = new PoemBeautifier();

    newText.beautify("Name", textDecoration -> "new " + textDecoration);
    newText.beautify("Name", textDecoration -> "new " + textDecoration + ": Radek");
    newText.beautify("Name", textDecoration -> textDecoration.toUpperCase());
    newText.beautify("Name", textDecoration -> textDecoration.toLowerCase(Locale.ROOT));
    newText.beautify("Name", textDecoration -> "Name");
    newText.beautify("Name", textDecoration -> String.valueOf(textDecoration.charAt(0)));
    newText.beautify("Name", textDecoration -> String.valueOf(textDecoration.charAt(3)));
    newText.beautify(" Name ", textDecoration -> textDecoration.strip() + textDecoration.strip());

    }

    void beautify(String textDecoration, PoemDecorator obj){
        String result = obj.decorate(textDecoration);
        System.out.println(result);
    }
}