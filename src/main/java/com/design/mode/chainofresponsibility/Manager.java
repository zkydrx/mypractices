package com.design.mode.chainofresponsibility;

/**
 * A beginner of the chain The resposibility of manager is to get a project
 */

public class Manager implements Chain {
	private Chain nextChain = null;
	private String responsibility = "Get Project";;

	public Manager() {
	}

	public void addChain(Chain c) {
		nextChain = c;
	}

	public Chain getChain() {
		return nextChain;
	}

	public void sendToChain(String mesg) {
		if (mesg.equals(responsibility)) {
			System.out.println("A manager  -->  Get a Project");
		} else {
			if (nextChain != null) {
				nextChain.sendToChain(mesg);
			}
		}
	}

}