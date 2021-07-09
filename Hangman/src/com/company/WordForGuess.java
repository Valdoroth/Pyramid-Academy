package com.company;

import java.util.ArrayList;
import java.util.Random;

public class WordForGuess {

    public WordForGuess() {
    }

    public String wordforguess(){
        String word;
        ArrayList<String> wordlist = new ArrayList<>(){
            {
                add("xray");
                add("danger");
                add("dice");
                add("joker");
                add("hack");
                add("complicated");
                add("father");
                add("maple");
                add("apple");
                add("infant");
                add("infinity");
                add("zebra");
                add("zoolander");
                add("karaoke");
                add("brown");
                add("daredevil");
                add("clown");
                add("jambalaya");
                add("gregorian");
                add("caesar");
                add("diverticulitis");
                add("mandalorian");
                add("piano");
                add("epinephrine");
                add("nutcracker");
                add("firecracker");
                add("quintuplets");
                add("wildlife");
                add("smite");
                add("spell");
                add("paralysis");
                add("upsilon");
                add("onomatopoeia");
                add("haberdashery");
            }
        };

        int gen = new Random().nextInt(wordlist.size()-1); //randomly pick a word from the list
        word = wordlist.get(gen);

        return word;
    }
}
