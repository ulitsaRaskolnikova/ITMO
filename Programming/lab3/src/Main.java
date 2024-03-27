import Enumerations.*;
import Enumerations.TypeOfClothes.*;
import Places.*;
import Things.*;
import Things.Clothes.*;
import Transfers.*;
import Persons.*;
import static Tools.sentenceMaker.*;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var crabs = new Crabs();
        var scooperfield = new Scooperfield();

        var telegramTransfer = new TelegramTransfer();
        telegramTransfer.sendTelegramToPerson(crabs, new Telegram(scooperfield));
        System.out.println(describePersonTelegrams(crabs, telegramTransfer));

        telegramTransfer.sendTelegramToPerson(scooperfield, new Telegram(crabs));
        System.out.println(describePersonTelegrams(scooperfield, telegramTransfer));

        var city = new City("Давилон");
        var hotel = new Hotel();
        city.addPlace(hotel);
        System.out.println(describePlacesInCity(city));

        city.addPerson(crabs);
        city.addPerson(scooperfield);
        System.out.println(describePersonsInPlace(city));

        hotel.addPerson(crabs);
        hotel.addPerson(scooperfield);
        System.out.println(describePersonsInPlace(hotel));

        var inventory = new Inventory();
        var stick = new Stick(Material.WOOD);
        var jacket = new Jacket(Color.BLACK, "длиннополый, с двумя разрезами на спине", TypeOfJacket.CLASSIC);
        var pants = new Pants(Color.BLACK, TypeOfPants.TROUSERS);
        var hat = new Hat(Color.BLACK, "высокая", TypeOfHat.TOP_HAT);
        inventory.setThingsToPerson(scooperfield, stick, jacket, pants, hat);
        System.out.println(describeInventoryOfPerson(scooperfield, inventory));

        hotel.rmPerson(crabs);
        System.out.println(describePersonLeavesPlace(crabs, hotel));

        scooperfield.setWaveStyle(WaveStyle.HUG);
        scooperfield.setIntonation(Intonation.DISGUSTING);

        var meeting = new Meeting();
        meeting.addPerson(scooperfield);
        meeting.addPerson(crabs);
        System.out.print(describeMeeting(meeting));

        var greeting = new Interaction(scooperfield, crabs);
        meeting.addInteraction(greeting);
        System.out.println(describeInteraction(greeting));

        crabs.setEmotion(Emotion.UNPROMISING);
        System.out.println(describePersonEmotion(crabs));

        scooperfield.setWaveStyle(WaveStyle.NOTHING);
        final var info = "Скуперфильд неспроста прибыл в Давилон";
        var conversation = new Interaction(scooperfield, crabs, info);

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
    }
}