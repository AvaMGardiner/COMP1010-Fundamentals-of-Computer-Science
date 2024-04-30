//DON'T UNCOMMENT THE FOLLOWING THREE LINES.
//[46410961]
//[AVA GARDINER] (as on eStudent)
//[X] Declaration from student that they haven't viewed another person's code for this assignment. 
//(Add a x between the brackets)

package shopping;

public class CartItem {
	public StockItem item;
	public int quantity;
	public int discountPercentage;
	
	/**
	 * 
	 * @param it for item
	 * @param q for quantity (set the higher of 0 and q to quantity)
	 * set discountPercentage to 0
	 */
	public CartItem(StockItem it, int q) {
		item = it;
		discountPercentage = 0;
		
		if(q > 0)
			quantity = q;
	}
	
	/**
	 * 
	 * @param it for item, assume its not null
	 * @param q for quantity (set the higher of 0 and q to quantity)
	 * @param discount (constrain discount between 0 and 100 before copying into discountPercentage).
	 * for example, 
	 * if discount = -5, discountPercentage should become 0
	 * if discount = 12, discountPercentage should become 12
	 * if discount = 150, discountPercentage should become 100
	 */
	public CartItem(StockItem it, int q, int discount) {
		this(it, q);
		
		if(discount <= 0)
			discountPercentage = 0;
		else if (discount >= 100)
			discountPercentage = 100;
		else
			discountPercentage = discount;
	}

	/**
	 * 
	 * @return the total cost of the item (after discounting if so)
	 * for example,
	 * if the unitPrice of item is 1.5, quantity is 3, discountPercentage is 0, return 4.5
	 * if the unitPrice of item is 1.5, quantity is 3, discountPercentage is 20, return 3.6
	 */
	public double totalCost() {
		double decimal = discountPercentage / 100.0;
		double value  = decimal * item.unitPrice * quantity;
		
		return (item.unitPrice * quantity) - value;
	}
	
	/**
	 * 
	 * @return the discount value per unit
	 * for example, 
	 * if the unitPrice of item is 1.5 and discountPercentage is 20, return 0.3
	 */
	public double getDiscountPerUnit() {
		double decimal = discountPercentage / 100.0;
		double value  = decimal * item.unitPrice;
				
		return value;
	}
	
	/**
	 * 
	 * @return the discounted price for the calling object.
	 * for example, if unitPrice = 2.4, discountPercentage = 10, return 2.16
	 */
	public double getDiscountedUnitPrice() {
		return item.unitPrice - getDiscountPerUnit();
	}
	
	/**
	 * 
	 * @return total discount for this item
	 * for example, if unitPrice = 2.4, quantity = 4, discountPercentage = 10, return 0.96
	 */
	public double getTotalDiscount() {
		return getDiscountPerUnit() * quantity;
	}
	
	/**
	 * @param other
	 * @return
	 * 1 if calling object is "more than" parameter object
	 * -1 if calling object is "less than" parameter object
	 * 0 if calling object is "equal to" parameter object
	 * 
	 * IMPORTANT!!! 
	 * Ordering criterion: 
	 * First: StockItem instance variable (item)
	 * Second: Discount percentage
	 */
	public int compareTo(CartItem other) {
		if(this.item != other.item)
		{
			if(this.item.compareTo(other.item) == 1)
				return 1;
			else
				return -1;
		}
		else if(this.discountPercentage != other.discountPercentage)
		{
			if(this.discountPercentage > other.discountPercentage)
				return 1;
			else
				return -1;
		}
		else
		{
			return 0;
		}
	}
	
	/**
     * return String version of the item
     * NOTE: an asterisk (*) should be added in front of discounted unit prices
     * If the final unit price is of the form: 
     *      - 5.18 or 5.181 or 5.189 or 5.1899999: display 5.18 
     *      - 5.1: display 5.1 
     *      - 5 (or 5.0): display 5
     * for example,
     * if item represents name = "BIBS", unitPrice = 5.9, quantity = 6, discountPercentage = 0,
     *             return "BIBS (6 @ $5.9)"
     * if item represents name = "BIBS", unitPrice = 5.9, quantity = 6, discountPercentage = 10,
     *             return "BIBS (6 @ *$5.31)"
     */
	public String toString() {
		if(discountPercentage == 0)
			return this.item.name + " (" + quantity + " @ $" + displayFormat(getDiscountedUnitPrice()) + ")";
		else
			return this.item.name + " (" + quantity + " @ *$" + displayFormat(getDiscountedUnitPrice()) + ")";
	}
	
	private String displayFormat(double price) {
		String priceInString = price + "";
		String correctDisplay = "";
		int decimalCount = 0, decimalPlace = 0;
		boolean removeZero = true;
		
		for(int index = 0; index < priceInString.length(); index++)
		{
			if(decimalCount <= 2)
			{
				if(decimalCount > 0)
				{
					decimalCount++;
					
					if(priceInString.charAt(index) != '0')
						removeZero = false;
				}
				
				if(priceInString.charAt(index) == '.')
				{
					decimalCount++;
					decimalPlace = index;
				}
				
				correctDisplay += priceInString.charAt(index);
			}
			else {
				break;
			}
		}
		
		if(removeZero)
			correctDisplay = correctDisplay.substring(0, decimalPlace);  
		
		return correctDisplay;
	}
}
