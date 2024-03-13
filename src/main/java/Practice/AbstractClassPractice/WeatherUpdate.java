package Practice.AbstractClassPractice;

public class WeatherUpdate extends State{

    public WeatherUpdate(){
        super();
    }
    public void display(){
        System.out.println(this.integerList.toString());
    }

    public void addInteger(int l){
        this.integerList.add(l);
    }

}
