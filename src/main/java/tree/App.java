package tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		new App().proceed();
	}

	public void proceed() {
		// Expérience

		// ROOT
		ArrayList<Integer> rootKey = new ArrayList<>();
		rootKey.add(100);

		BTreeNode root = new BTreeNode(1, false);
		root.setKeys(rootKey);

		// Tree partie droite
		ArrayList<Integer> firstFloorKeysRight = new ArrayList<>();
		firstFloorKeysRight.add(130);
		firstFloorKeysRight.add(180);

		ArrayList<Integer> secondFloor1KeysRight = new ArrayList<>();
		secondFloor1KeysRight.add(110);
		secondFloor1KeysRight.add(120);

		ArrayList<Integer> secondFloor2KeysRight = new ArrayList<>();
		secondFloor2KeysRight.add(140);
		secondFloor2KeysRight.add(160);

		ArrayList<Integer> secondFloor3KeysRight = new ArrayList<>();
		secondFloor3KeysRight.add(190);
		secondFloor3KeysRight.add(240);
		secondFloor3KeysRight.add(260);

		BTreeNode firstChildRight = new BTreeNode(2, false);
		firstChildRight.setKeys(firstFloorKeysRight);

		BTreeNode secondChildRight = new BTreeNode(3, true);
		secondChildRight.setKeys(secondFloor1KeysRight);

		BTreeNode thirdChildRight = new BTreeNode(3, true);
		thirdChildRight.setKeys(secondFloor2KeysRight);

		BTreeNode fourthChildRight = new BTreeNode(3, true);
		fourthChildRight.setKeys(secondFloor3KeysRight);

		// Tree partie gauche
		ArrayList<Integer> firstFloorKeysLeft = new ArrayList<>();
		firstFloorKeysLeft.add(35);
		firstFloorKeysLeft.add(65);

		ArrayList<Integer> secondFloor1KeysLeft = new ArrayList<>();
		secondFloor1KeysLeft.add(10);
		secondFloor1KeysLeft.add(20);

		ArrayList<Integer> secondFloor2KeysLeft = new ArrayList<>();
		secondFloor2KeysLeft.add(40);
		secondFloor2KeysLeft.add(50);

		ArrayList<Integer> secondFloor3KeysLeft = new ArrayList<>();
		secondFloor3KeysLeft.add(70);
		secondFloor3KeysLeft.add(80);
		secondFloor3KeysLeft.add(90);

		BTreeNode firstChildLeft = new BTreeNode(2, false);
		firstChildLeft.setKeys(firstFloorKeysLeft);

		BTreeNode secondChildLeft = new BTreeNode(3, true);
		secondChildLeft.setKeys(secondFloor1KeysLeft);

		BTreeNode thirdChildLeft = new BTreeNode(3, true);
		thirdChildLeft.setKeys(secondFloor2KeysLeft);

		BTreeNode fourthChildLeft = new BTreeNode(3, true);
		fourthChildLeft.setKeys(secondFloor3KeysLeft);


		// Construction de l'arbre
		firstChildLeft.addChild(secondChildLeft);
		firstChildLeft.addChild(thirdChildLeft);
		firstChildLeft.addChild(fourthChildLeft);

		firstChildRight.addChild(secondChildRight);
		firstChildRight.addChild(thirdChildRight);
		firstChildRight.addChild(fourthChildRight);

		root.addChild(firstChildLeft);
		root.addChild(firstChildRight);

		Btree tree = new Btree(3, root);
		System.out.println(tree.search(10));
	}
}
