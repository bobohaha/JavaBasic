package pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {
	

	@Override
	public void update(Observable o, Object arg) {
		String name = (String) arg;
		System.out.println("�۲���ģʽ֪ͨ�ˣ�"+name);
	}

}
