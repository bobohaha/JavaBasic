package pattern.decorator;

public class ChildDecorator extends Decorator {

	public ChildDecorator(IDecorator decorator) {
		super(decorator);
	}
	@Override
	public void doSomeThing() {
		System.out.println("child class do somethind!");
		decorator.doSomeThing();
	}

}
