

import java.util.ArrayList;

class Controller {

    Location mainStreet = new Location("Main Street");
    Location trebleParkWay = new Location("Treble Parkway");
    Location baseCircle = new Location("Base Circle");
    Location riffRunWay = new Location("Riff Runway");
    Location seminary = new Location("Seminary Street");
    Location wheatLand = new Location("Wheat Land");
    Location thePalace = new Location("The Palace");
    Location bossPlace = new Location("Boss House");
    Character breakDancer = new BreakDancers("Break Dancer Tyler", 100);
    Character crunkDancer = new CrunkDancer("Crunk Dancer Nathan", 100);
    Character salsaDancer = new SalsaDancer("Salsa Dancer Antonio", 100);
    Character swingDancer = new SwingDancer("Swing Dancer Jimmy", 100);
    Location currentLocation;


    public Controller() {
        currentLocation = mainStreet;
        mainStreet.addNextLocation("north", baseCircle);
        mainStreet.setDescription("You see main street");

        baseCircle.addNextLocation("south", mainStreet);
        baseCircle.addNextLocation("west", riffRunWay);
        baseCircle.addNextLocation("east", trebleParkWay);
        baseCircle.setDescription("You see lights and you hear music");

        trebleParkWay.addNextLocation("west", baseCircle);
        trebleParkWay.addNextLocation("north", thePalace);
        trebleParkWay.addItem("health kit");
        trebleParkWay.addEnemy(breakDancer);
        trebleParkWay.setDescription("You see flashing lights and it peaks your interest.");

        riffRunWay.addNextLocation("east", baseCircle);
        riffRunWay.addNextLocation("north", seminary);
        riffRunWay.addItem("health kit");
        riffRunWay.addEnemy(swingDancer);
        riffRunWay.setDescription("You see a path going west");

        seminary.addNextLocation("south", riffRunWay);
        seminary.addNextLocation("north", bossPlace);
        seminary.addNextLocation("east", wheatLand);
        seminary.addEnemy(crunkDancer);


        wheatLand.addNextLocation("west", seminary);
        wheatLand.addNextLocation("south", baseCircle);
        wheatLand.addNextLocation("north", bossPlace);
        wheatLand.addNextLocation("east", thePalace);

        thePalace.addNextLocation("west", wheatLand);
        thePalace.addNextLocation("south", trebleParkWay);
        thePalace.addNextLocation("north", bossPlace);
        thePalace.addItem("health kit");
        thePalace.addEnemy(salsaDancer);


    }

    public void look(Location currentLocation, String direction) {
        if (currentLocation.nextLocation.keySet().contains(direction)) {
            System.out.println(currentLocation.nextLocation.get(direction).description);
        } else {
            System.out.println("Location not found");
        }
    }

    public void go(Location currentLocation, String direction) {
        if (currentLocation.nextLocation.keySet().contains(direction)) {
            this.currentLocation = currentLocation.nextLocation.get(direction);
        } else {
            System.out.println("Not a valid location");
        }
    }
    public void removeItem(String item){
        this.currentLocation.items.remove(item);
    }
}