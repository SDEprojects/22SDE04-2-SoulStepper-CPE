package com.groovin.items;

import com.groovin.character.Player;

import java.util.concurrent.TimeUnit;

public class Items {

    //would let player use health kit and mj jacket to increase his health
    // method to allow the player to use and item once it's in their inventory

    public void useItem(String item, Player player) throws InterruptedException {

        switch (item) {
            case "health kit":
                player.useHealthKit();
                System.out.println("....");
                TimeUnit.MILLISECONDS.sleep(1000);
                TimeUnit.MILLISECONDS.sleep(1000);
                player.currentHealth();
                break;
            case "mj jacket":
                player.setHealth(300);
                System.out.println("....");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("MJ's soul now flows through you and you feel invincible ");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Soul Steppers health is now at " + player.getHealth());
                break;
        }
    }



}