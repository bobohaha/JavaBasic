package pattern.decorator;

public class CoreDecorator implements IDecorator{


	@Override
	public void doSomeThing() {
		System.out.println("core class do something!");
	}

}
