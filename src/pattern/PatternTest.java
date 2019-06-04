package pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import pattern.decorator.ChildDecorator;
import pattern.decorator.CoreDecorator;
import pattern.decorator.IDecorator;
import pattern.flyweight.FlyWeight;
import pattern.flyweight.FlyWeightFactory;
import pattern.observer.MyObservable;
import pattern.observer.MyObserver;


public class PatternTest {

	private static List<FlyWeight> orders = new ArrayList<FlyWeight>();
	private static FlyWeightFactory factory;

	public static void main(String[] args) {
		
		/**
		 * ��Ԫģʽ����
		 */
//		factory = FlyWeightFactory.getInstance();
//		takeOrders("��������");
//		takeOrders("ˮ䰴�");
//		takeOrders("�����");
//		takeOrders("����");
//		takeOrders("��¥��");
//		takeOrders("��������");
//		takeOrders("�����");
//		takeOrders("ˮ䰴�");
//
//		for (FlyWeight order : orders) {
//			order.cell();
//		}
//		// ��ӡ���ɵĶ���java��������
//		System.out.println("\n�ͻ�һ������ " + orders.size() + " ����! ");
//		// ��ӡ���ɵĶ���java��������
//		System.out.println("�������� " + factory.getTotalObjects()
//				+ " �� FlyWeight java����! ");
		
		/**
		 * װ����ģʽ����
		 */
//		IDecorator decorator = new ChildDecorator(new CoreDecorator());
//		decorator.doSomeThing();
		
		/**
		 * �۲���ģʽ
		 */
		MyObserver observer1 = new MyObserver();
		MyObserver observer2 = new MyObserver();
		MyObservable varObservable = new MyObservable();
		varObservable.addObserver(observer1);
		varObservable.addObserver(observer2);
		varObservable.setData("haha");
	}

	private static void takeOrders(String bookName){
		orders.add(factory.getOrder(bookName));
	}

}
