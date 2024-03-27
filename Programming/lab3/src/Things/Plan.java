package Things;

import java.util.Objects;

public class Plan {
    private String text;
    public Plan(String text){
        this.text = text;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        var other = (Plan) otherObject;
        return Objects.equals(text, other.text);
    }
    @Override
    public int hashCode(){
        return text.hashCode();
    }
    @Override
    public String toString(){
        return getClass().getName() + "[text=" + text + "]";
    }
}
