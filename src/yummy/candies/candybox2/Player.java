package yummy.candies.candybox2;

public class Player {
	
	public int candies;
	public int lollipops;
	public int hp = 100;
	public int eatencandies;
	public int sword;
	public int lastcompquest;
	public int scrolls;
	public int potions;
	
	
	public int getCandies() {
		return candies;
	}

	public void setCandies(int candies) {
		this.candies = candies;
	}

	public int getLollipops() {
		return lollipops;
	}

	public void setLollipops(int lollipops) {
		this.lollipops = lollipops;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getEatenCandies(){
		return this.eatencandies;
	}
	
	public void setEatenCandies(int eatencandies){
		this.eatencandies = eatencandies;
	}

	public int getSword() {
		return sword;
	}

	public void setSword(int sword) {
		this.sword = sword;
	}

	public int getLastcompquest() {
		return lastcompquest;
	}

	public void setLastcompquest(int lastcompquest) {
		this.lastcompquest = lastcompquest;
	}
	
	public int getScrolls() {
		return scrolls;
	}
	
	public void setScrolls(int scrolls) {
		this.scrolls = scrolls;
	}
	
	public int getPotions() {
		return potions;
	}
	
	public void setPotions(int potions) {
		this.potions = potions;
	}

}
