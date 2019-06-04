import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestAB {

	public void doA(String s,String s2){
		System.out.println(s+" from a and "+ s2 +"from b");
	}

	static{
		System.out.println("-----------1ab----------");
	}
	{
		System.out.println("-----------2ab-----------");
	}

	public static void main(String[] args) {
		new TestB();
		String code = "学java";
		try {
			System.out.println(code.getBytes("GB2312").length);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Class classes = Class.forName("TestAB");
			try {
				Object o1 = classes.newInstance();
				try {
					Method method = classes.getMethod("doA", String.class,String.class);
					try {
						method.invoke(o1, new Object[]{"aaaaaaaa","bbbbbbbbbbbb"});
//						System.out.println(method);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
