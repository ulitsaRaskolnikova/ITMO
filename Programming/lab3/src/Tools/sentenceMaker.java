package Tools;

import Enumerations.Intonation;
import Interfaces.*;
import Persons.Person;
import Places.*;
import Things.Clothes.Clothes;
import Things.*;
import Transfers.*;

import java.util.ArrayList;

public class sentenceMaker {
    public static String describeInteraction(Interaction interaction){
        var stringBuilder = new StringBuilder();
        stringBuilder.append(interaction.getFromPerson().getName());
        stringBuilder.append(" по отношению к персоне ");
        stringBuilder.append(interaction.getToPerson().getName()).append(" ");
        stringBuilder.append(interaction.getWaveStyle().getActionDescription());
        stringBuilder.append(", использовал(a) ");
        stringBuilder.append(interaction.getIntonation().getIntonationDescription());
        var info = interaction.getInfo();
        if (!info.isEmpty()){
            stringBuilder.append(", передал(a) информацию, что ");
            stringBuilder.append(info);
        }
        stringBuilder.append(". ");
        return stringBuilder.toString();
    }
    public static String describePlan(Person person, Plan plan){
        return "У персоны " + person.getName() + " появился план " + plan.getText() + ".";
    }
    public static <person extends Blabable> String describePersonPlans(Person person){
        var plans = ((Blabable) person).getPlans();
        var stringBuilder = new StringBuilder("У персоны ");
        stringBuilder.append(person.getName());
        if (plans.isEmpty()){
            stringBuilder.append(" не было планов.");
        }
        else{
            stringBuilder.append(" были планы: ");
            plans.forEach((Plan plan) -> stringBuilder.append(plan.getText()).append(", "));
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append(". ");
        }
        return stringBuilder.toString();
    }
    public static <person extends FindOut> String describeOpponentPlans(Person person){
        var opponentPlans = ((FindOut) person).getOppPlans();
        var opponents = opponentPlans.keySet();
        var stringBuilder = new StringBuilder(person.getName());
        if (opponents.isEmpty()){
            stringBuilder.append(" ничего не знал.");
        }
        else{
            stringBuilder.append(" узнал, что: ");
            for (Person opponent : opponents){
                stringBuilder.append(describePersonPlans(opponent));
            }
        }
        return stringBuilder.toString();
    }
    public static <person extends Emotional> String describePersonEmotion(Person person){
        return person.getName() + " испытал " + ((Emotional) person).getEmotion().getRusEmotion() + ".";
    }
    public static String describeMeeting(Meeting meeting){
        var stringBuilder = new StringBuilder();
        var persons = meeting.getPersons();
        if (persons.isEmpty()){
            stringBuilder.append("Никто не пришёл на встречу.");
        }
        else{
            persons.forEach((Person person) -> stringBuilder.append(person.getName()).append(", "));
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append(" встретились.\n");
            var interactions = meeting.getInteractions();
            for (Interaction interaction : interactions){
                stringBuilder.append(describeInteraction(interaction)).append("\n");
            }
        }
        return stringBuilder.toString();
    }
    public static String describePersonTelegrams(Person person, TelegramTransfer telegramTransfer){
        var telegrams = telegramTransfer.getPersonTelegrams(person);
        var stringBuilder = new StringBuilder(person.getName());
        if (telegrams.isEmpty()){
            stringBuilder.append(" не получал телеграмм.");
        }
        else{
            stringBuilder.append(" получил(а) телеграммы от ");
            telegrams.forEach((Telegram telegram) -> stringBuilder.append(telegram.getByPerson().getName()).append(", "));
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }
    public static String describePlacesInCity(City city){
        var stringBuilder = new StringBuilder("В городе " + city.getName() + " есть ");
        var places = city.getPlaces();
        places.forEach((Place place) -> stringBuilder.append(place.getName()).append(", "));
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append(".");
        return stringBuilder.toString();
    }
    public static String describePersonsInPlace(Place place){
        var stringBuilder = new StringBuilder("В месте " + place.getName());
        var persons = place.getPersons();
        if (persons.isEmpty()){
            stringBuilder.append(" сейчас никого нет.");
        }
        else{
            stringBuilder.append(" сейчас находятся ");
            persons.forEach((Person person) -> stringBuilder.append(person.getName()).append(", "));
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }
    public static String describePersonLeavesPlace(Person person, Place place){
        return person.getName() + " покидает место " + place.getName() + ".";
    }
    public static String describePhysicalThing(PhysicalThing thing){
        var stringBuilder = new StringBuilder();
        stringBuilder.append(thing.getName()).append(" (");
        stringBuilder.append(thing.getShape()).append("; цвет ");
        stringBuilder.append(thing.getColor().getRusColor());
        if (thing instanceof Clothes){
            stringBuilder.append("; ");
            stringBuilder.append(((Clothes) thing).getRusType());
        }
        stringBuilder.append("), ");
        return stringBuilder.toString();
    }
    public static String describeInventoryOfPerson(Person person, Inventory inventory){
        var stringBuilder = new StringBuilder("У персоны " + person.getName());
        ArrayList<PhysicalThing> things = inventory.getInventoryOfPerson(person);
        if (things.isEmpty()){
            stringBuilder.append(" ничего нет.");
        }
        else{
            stringBuilder.append(" есть ");
            for (PhysicalThing thing : things){
                stringBuilder.append(describePhysicalThing(thing));
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append(".");
        return stringBuilder.toString();
    }
}
