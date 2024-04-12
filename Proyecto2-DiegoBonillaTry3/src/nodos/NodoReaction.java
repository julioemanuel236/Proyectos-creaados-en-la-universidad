package nodos;

import doMain.Person;

public class NodoReaction {
	
	private Person follower,user;
	private int reaction;
	
	private NodoReaction nextNod;
	
	public NodoReaction(int reaction) {
		this.reaction = reaction;
	}

	public NodoReaction(Person follower,Person user) {
		super();
		this.follower = follower;
		this.user = user;
		this.nextNod = null;
	}
	
	

	public void setReaction(int reaction) {
		this.reaction = reaction;
	}
		

	public Person getFollower() {
		return follower;
	}

	public void setFollower(Person follower) {
		this.follower = follower;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public int getReaction() {
		return reaction;
	}

	public NodoReaction getNextNod() {
		return nextNod;
	}

	public void setNextNod(NodoReaction nextNod) {
		this.nextNod = nextNod;
	}

	@Override
	public String toString() {
		return "Reacccion: " + follower + " -> " + user;
	}

}
