package assignementOne;

import java.util.ArrayList;
import java.util.Scanner;


public class MainProgram {

	private static Set handleInputId(String input, Set special, ArrayList<Set> others) {
		int id1;
		Set set1;
		if(Integer.parseInt(input) == 0) {
			set1 = special;
		} else {
			id1 = Integer.parseInt(input) - 1;
			set1 = others.get(id1);
		}
		return set1;
	}
	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		ArrayList<Set> subsets = new ArrayList<Set>();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> subsetsSize = new ArrayList<Integer>();

		boolean universeNumberEntered = false;
		boolean universeEntered = false;
		boolean setNumberEntered = false;
		boolean allSubSetsNumbersEntered = false;
		boolean allSetsEntered = false;
		boolean exitFlag = false;

		String input = new String();
		Set universe = new Set(list);
		int universeSize = 0;
		int numbersOfSets = 0;

		Set lastOperationResult = null;

		while (!exitFlag) {
			try {
				if (input.equals("*'*exit*'*")) {
					exitFlag = true;
				} else if (!universeNumberEntered) {
					System.out.println("Enter the number of "
							+ "elements in the Universe :");
					input = scn.nextLine();
					universeSize = Integer.parseInt(input);
					universeNumberEntered = true;
				} else if (!universeEntered) {
					for (int i = list.size();
							i < universeSize;i++) {
						System.out.println("Enter Element "
							+(i+1)+" in the Universe :");
						input = scn.nextLine();
						if (list.contains(input)) {
						throw new RuntimeException();
						}
						list.add(input);
					}
					universe = new Set(list);
					list = new ArrayList<String>();
					universeEntered = true;
				} else if(!setNumberEntered) {
					System.out.println("Enter the number of subsets :");
					input = scn.nextLine();
					numbersOfSets = Integer.parseInt(input);
					setNumberEntered = true;
				} else if(!allSubSetsNumbersEntered) {
					for(int i = subsetsSize.size(); i < numbersOfSets;i++) {
						System.out.println("Enter subset "+(i+1)+" size :");
						input = scn.nextLine();
						if(Integer.parseInt(input) > universeSize) {
							throw new RuntimeException();
						}
						subsetsSize.add(Integer.parseInt(input));
					}
					allSubSetsNumbersEntered = true;
				} else if(!allSetsEntered) {
					for(int i = subsets.size(); i < numbersOfSets; i++) {
						for(int j = list.size(); j < subsetsSize.get(i); j++) {
							System.out.println("Enter Element "+(j+1)+" in the Set "+(i+1)+" :");
							input = scn.nextLine();
							if(universe.contains(input) && !list.contains(input)) {
								list.add(input);
							} else {
								throw new Exception();
							}
						}
						subsets.add(new Set(list));
						list = new ArrayList<String>();
					}
					allSetsEntered = true;
				} else {
					System.out.println("Choose your operation(Enter *'*help*'* for more information) :");
					input = scn.nextLine();
					if (input.equals("*'*print*'*")) {
						System.out.println("Enter the id of the set you want to perform the operation on(or enter 0 for universe) : ");
						input = scn.nextLine();
						Set set1 = handleInputId(input, universe, subsets);
						set1.printSet();
					} else if (input.equals("*'*int*'*")) {
						System.out.println("Enter the id of the first set you want to perform the operation on(or enter 0 for universe) : ");
						input = scn.nextLine();
						Set set1 = handleInputId(input, universe, subsets);
						System.out.println("Enter the id of the second set you want to perform the operation on(or enter 0 for universe) : ");
						input = scn.nextLine();
						Set set2 = handleInputId(input, universe, subsets);
						lastOperationResult = Set.intersection(set1, set2);
						lastOperationResult.printSet();
					} else if (input.equals("*'*uni*'*")) {
						System.out.println("Enter the id of the first set you want to perform the operation on(or enter 0 for universe) : ");
						input = scn.nextLine();
						Set set1 = handleInputId(input, universe, subsets);
						System.out.println("Enter the id of the second set you want to perform the operation on(or enter 0 for universe) : ");
						input = scn.nextLine();
						Set set2 = handleInputId(input, universe, subsets);
						lastOperationResult = Set.union(set1, set2);
						lastOperationResult.printSet();
					} else if (input.equals("*'*comp*'*")) {
						System.out.println("Enter the id of the set you want to perform the operation on(or enter 0 for universe) : ");
						input = scn.nextLine();
						Set set1 = handleInputId(input, universe, subsets);
						lastOperationResult = Set.complement(universe, set1); 
						lastOperationResult.printSet();
					} else if (input.equals("*'*exit*'*")) {
						exitFlag = true;
					} else if (input.equals("*'*uniL*'*")) {
						if (lastOperationResult == null) {
							System.out.println("You haven't done any operation yet!");
							throw new RuntimeException();
						}
						System.out.println("Enter the id of the set you want to perform the operation on(or enter 0 for universe) : ");
						input = scn.nextLine();
						Set set1 = handleInputId(input, universe, subsets);
						lastOperationResult = Set.union(set1, lastOperationResult);
						lastOperationResult.printSet();
					} else if (input.equals("*'*intL*'*")) {
						if (lastOperationResult == null) {
							System.out.println("You haven't done any operation yet!");
							throw new RuntimeException();
						}
						System.out.println("Enter the id of the set you want to perform the operation on(or enter 0 for universe) : ");
						input = scn.nextLine();
						Set set1 = handleInputId(input, universe, subsets);
						lastOperationResult = Set.intersection(set1, lastOperationResult);
						lastOperationResult.printSet();
					} else if (input.equals("*'*compL*'*")) {
						if (lastOperationResult == null) {
							System.out.println("You haven't done any operation yet!");
							throw new RuntimeException();
						}
						lastOperationResult = Set.complement(universe, lastOperationResult);
						lastOperationResult.printSet();
					} else if (input.equals("*'*printS*'*")) {
						for(int i = 0; i < subsets.size(); i++) {
							System.out.print("Set "+(i+1)+" :");
							subsets.get(i).printSet();
						}
					} else if (input.equals("*'*help*'*")) {
						System.out.println("1- Enter *'*print*'* to print a set");
						System.out.println("2- Enter *'*int*'* to get the intersection of two sets");
						System.out.println("3- Enter *'*uni*'* to get the union of two sets");
						System.out.println("4- Enter *'*comp*'* to get complement of a set");
						System.out.println("5- Enter *'*printS*'* to print all the sets");
						System.out.println("6- Enter *'*intL*'* to get intersection of a set with the last operation result");
						System.out.println("7- Enter *'*uniL*'* to get union of a set with the last operation result");
						System.out.println("8- Enter *'*compL*'* to get the complement of the last operation result");
						System.out.println("9- Enter *'*exit*'* to close the program");
					} else {
						System.out.println("invalid Command");
					}
				}
			} catch (Exception e) {
				System.out.println("Invalid Input !");
			}
		}
		scn.close();
	}

}
