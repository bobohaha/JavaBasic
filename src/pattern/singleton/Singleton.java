package pattern.singleton;


public class Singleton{
	
	private Singleton(){
		System.out.println("singleton is create!");
	}
	
	private static class SingletonHolder{
		static{
			System.out.println("singletonHolder is create!");
		}
		private static Singleton singleton = new Singleton();
	}
	
	public static Singleton getInstance(){
		return SingletonHolder.singleton;
	}
}
	

