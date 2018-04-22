package com;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {

	private List<Block> chain;

	public Blockchain() {
		this.chain = new ArrayList<Block>();
		// method to generate genesis block
		chain.add(generateGenesis());
	}

	private Block generateGenesis() {

		Block genesis = new Block("0x200", new java.util.Date(), "<contract>", "JaiScoin");
		// set the previous hash to null as its the first one
		genesis.setPreviousHash(null);
		// compute the hash for genesis block
		genesis.computeHash();

		// return the genesis block
		return genesis;
	}

	// Method to add block
	public void addBlock(Block blk) {
		Block newBlock = blk;
		blk.setPreviousHash(chain.get(chain.size() - 1).getHash());
		newBlock.computeHash();
		this.chain.add(newBlock);
	}

	// Method to display the contents of the Blockchain
	public void printBlockChain() {

		for (Block b : chain) {
			System.out.println("Block " + chain.indexOf(b));
			System.out.println("Version: " + b.getVersion());
			System.out.println("Currency: "+b.getCoin());
			System.out.println("Data: " + b.getData());
			System.out.println("Date: " + b.getTimestamp());
			System.out.println("Previous Hash: " + b.getPreviousHash());
			System.out.println("Hash: " + b.getHash());
			System.out.println();

		}

	}
	//fetch latest block of chain
	public Block getLatestBlock() {
		return this.chain.get(chain.size()-1);
	}
//check validity of the chain, if the chain is tampered or not
	public void isValid() {
		for (int i = chain.size()-1;i>0; i--) {
			if(   !(chain.get(i).getHash().equals(chain.get(i).computeHash())) )
			{ System.out.println("Invalid Block!");
			return;}
			if(   !(chain.get(i).getPreviousHash().equals(chain.get(i-1).computeHash())) )
			{ System.out.println("Invalid Block!");
			return;}
			
		}
		System.out.println("Valid Block!");
	}
}
