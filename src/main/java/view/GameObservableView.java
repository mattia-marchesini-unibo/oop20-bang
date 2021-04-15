package view;

import java.util.List;

import libs.observe.*;
import model.Card;

public class GameObservableView {

	public ObservableElement<Character> character;
	public ObservableElement<String> name;
	public ObservableElement<Role> role;
	public ObservableElement<Integer> lifePoints;
	public ObservableElement<List<Card>> hand;
	public ObservableElement<List<SimplePlayer>> otherPlayer;
	public ObservableElement<Character> getCharacter() {
		return character;
	}
	public void setCharacter(ObservableElement<Character> character) {
		this.character = character;
	}
	public ObservableElement<String> getName() {
		return name;
	}
	public void setName(ObservableElement<String> name) {
		this.name = name;
	}
	public ObservableElement<Role> getRole() {
		return role;
	}
	public void setRole(ObservableElement<Role> role) {
		this.role = role;
	}
	public ObservableElement<Integer> getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(ObservableElement<Integer> lifePoints) {
		this.lifePoints = lifePoints;
	}
	public ObservableElement<List<Card>> getHand() {
		return hand;
	}
	public void setHand(ObservableElement<List<Card>> hand) {
		this.hand = hand;
	}
	public ObservableElement<List<SimplePlayer>> getOtherPlayer() {
		return otherPlayer;
	}
	public void setOtherPlayer(ObservableElement<List<SimplePlayer>> otherPlayer) {
		this.otherPlayer = otherPlayer;
	}
	
}
