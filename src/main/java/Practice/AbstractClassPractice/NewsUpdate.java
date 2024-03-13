package Practice.AbstractClassPractice;

public class NewsUpdate extends State{

    public NewsUpdate(){
        super();
    }
    public void display(){
        System.out.println(this.integerList.toString());
    }
    public void addInteger(int l){
        this.integerList.add(l);
    }
}
