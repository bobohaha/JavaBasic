package pattern.flyweight;

public class BookOrder implements FlyWeight{
	private String name;
	BookOrder(String name){
		this.name = name;
	}
	@Override
	public void cell() {
		System.out.println("����һ���飬����Ϊ'"+this.name+"'");
	}

}
