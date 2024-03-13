package Practice.AbstractClassPractice;

public class Main {

    public static void main(String args[]){
        WeatherUpdate weather = new WeatherUpdate();
        NewsUpdate news = new NewsUpdate();

        weather.addInteger(1);
        weather.addInteger(2);
        weather.addInteger(3);
        weather.addInteger(4);
        weather.addInteger(5);
        weather.addInteger(6);


        news.addInteger(10);
        news.addInteger(10);
        news.addInteger(10);
        news.addInteger(10);
        news.addInteger(10);
        weather.display();
        news.display();

    }
}
