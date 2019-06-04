package pattern.singleton;

public class SingletonWithNoSyn {
	
	static{
		System.out.println("SingletonWithNoSyn is init!");
	}
	
	private SingletonWithNoSyn(){
		System.out.println("SingletonWithNoSyn is create!");
	}
	private static SingletonWithNoSyn singleton = new SingletonWithNoSyn();
	
	public static SingletonWithNoSyn getInstance(){
		return singleton;
	}
	public static void createString(){
		System.out.println("createString in Singleton");
	}

}
