package pattern.observer;

import java.util.Observable;

public class MyObservable extends Observable {
	
	public void setData(String name){
		setChanged();
		notifyObservers(name);
	}

}
