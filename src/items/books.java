package items;

public class books extends item {
	
	protected String size;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public books(String itemType, String size) {
		super(itemType);
		this.size = size;
	}

	public int price() {
		int sizePrice = 0;
		int price = 0;
		if (size.equals("S")) {
			sizePrice = 2500;
		} else if ( size.equals("L")) {
			sizePrice = 5000;
		}
		price = sizePrice+500;
		return price;
		
	}
	
	public void cusPrint() {
		
		if(size.equals("S")) 
			{
			System.out.print("| "+itemType + " | " + size + " | Rp. 2.500,00 + [500 tax]|");			
			}else if (size.equals("L")) 
			{		
			System.out.print("| "+itemType+" | "+size+ " | Rp. 5.000,00 + [500 tax]|");				
			}
	}
	
	public void print() {
		System.out.print("| "+itemType+" | "+size+ " | - |");
	}

}
