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
		 * 享元模式测试
		 */
//		factory = FlyWeightFactory.getInstance();
//		takeOrders("三国演义");
//		takeOrders("水浒传");
//		takeOrders("封神榜");
//		takeOrders("三体");
//		takeOrders("红楼梦");
//		takeOrders("三国演义");
//		takeOrders("封神榜");
//		takeOrders("水浒传");
//
//		for (FlyWeight order : orders) {
//			order.cell();
//		}
//		// 打印生成的订单java对象数量
//		System.out.println("\n客户一共买了 " + orders.size() + " 本书! ");
//		// 打印生成的订单java对象数量
//		System.out.println("共生成了 " + factory.getTotalObjects()
//				+ " 个 FlyWeight java对象! ");
		
		/**
		 * 装饰者模式测试
		 */
//		IDecorator decorator = new ChildDecorator(new CoreDecorator());
//		decorator.doSomeThing();
		
		/**
		 * 观察者模式
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
