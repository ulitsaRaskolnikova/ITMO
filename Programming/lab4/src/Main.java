import Enums.*;
import Enums.TypeOfClothes.*;
import Exceptions.HoleyHatBagException;
import Exceptions.SneezeException;
import Interfaces.IMakeDirty;
import Places.*;
import Things.*;
import Things.Clothes.*;
import Things.Furniture.*;
import Things.HygieneThings.*;
import Things.MaterialThings.*;
import Transfers.*;
import Persons.*;

import java.util.ArrayList;
import java.util.Arrays;

import static Utils.sentenceMaker.*;

public class Main {
    public static void main(String[] args) {
        var crabs = new Crabs();
        var city = new City("Давилон");
        city.addPerson(crabs);
        System.out.println(describePersonsInPlace(city));
        var restaurant = new Restaurant();
        city.addPlace(restaurant);
        restaurant.addPerson(crabs);
        crabs.eat();
        restaurant.rmPerson(crabs);

        var apartment = new Apartment("номер");
        var bathroom = new Apartment.Room("ванная");
        var closet = new Closet();
        var bath = new Bath();
        bathroom.addFurniture(bath);
        bathroom.addFurniture(closet);
        var livingroom = new Apartment.Room("спальня");
        var bed1 = new Bed();
        var bed2 = new Bed();
        livingroom.setFurniture(bed1, bed2);

        apartment.addRoom(bathroom);
        apartment.addRoom(livingroom);

        var hotel = new Hotel();
        city.addPlace(hotel);
        System.out.println(describePlacesInCity(city));

        apartment.addPerson(crabs);
        hotel.addPlace(apartment);

        livingroom.addPerson(crabs);

        bed1.addPerson(crabs);
        bed1.use(crabs);
        bed1.rmPerson(crabs);

        livingroom.rmPerson(crabs);
        apartment.rmPerson(crabs);

        var swimmingPool = new SwimmingPool();
        hotel.addPlace(swimmingPool);
        swimmingPool.addPerson(crabs);
        swimmingPool.rmPerson(crabs);
        hotel.rmPerson(crabs);

        var miga = new Person("Мига");
        var julio = new Person("Джулио");

        var meetingOfFriends = new Meeting();
        meetingOfFriends.setPersons(crabs, miga, julio);
        restaurant.setPersons(crabs, miga,julio);
        crabs.eat();
        miga.eat();
        julio.eat();
        restaurant.rmAllPersons();

        var nightTheatre = new NightTheatre();
        nightTheatre.setPersons(crabs, miga, julio);
        var actor1 = new Person("Актёр");
        var actor2 = new Person("Актёр");
        nightTheatre.addActor(actor1);
        nightTheatre.addActor(actor2);
        nightTheatre.throwAtActors(new IMakeDirty() {
            @Override
            public void makeDirty(Person person) {
                person.setIsClean(false);
            }
        });

        crabs.setEmotion(Emotion.HAPPY);
        miga.setEmotion(Emotion.HAPPY);
        julio.setEmotion(Emotion.HAPPY);

        nightTheatre.rmAllPersons();

        hotel.addPerson(crabs);

        bed1.addPerson(crabs);
        bed1.use(crabs);
        bed1.rmPerson(crabs);

        var scooperfield = new Scooperfield();
        var sproots = new Person("Спрутс");

        var telegramTransfer = new TelegramTransfer();
        telegramTransfer.sendTelegramToPerson(sproots, new Telegram(crabs, "Два осла требуют два. На один не согласны. Что делать? Крабс."));
        System.out.println(describePersonTelegrams(sproots, telegramTransfer));

        telegramTransfer.sendTelegramToPerson(crabs, new Telegram(sproots, "Уговаривайте."));
        System.out.println(describePersonTelegrams(crabs, telegramTransfer));

        telegramTransfer.sendTelegramToPerson(sproots, new Telegram(crabs, "Уговаривал. Упираются."));
        System.out.println(describePersonTelegrams(sproots, telegramTransfer));

        city.addPerson(scooperfield);
        System.out.println(describePersonsInPlace(city));

        hotel.addPerson(crabs);
        hotel.addPerson(scooperfield);
        System.out.println(describePersonsInPlace(hotel));

        var inventory = new Inventory();
        var stick = new Stick(Material.WOOD);
        var jacket = new Jacket(Color.BLACK, "длиннополый, с двумя разрезами на спине", TypeOfJacket.CLASSIC);
        var pants = new Pants(Color.BLACK, TypeOfPants.TROUSERS);
        var hatBag = new Hat(Color.BLACK, "высокая", TypeOfHat.TOP_HAT){
            private ArrayList<PhysicalThing> things = new ArrayList<>();
            public void addThing(PhysicalThing thing){
                things.add(thing);
            }
            public ArrayList<PhysicalThing> getThings(){
                return things;
            }
            public void setThings(PhysicalThing... things) throws HoleyHatBagException{
                if (Math.random() <= 0.8) {
                    throw new HoleyHatBagException();
                }
                else{
                    this.things = new ArrayList<>(Arrays.asList(things));
                }
            }
            public void removeAllThings(){
                things.clear();
            }
            public void removeThing(PhysicalThing thing){
                things.remove(thing);
            }
        };
        var toothbrush = new ToothBrush();
        var toothPowderBoxScooperfield = new ToothPowderBox(false);
        toothPowderBoxScooperfield.setName("коробка из-под зубного порошка Скуперфильда");
        toothPowderBoxScooperfield.addPowder();
        toothPowderBoxScooperfield.toothPowder.setAroma(Aroma.MINT);
        var towel = new Towel();
        var socks = new Socks();
        socks.setDescription("запасные");
        var wire = new Wire();
        wire.setDescription("старая");
        var soapScooperfield = new Soap(Aroma.STRAWBERRY);
        soapScooperfield.setName("мыло Скуперфильда");
        try{
            hatBag.setThings(toothbrush, toothPowderBoxScooperfield, towel, socks, wire, soapScooperfield);
        }
        catch(HoleyHatBagException e){
            System.err.println(e.getMessage());
        }
        for (int i = 0; i < 6; i++){
            hatBag.addThing(new Handkerchief());
        }
        for (int i = 0; i < 2; i++){
            hatBag.addThing(new Nail());
        }

        inventory.setThingsToPerson(scooperfield, stick, jacket, hatBag);
        inventory.addThingToPerson(scooperfield, pants);

        System.out.println(describeInventoryOfPerson(scooperfield, inventory));

        hotel.rmPerson(crabs);
        System.out.println(describePersonLeavesPlace(crabs, hotel));

        hotel.rmPerson(scooperfield);
        System.out.println(describePersonLeavesPlace(scooperfield, hotel));

        scooperfield.setWaveStyle(WaveStyle.HUG);
        scooperfield.setIntonation(Intonation.DISGUSTING);

        var meeting = new Meeting();
        meeting.addPerson(scooperfield);
        meeting.addPerson(crabs);
        System.out.print(describeMeeting(meeting));

        var greeting = meeting.new Interaction(scooperfield, crabs);
        meeting.addInteraction(greeting);
        System.out.println(describeInteraction(greeting));

        crabs.setEmotion(Emotion.UNPROMISING);
        System.out.println(describePersonEmotion(crabs));

        scooperfield.setWaveStyle(WaveStyle.NOTHING);
        final var info = "Скуперфильд неспроста прибыл в Давилон";
        var conversation = meeting.new Interaction(scooperfield, crabs, info);

        meeting.addInteraction(conversation);
        System.out.println(describeInteraction(conversation));

        var planScooperfield = new Plan("неизвестно");
        scooperfield.addPlan(planScooperfield);
        System.out.println(describePersonPlans(scooperfield));

        crabs.setEmotion(Emotion.CURIOS);
        System.out.println(describePersonEmotion(crabs));

        var planCrabs = new Plan("выведать планы Скуперфильда");
        crabs.addPlan(planCrabs);
        System.out.println(describePlan(crabs, planCrabs));

        crabs.findOutPlans(scooperfield);
        System.out.println(describeOpponentPlans(crabs));
        crabs.rmPlan(planCrabs);

        apartment.addPerson(scooperfield);
        apartment.addPerson(crabs);
        System.out.println(describePersonsInPlace(apartment));

        livingroom.addPerson(scooperfield);
        livingroom.addPerson(crabs);



        var smallTalk = meeting.new Interaction(crabs, scooperfield, "Располагайтесь, пожалуйста. Места, как видите, на двоих хватит.");
        meeting.addInteraction(smallTalk);
        System.out.println(describeInteraction(smallTalk));

        scooperfield.setEmotion(Emotion.DISGUSTING);
        var thanks = meeting.new Interaction(scooperfield, crabs, "Спасибо.");
        meeting.addInteraction(thanks);
        System.out.println(describeInteraction(thanks));

        livingroom.rmPerson(scooperfield);

        bathroom.addPerson(scooperfield);
        System.out.println(describePersonsInPlace(bathroom));

        inventory.removeThing(scooperfield, hatBag);
        System.out.println(describeInventoryOfPerson(scooperfield, inventory));
        var hatBagThings = new ArrayList<PhysicalThing>();
        for(PhysicalThing thing : hatBag.getThings()){
            hatBagThings.add(thing);
        }
        System.out.println(describeArrayListThings(hatBag.getThings(), "Шляпа-багаж"));
        for (PhysicalThing thing : hatBagThings){
            if (thing != soapScooperfield) {
                hatBag.removeThing(thing);
                closet.use(thing);
            }
        }
        System.out.println(describeArrayListThings(hatBag.getThings(), "Шляпа-багаж"));
        hatBag.removeThing(soapScooperfield);


        var soapCrabs = new Soap(Aroma.STRAWBERRY);
        soapCrabs.setName("мыло Крабса");

        if (soapScooperfield.equals(soapCrabs)){
            soapCrabs.washHands(scooperfield);
            System.out.println(describePersonWashesHands(scooperfield, soapCrabs));
        }
        else{
            soapScooperfield.washHands(scooperfield);
            System.out.println(describePersonWashesHands(scooperfield, soapScooperfield));
        }

        scooperfield.setEmotion(Emotion.HAPPY);
        System.out.println(describePersonEmotion(scooperfield));

        var toothPowderBoxCrabs = new ToothPowderBox(false);
        toothPowderBoxCrabs.addPowder();
        toothPowderBoxCrabs.toothPowder.setAroma(Aroma.STRAWBERRY);

        toothPowderBoxCrabs.open();
        toothPowderBoxScooperfield.open();

        toothPowderBoxCrabs.putToothBrushToBox();
        toothPowderBoxCrabs.setName("коробка из-под зубного порошка Крабса");
        System.out.println(describeToothbrooshInBox(toothPowderBoxCrabs));
        scooperfield.cleanTeeth();
        System.out.println(describePersonBrushTeeth(scooperfield));

        for (int i = 0; i < 10; i++){
            if (i%2 == 0){
                toothPowderBoxCrabs.open();
                System.out.println(describeIsOpenedBox(toothPowderBoxCrabs));
                try{
                    scooperfield.sniff(toothPowderBoxCrabs.toothPowder.smell());
                }
                catch(SneezeException e){
                    sneezeSituation(e, toothPowderBoxCrabs);
                    break;
                }
                System.out.println(describeSmells(toothPowderBoxCrabs.toothPowder));
                toothPowderBoxCrabs.close();
                System.out.println(describeIsOpenedBox(toothPowderBoxCrabs));
            }
            else{
                toothPowderBoxScooperfield.open();
                System.out.println(describeIsOpenedBox(toothPowderBoxScooperfield));
                try{
                    scooperfield.sniff(toothPowderBoxScooperfield.toothPowder.smell());
                }
                catch(SneezeException e){
                    sneezeSituation(e, toothPowderBoxScooperfield);
                    break;
                }
                System.out.println(describeSmells(toothPowderBoxScooperfield.toothPowder));
                toothPowderBoxScooperfield.close();
                System.out.println(describeIsOpenedBox(toothPowderBoxScooperfield));
            }
        }
        scooperfield.setEmotion(Emotion.DESPONDENCY);
        if (toothPowderBoxScooperfield.toothPowder.getPowderWeight() > 0){
            scooperfield.setEmotion(Emotion.HAPPY);
            toothPowderBoxScooperfield.toothPowder.setPowderWeight(
                    toothPowderBoxScooperfield.toothPowder.getPowderWeight() + toothPowderBoxCrabs.toothPowder.getPowderWeight());
            toothPowderBoxCrabs.toothPowder.setPowderWeight(0);
        }
        bathroom.rmPerson(scooperfield);
        livingroom.addPerson(scooperfield);

        miga.addPlan(new Plan("получить миллион фертингов"));
        julio.addPlan(new Plan("получить миллион фертингов"));
        sproots.addPlan(new Plan("поднажиться на этом деле и увеличить сумму, с тем чтоб миллион фертингов положить в свой карман"));

        crabs.findOutPlans(sproots);

        meeting.addInteraction(meeting.new Interaction(crabs, scooperfield, "Да, да, мне это, конечно, известно."));

        var bredlam = new Bredlam();
        var mainCapitalist = new Bredlam.Capitalist();
        Bredlam.Capitalist[] capitalists = new Bredlam.Capitalist[10];
        for (int i = 0; i < capitalists.length; i++){
            capitalists[i] = new Bredlam.Capitalist();
        }

        bredlam.setPersons(capitalists);
        bredlam.addPerson(mainCapitalist);
        bredlam.addPerson(sproots);

        var bank = new Bank();
        bank.addMoney(miga, 1_000_000);
        bank.addMoney(julio, 1_000_000);
        bank.addMoney(sproots, 1_000_000);
        bank.spendMoney(mainCapitalist, 3_000_000);
        bredlam.rmPerson(sproots);
        System.out.println(describeBank(bank));
        if (bank.getPersonsMoney(mainCapitalist) < 0){
            bredlam.makeAngry();
        }
        meeting.addInteraction(meeting.new Interaction(crabs, sproots, "Охотно помогу вам, господин Скуперфильд. Если хотите, мы хоть сейчас отправимся к Миге и Жулио. Они живут на даче за юродом. Мы мигом домчим на моей машине. Заодно можно будет и пообедать у них."));
        meeting.addInteraction(meeting.new Interaction(sproots, crabs, "Пообедать, что ж, это можно. Хорошо бы и пообедать, а то здесь в ресторанах такие цены дерут с посетителей, чтоб им провалиться на месте, прямо никаких капиталов не хватит. Можно и пообедать."));
        meeting.addInteraction(meeting.new Interaction(sproots, crabs, "Вот и хорошо. С вашего разрешения я только на минуточку отлучусь, и мы поедем."));
        System.out.println(describeMeeting(meeting));

        livingroom.rmPerson(crabs);
        apartment.rmPerson(crabs);

        telegramTransfer.sendTelegramToPerson(sproots, new Telegram(crabs, "С ослами пора кончать. В городе появился брехенвильский скупец Скуперфильд. За последствия не отвечаю. Крабс."));
        System.out.println(describePersonTelegrams(sproots, telegramTransfer));
    }
    private static void sneezeSituation(SneezeException e, ToothPowderBox toothPowderBox){
        System.err.println(e.getMessage());
        toothPowderBox.toothPowder.fly();
        System.out.println(describeToothPowderFlies(toothPowderBox));
    }
}