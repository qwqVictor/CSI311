
/**
 * Driver class for testing purpose only
 * 
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Randomizer {
	boolean[] bucket;
	Random random;
	public Randomizer() {
		bucket = new boolean[101];
		random = new Random();
		for (int i = 0; i < 101; i++)
			bucket[i] = false;
	}

	public int rand() {
		int value;
		while (bucket[(value = random.nextInt(100) + 1)]);
		bucket[value] = true;
		return value;
	}
}

public class Driver {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		Randomizer random = new Randomizer();
		Scanner scn = new Scanner(System.in);
		List<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < 20; i++) {
			array.add(random.rand());
		}

		System.out.printf("array: %s\n", array);

		for (int value : array) {
			tree.insert(value);
		}

		System.out.printf("The tree %s", tree);

		System.err.printf("\nThe node you want to remove? Value: ");
		int node = scn.nextInt();

		tree.remove(node);

		System.out.printf("New tree %s", tree);

		int newRand = random.rand();
		System.err.printf("I'll add a random number %d to the tree. Yes?", newRand);
		if (scn.nextLine() != "No") {
			tree.insert(newRand);
			System.out.printf("New tree %s", tree);
		}
		scn.close();
	}
}
