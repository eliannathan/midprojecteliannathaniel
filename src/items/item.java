package items;

public abstract class item {
	protected String itemType;


	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public item(String itemType) {
		this.itemType = itemType;
	}
	
	public abstract int price();
	
	public abstract void cusPrint();
	
	public abstract void print();
	
}
