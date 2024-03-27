package Places;

import Things.Furniture.Bath;
import Things.Furniture.Bed;
import Things.Furniture.Furniture;
import Things.PhysicalThing;

import java.util.ArrayList;
import java.util.Arrays;

public class Apartment extends Place{
    private ArrayList<Room> rooms = new ArrayList<>();
    public Apartment(){
        super("квартира");
    }
    public Apartment(String name){
        super(name);
    }

    public void addRoom(Room room){
        rooms.add(room);
    }
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    public static class Room extends Place{
        private ArrayList<Furniture> furniture = new ArrayList<>();
        public Room(){
            super("некоторая комната");
        }
        public Room(String name){
            super(name);
        }
        public void setFurniture(Furniture... furniture){
            this.furniture = new ArrayList<Furniture>(Arrays.asList(furniture));
        }
        public void addFurniture(Furniture furniture) {
            this.furniture.add(furniture);
        }
        public void removeAllFurniture(){
            furniture.clear();
        }
        public void removeFurniture(Furniture furniture){
            this.furniture.remove(furniture);
        }
        public ArrayList<Furniture> getFurniture(){
            return furniture;
        }
    }
}
