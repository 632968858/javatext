package designpattern;

import java.util.Observable;
import java.util.Observer;
/*观测者模式
观察者*/
public class FirstDisplay implements Observer {
	private Observable wd;//weatherdata
	private float temperature;
	private float humidity;
	private float pressure;
  public FirstDisplay(Observable wd) {
		// TODO Auto-generated constructor stub
		this.wd=wd;
		this.wd.addObserver(this);   //添加到主题
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof WeatherData ){
			WeatherData weaterdata =(WeatherData) o;
			this.temperature=weaterdata.getTemperature();
			this.humidity=weaterdata.getHumidity();
			this.pressure=weaterdata.getPressure();
			display();
		}
	}
	public void display(){
		System.out.println("firstdisplay: "+temperature+humidity+pressure);
	}

}
