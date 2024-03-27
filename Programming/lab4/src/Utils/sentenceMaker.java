package Utils;

import Interfaces.*;
import Persons.Person;
import Places.*;
import Things.Clothes.Clothes;
import Things.*;
import Things.HygieneThings.Soap;
import Things.HygieneThings.ToothPowderBox;
import Transfers.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class sentenceMaker {
    public static String describeBank(Bank bank){
        var stringBuilder = new StringBuilder();
        var bankInfo = bank.getBankInfo();
        Set<Person> persons = bankInfo.keySet();
        for (var person : persons){
            stringBuilder.append(person.getName()).append(": ").append(bankInfo.get(person)).append(" фертингов\n");
        }
        return stringBuilder.toString();
    }
    public static String describeToothPowderFlies(ToothPowderBox toothPowderBox){
        return "Зубной порошок из " + toothPowderBox.getName() + " разлетелся.";
    }
    public static String describeSmells(AromaThing aromaThing){
        return aromaThing.getName() + " источает запах " + aromaThing.getAroma().getRusType();
    }
    public static String describeIsOpenedBox(ToothPowderBox toothPowderBox){
        String con = " закрыта.";
        if (toothPowderBox.isOpened()){
            con = " открыта";
        }
        return toothPowderBox.getName() + con;
    }
    public static String describePersonBrushTeeth(Person person){
        return person.getName() + " чистит зубы.";
    }
    public static String describeToothbrooshInBox(ToothPowderBox toothPowderBox){
        return "В " + toothPowderBox.getName() + " засунули щётку.";
    }
    public static String describePersonWashesHands(Person person, Soap soap){
        var stringBuilder = new StringBuilder();
        stringBuilder.append(person.getName()).append(" моет руки, используя ");
        stringBuilder.append(soap.getName()).append(".");
        return stringBuilder.toString();
    }
    public static String describeArrayListThings(ArrayList<PhysicalThing> arr, String name){
        var stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(" содержит: ");
        for (PhysicalThing el : arr){
            stringBuilder.append(el.getName()).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append(".");
        return stringBuilder.toString();
    }
    public static String describeInteraction(Meeting.Interaction interaction){
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
            for (Meeting.Interaction interaction : interactions){
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
            for (Telegram telegram : telegrams){
                stringBuilder.append(telegram.getByPerson().getName()).append(" (Содержание: \"");
                stringBuilder.append(telegram.getText()).append("\"), ");
            }
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
        stringBuilder.append(thing.getDescription()).append("; цвет ");
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
