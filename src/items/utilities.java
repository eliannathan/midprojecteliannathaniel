package items;

public class utilities extends item {

		protected String utilType;

		public String getUtilType() {
			return utilType;
		}

		public void setUtilType(String utilType) {
			this.utilType = utilType;
		}

		
		public utilities(String itemType, String utilType) {
			super(itemType);
			this.utilType = utilType;
		}

		public int price() {
			int utilTypeSize = 0,price = 0;
			if (utilType.equals("Pencil")) {
				utilTypeSize = 1000;
			} else if ( utilType.equals("Eraser")) {
				utilTypeSize = 3000;
			}
			price = utilTypeSize+500;
			return price;
			
		}
		
		public void cusPrint() {
			if(utilType.equals("Pencil")) {
				System.out.print("| "+itemType+" | "+utilType+ " | Rp. 1.000,00 + [500 tax]|");
				}else if (utilType.equals("Eraser")) {
				System.out.print("| "+itemType+" | "+utilType+ " | Rp. 3.000,00 + [500 tax]|");
				}
		}
		
		public void print() {
			System.out.print("| "+itemType+" | "+utilType+ " |");
		}
				
}
