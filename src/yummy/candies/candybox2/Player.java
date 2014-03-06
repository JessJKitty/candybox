/***
 * Player class to store all information pertaining to the 
 * user of the the Candy Box! app. Stores information such 
 * as candies, lollipops, etc., and keeps most information
 * concisely in one place
 * 
 * Jessica Xu and Kelwen Peng
 */

package yummy.candies.candybox2;

import android.os.Parcel;
import android.os.Parcelable;


public class Player implements Parcelable {
	
	// initialize variables
	public int candies;
	public int lollipops = 5;
	public int hp = 100;
	public int eatencandies;
	public int sword = 1;
	public int lastcompquest;
	public int scrolls;
	public int potions;
	public int plantedlollipops;
	public int candiespersecond = 1;
	public int wishes;
	
	// get candies
	public int getCandies() {
		return candies;
	}
	
	// change candies
	public void setCandies(int candies) {
		this.candies = candies;
	}

	// get lollipops
	public int getLollipops() {
		return lollipops;
	}

	// change lollipop
	public void setLollipops(int lollipops) {
		this.lollipops = lollipops;
	}

	// get max Hp
	public int getHp() {
		return 100 + (int) Math.sqrt(eatencandies);
	}

	// change max Hp
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	// get eaten candies
	public int getEatenCandies(){
		return this.eatencandies;
	}
	
	// change eaten candies
	public void setEatenCandies(int eatencandies){
		this.eatencandies = eatencandies;
	}

	// get sword
	public int getSword() {
		return sword;
	}

	// change sword
	public void setSword(int sword) {
		this.sword = sword;
	}

	// get last completed quest
	public int getLastcompquest() {
		return lastcompquest;
	}

	// change last completed quest
	public void setLastcompquest(int lastcompquest) {
		this.lastcompquest = lastcompquest;
	}
	
	// get number of scrolls
	public int getScrolls() {
		return scrolls;
	}
	
	// change number of scrolls
	public void setScrolls(int scrolls) {
		this.scrolls = scrolls;
	}
	
	// get number of potions
	public int getPotions() {
		return potions;
	}
	
	// change number of potions
	public void setPotions(int potions) {
		this.potions = potions;
	}
	
	// get number of planted lollipops
	public int getPlantedLollipops() {
		return plantedlollipops;
	}

	// change number of planted lollipops
	public void setPlantedLollipops(int plantedlollipops) {
		this.plantedlollipops = plantedlollipops;
	}

	// calculate damage on enemies
	public int Attack() {
		return sword*5;
	}
	
	// get number of candies received per second
	public int getCandiesPerSecond() {
		return candiespersecond;
	}
	
	// set number of candies received per second
	public void setCandiesPerSecond(int candiespersecond){
		this.candiespersecond = candiespersecond;
	}
	
	// get number of wishes
	public int getWishes() {
		return wishes;
	}
	
	// set number of wishes
	public void setWishes(int wishes) {
		this.wishes = wishes;
	}
	
	// required to implement Parcelable, but frankly, we won't use this method...yet 
	@Override
	public int describeContents() {
		// 
		return 0;
	}

	// converts information from Player in a Parcel object
	@Override
	public void writeToParcel(Parcel parcel, int flag) {
		// TODO Auto-generated method stub
		parcel.writeInt(candies);
		parcel.writeInt(lollipops);
		parcel.writeInt(hp);
		parcel.writeInt(eatencandies);
		parcel.writeInt(sword);
		parcel.writeInt(lastcompquest);
		parcel.writeInt(scrolls);
		parcel.writeInt(potions);
		parcel.writeInt(plantedlollipops);
		parcel.writeInt(candiespersecond);
		parcel.writeInt(wishes);
	}

	// constructs Player based on information in Parcel
	public Player(Parcel in){
		
		this.candies = in.readInt();
		this.lollipops = in.readInt();
		this.hp = in.readInt();
		this.eatencandies = in.readInt();
		this.sword = in.readInt();
		this.lastcompquest = in.readInt();
		this.scrolls = in.readInt();
		this.potions = in.readInt();
		this.plantedlollipops = in.readInt();
		this.candiespersecond = in.readInt();
		this.wishes = in.readInt();
	}
	
	// constructs Player if new player
	public Player(){
		this.candies = 0;
		this.lollipops = 0;
		this.hp = 100;
		this.eatencandies = 0;
		this.sword = 1;
		this.lastcompquest = 0;
		this.scrolls = 0;
		this.potions = 0;
		this.plantedlollipops  = 0;
		this.candiespersecond = 1;
		this.wishes = 0;
	}
	
	// converts Parcelable file to Player
	public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
     public Player createFromParcel(Parcel in) {
         return new Player(in);
     }

     public Player[] newArray(int size) {
         return new Player[size];
     }
 };

}
