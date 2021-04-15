package view;

import java.util.List;

import libs.observe.*;
import model.Card;

public class GameObservableView {

	public ObservableElement<String> character;
	public ObservableElement<String> role;
	public ObservableElement<Integer> lifePoints;
	public ObservableElement<List<Integer>> hand;
	public ObservableElement<List<Integer>> otherPlayer;
	public ObservableElement<List<Integer>> otherLft;
	public ObservableElement<List<List<Integer>>> otherBluCard;
	public ObservableElement<List<Integer>> otherNumCard;
	
	public ObservableElement<String> getCharacter() {
		return character;
	}
	public void setCharacter(ObservableElement<String> character) {
		this.character = character;
	}
	public ObservableElement<String> getRole() {
		return role;
	}
	public void setRole(ObservableElement<String> role) {
		this.role = role;
	}
	public ObservableElement<Integer> getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(ObservableElement<Integer> lifePoints) {
		this.lifePoints = lifePoints;
	}
	public ObservableElement<List<Integer>> getHand() {
		return hand;
	}
	public void setHand(ObservableElement<List<Integer>> hand) {
		this.hand = hand;
	}
	public ObservableElement<List<Integer>> getOtherPlayer() {
		return otherPlayer;
	}
	public void setOtherPlayer(ObservableElement<List<Integer>> otherPlayer) {
		this.otherPlayer = otherPlayer;
	}
	public ObservableElement<List<Integer>> getOtherLft() {
		return otherLft;
	}
	public void setOtherLft(ObservableElement<List<Integer>> otherLft) {
		this.otherLft = otherLft;
	}
	public ObservableElement<List<List<Integer>>> getOtherBluCard() {
		return otherBluCard;
	}
	public void setOtherBluCard(ObservableElement<List<List<Integer>>> otherBluCard) {
		this.otherBluCard = otherBluCard;
	}
	public ObservableElement<List<Integer>> getOtherNumCard() {
		return otherNumCard;
	}
	public void setOtherNumCard(ObservableElement<List<Integer>> otherNumCard) {
		this.otherNumCard = otherNumCard;
	}
	
	
}