package pattern.decorator;

public abstract class Decorator implements IDecorator{
	
	public IDecorator decorator;
	
	public Decorator(IDecorator decorator){
		this.decorator = decorator;
	}

}
