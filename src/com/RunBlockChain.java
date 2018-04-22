package com;

public class RunBlockChain {

	public static void main(String args[]) {

		Blockchain jaiScoin = new Blockchain();

		Block first = new Block("0x200", new java.util.Date(), "<Contract>", "JaiScoin");
		Block second = new Block("0x200", new java.util.Date(), "<Contract>", "JaiScoin");
		Block third = new Block("0x200", new java.util.Date(), "<Contract>", "JaiScoin");

		jaiScoin.addBlock(first);
		jaiScoin.addBlock(second);
		jaiScoin.addBlock(third);
		
		//tampering the chain now
	//jaiScoin.getLatestBlock().setPreviousHash("asd2223!!dasf//");
		
		jaiScoin.printBlockChain();
		
		jaiScoin.isValid();
	}

}
