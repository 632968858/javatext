/*package basejava;

import java.math.BigDecimal;

class Item{
	BigDecimal price;
	int num;
	String name;
	public void setPrice(BigDecimal p){
		this.price=p;
	}
	public void setNum(int n){
		this.num=n;
	}
	public void setname(String name){
		this.name=name;
	}
	public BigDecimal getPrice(){
		return price;
	}
	public int getNum(){
		return num;
	}
	public String getname(){
		return name;
	}
}
class Shop{
	Item [] item;
	String name;
	public void setname(String name){
		this.name=name;
	}
	public String getname(){
		return name;
	}
	public void setItem(Item[] item){
		this.item=item;
	}
	public Item[] getItems(){
		return item;
	}
}
class Cart{
	Shop[] shops;
	public Cart(Shop[] shops){
		this.shops=shops
	}
}

public class Key {
	public int buy(Cart cart){    //传入购物车
		int count=0;
		for(Shop shop in cart){    //购物车中的每个商店
			for(Item item in shop) { //商店中的每种商品
					count += item.price * item.num //单价和数量
			}     
		}
		return count; //返回总金额来确定
	}
}
*/