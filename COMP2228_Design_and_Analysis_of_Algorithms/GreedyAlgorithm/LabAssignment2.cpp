/*
 * Greedy shopping. There are two markets with five different items on sale.
 * Each market has a money point that you can spend instead of paying. As a customer,
 * You will buy each item and try to minimize the money spent on items.
 * As an example, if the values are :
 * int market1Prices[] = {5,7,12,3,4};
 * int market2Prices[] = {8,4,9,9,6};
 * int market1Point = 8;
 * int market2Point = 18;
 * The money spent from the greedy solution should be 4 TL with the market order
 * Markets = { MARKET1,MARKET2,MARKET2,MARKET1,MARKET1,} and market points
 * Market1 points = 0 Market2 points = 5
 * For the same prices, if we had 3 and 22 as market points, respectively. The result would be
 *
 * Additional Money spent = 4 TL
 * Market1 points = 0 Market2 points = 1
 * Markets = { MARKET2,MARKET2,MARKET2,MARKET1,MARKET1,}
 *
 * Try to understand how the greedy approach works by analyzing the output.
 * Keep in mind that, when you buy a product, you can not partially pay it with points.
 * It is either money or points
 *
 * For grading, I'm going to check the existence of functions described in below. The function signatures
 * and their names may be different, and the output may be "slightly different" than the presented on above.
 * However, the main goal is minimizing the money spent...
 */
#include <iostream>

using namespace std;

#define MARKET1 true
#define MARKET2 false
#define ITEM_COUNT 5
int market1Prices[] = { 5, 7, 12, 3, 4 };
int market2Prices[] = { 8, 4, 9, 9, 6 };
//bool markets[ITEM_COUNT];
int money_spent = 0;
string markets[ITEM_COUNT];
//Change the values in below to calculate different result
int market1Point = 8;
int market2Point = 18;

void printMarkets() {
	for (int i = 0; i < ITEM_COUNT; i++) {
		cout << markets[i] << ", ";
	}

}
// Return the money spent and assign each market to the "markets" variable
void buyItems() {
	int previousPrice = 0;
	int currentPrice = 0;
	int previousCombinationPrice = 0;
	int currentCombinationPrice = 0;
	int minprice = 10000;
	int maxprice = 0;
	while (market1Point != 0) {
		// if it reaches a point where furter purchase with points impossible break the loop
		for (int c = 0; c < ITEM_COUNT; c++) {
			if (market1Prices[c] < minprice) {
				minprice = market1Prices[c];
			}
		}
		if (minprice > market1Point) {
			break;
		}
		for (int a = 0; a < ITEM_COUNT; a++) {
			if (market1Prices[a] == market1Point) {
				market1Point = 0;
				markets[a] = "market1 ";
				market2Prices[a] = 100;
				break;
			}
		}
		//
		for (int i = 0; i < ITEM_COUNT; i++) {
			for (int j = i + 1; j < ITEM_COUNT; j++) {
				previousCombinationPrice = currentCombinationPrice;
				currentCombinationPrice = market1Prices[i] + market1Prices[j];
				// if combination is able to be bought with all points
				if (currentCombinationPrice == market1Point) {
					market1Point = 0;
					markets[i] = "market1 ";
					markets[j] = "market1 ";
					market2Prices[i] = 100;
					market2Prices[j] = 100;
					break;
				}
				// if combination isnt able to be bought with all points. select the largest combination below points 
				else if (market1Point >= currentCombinationPrice && market1Point >= previousCombinationPrice) {
					if (currentCombinationPrice > previousCombinationPrice) {
						market1Point -= currentCombinationPrice;
						markets[i] = "market1 ";
						market1Prices[i] = 100;
						markets[j] = "market1 ";
						market1Prices[j] = 100;
						market2Prices[i] = 100;
						market2Prices[j] = 100;
					}
					else {
						market1Point -= previousCombinationPrice;
						markets[i] = "market1 ";
						market1Prices[i] = 100;
						markets[j] = "market1 ";
						market1Prices[j] = 100;
						market2Prices[i] = 100;
						market2Prices[j] = 100;
					}
				}
			}

			if (market1Prices[i] < market1Point) {
				for (int x = 1; x < ITEM_COUNT; x++) {
					if (market1Point > market1Prices[i] && market1Point > market1Prices[x])
						if (market1Prices[i] > market1Prices[x]) {
							market1Point -= market1Prices[i];
							markets[i] = "market1 ";
							market1Prices[i] = 100;
							market2Prices[i] = 100;
						}
						else {
							market1Point -= market1Prices[x];
							markets[x] = "market1 ";
							market1Prices[x] = 100;
							market2Prices[x] = 100;
						}
				}
			}
		}
	}
	previousPrice = 0;	currentPrice = 0;	previousCombinationPrice = 0;	currentCombinationPrice = 0;	minprice = 10000;	maxprice = 0;
	/*
			
		while (market2Point != 0) {
			// if it reaches a point where furter purchase with points impossible break the loop
			for (int c = 0; c < ITEM_COUNT; c++) {
				if (market2Prices[c] < minprice) {
					minprice = market2Prices[c];
				}
			}
			if (minprice > market2Point) {
				break;
			}

			for (int i = 0; i < ITEM_COUNT; i++) {
				// compare single items with points
				// if single item is able to be bought with all points
				if (market2Prices[i] == market2Point && markets[i] != "market1 ") {
					market2Point = 0;
					markets[i] = "market2 ";
				}
				// if single item isnt able to be bought with all points. select the largest price below points
				else if (market2Prices[i] < market2Point) {
					for (int x = 1; x < ITEM_COUNT; x++) {
						if (market2Point > market2Prices[i] && market2Point > market2Prices[x])
							if (market2Prices[i] > market2Prices[x] && markets[i] != "market1 ") {
								market2Point -= market2Prices[i];
								markets[i] = "market2 ";
							}
							else if (markets[x] != "market1 ") {
								market2Point -= market2Prices[x];
								markets[x] = "market2 ";
							}
					}
				}
				// compare multiple combinations (2) with points
				else {
					for (int j = i + 1; j < ITEM_COUNT; j++) {
						previousCombinationPrice = currentCombinationPrice;
						currentCombinationPrice = market2Prices[i] + market2Prices[j];
						// if combination is able to be bought with all points
						if (currentCombinationPrice == market2Point && markets[i] != "market1 " && markets[j] != "market1 ") {
							market2Point = 0;
							markets[i] = "market2 ";
							markets[j] = "market2 ";
						}
						// if combination isnt able to be bought with all points. select the largest combination below points
						else if (market2Point >= currentCombinationPrice && market2Point >= previousCombinationPrice && markets[i] != "market1 " && markets[j] != "market1 ") {
							if (currentCombinationPrice > previousCombinationPrice) {
								market2Point -= currentCombinationPrice;
								markets[i] = "market2 ";
								markets[j] = "market2 ";
							}
							else {
								market2Point -= previousCombinationPrice;
								markets[i] = "market2 ";
								markets[j] = "market2 ";
							}
						}
					}
				}
			}
		}
		*/
	/*
	* while (market2Point != 0) {
		for (int c = 0; c < ITEM_COUNT; c++) {
			if (market2Prices[c] < minprice) {
				minprice = market2Prices[c];
			}
		}
		if (minprice > market2Point) {
			break;
		}

		for (int i = 0; i < ITEM_COUNT; i++) {
			for (int a = 0; a < ITEM_COUNT; a++) {
				if (market2Prices[a] == market2Point && markets[a] != "market1 ") {
					market2Point = 0;
					markets[a] = "market2 ";
					break;
				}
			}
			if (market2Prices[i] < market2Point) {
				for (int x = 1; x < ITEM_COUNT; x++) {
					if (market2Point > market2Prices[i] && market2Point > market2Prices[x])
						if (market2Prices[i] > market2Prices[x] && markets[i] != "market1 ") {
							market2Point -= market2Prices[i];
							markets[i] = "market2 ";
							market2Prices[i] = 100;
						}
						else if (markets[x] != "market1 ") {
							market2Point -= market2Prices[x];
							markets[x] = "market2 ";
							market2Prices[x] = 100;
						}
				}
			}
			else {
				for (int j = i + 1; j < ITEM_COUNT; j++) {
					previousCombinationPrice = currentCombinationPrice;
					currentCombinationPrice = market2Prices[i] + market2Prices[j];
					if (currentCombinationPrice == market2Point && markets[i] != "market1 " && markets[j] != "market1 ") {
						market2Point = 0;
						markets[i] = "market2 ";
						markets[j] = "market2 ";
						break;
					}
					else if (market2Point >= currentCombinationPrice && market2Point >= previousCombinationPrice) {
						if (currentCombinationPrice > previousCombinationPrice && markets[i] != "market1 " && markets[j] != "market1 ") {
							market2Point -= currentCombinationPrice;
							markets[i] = "market2 ";
							market2Prices[i] = 100;
							markets[j] = "market2 ";
							market2Prices[j] = 100;
						}
						else if (markets[i] != "market1 " && markets[j] != "market1 ") {
							market2Point -= previousCombinationPrice;
							markets[i] = "market2 ";
							market2Prices[i] = 100;
							markets[j] = "market2 ";
							market2Prices[j] = 100;
						}
					}
				}
			}
		}
	}
	*/
	for (int b = 0; b < ITEM_COUNT; b++) {
		if (markets[b] != "market1 ") {
			for (int c = b; c < ITEM_COUNT; c++) {
				if (market2Prices[c] < minprice) {
					minprice = market2Prices[c];
				}
			}
			for (int i = b; i < ITEM_COUNT; i++) {
				for (int a = 0; a < ITEM_COUNT; a++) {
					if (market2Prices[a] == market2Point) {
						market2Point = 0;
						markets[a] = "market2 ";
						break;
					}
				}
				for (int j = b + 1; j < ITEM_COUNT; j++) {
					previousCombinationPrice = currentCombinationPrice;
					currentCombinationPrice = market2Prices[i] + market2Prices[j];
					if (currentCombinationPrice == market2Point) {
						market2Point = 0;
						markets[i] = "market2 ";
						markets[j] = "market2 ";
						break;
					}
					else if (market2Point >= currentCombinationPrice && market2Point >= previousCombinationPrice) {
						if (currentCombinationPrice > previousCombinationPrice) {
							market2Point -= currentCombinationPrice;
							markets[i] = "market2 ";
							market2Prices[i] = 100;
							markets[j] = "market2 ";
							market2Prices[j] = 100;
						}
						else {
							market2Point -= previousCombinationPrice;
							markets[i] = "market2 ";
							market2Prices[i] = 100;
							markets[j] = "market2 ";
							market2Prices[j] = 100;
						}
					}
				}
				if (market2Prices[i] < market2Point) {
					for (int x = b + 1; x < ITEM_COUNT; x++) {
						if (market2Point > market2Prices[i] && market2Point > market2Prices[x])
							if (market2Prices[i] > market2Prices[x]) {
								market2Point -= market2Prices[i];
								markets[i] = "market2 ";
								market2Prices[i] = 100;
							}
							else {
								market2Point -= market2Prices[x];
								markets[x] = "market2 ";
								market2Prices[x] = 100;
							}
					}
				}
			}
		}
	}
	for (int i = 0; i < ITEM_COUNT; i++) {
		if (markets[i] != "market1 " && markets[i] != "market2 ") {
			if (market1Prices[i] > market2Prices[i]) {
				money_spent += market2Prices[i];
				markets[i] = "market2 ";
				}
			else if (market1Prices[i] < market2Prices[i]) {
				money_spent += market1Prices[i];
				markets[i] = "market1 ";
			}
		}
	}
}
	
int main() {
	cout << "for market1points = 8, and market2points = 18" << endl;
	cout << endl;
	buyItems();
	printMarkets();
	cout << endl;
	cout << "money spent = " << money_spent << endl;
	cout << "remaning market1 points = " << market1Point << endl;
	cout << "remaning market2 points = " << market2Point << endl;
	cout << endl;
}	

/*********************************************************************************************************************************************************************************************************************/
// previously tried codes that dont work as intended 

/*

void buyItems_test1() {
	// buy items until points reach a point where further purchase is impossible without spending extra money
		// if the both markets points are able to buy the same item at different prices select the lowest one 
	// then eliminate bought items from both lists and compare others and select the market that has the cheapest 
	for (int i = 0; i < ITEM_COUNT; i++) {
		if (market1Prices[i] <= market1Point && market2Prices[i] <= market2Point) {
			if (market1Prices[i] > market2Prices[i]) {
				markets[i] = "market1";
				market1Point -= market1Prices[i];
			}
			else {
				markets[i] = "market2";
				market2Point -= market2Prices[i];
			}
		}
		else if (market1Prices[i] <= market1Point && market2Prices[i] >= market2Point) {
			markets[i] = "market1";
			market1Point -= market1Prices[i];
		}
		else if (market1Prices[i] >= market1Point && market2Prices[i] <= market2Point) {
			markets[i] = "market2";
			market2Point -= market2Prices[i];
		}
		else {
			if (market1Prices[i] >= market2Prices[i]) {
				markets[i] = "market2";
				money_spent += market2Prices[i];
			}
			}
			else {
				markets[i] = "market1";
				money_spent += market1Prices[i];
			}
		}
	}
}
*/

/*

		// select one market and buy all items until it reaches a point where points are zero
		while (market1Point >= 0) {
			for (int j = 0; j < ITEM_COUNT; j++) {
				if (market1Prices[j] - market1Point == 0) {
					markets[j] = "market 1, ";
					market1Point -= market1Prices[j];
					cout << "testest1" << endl;
				}
				else {
					for (int k = j + 1; k < ITEM_COUNT; k++) {
						if (market1Prices[j] + market1Prices[k] <= market1Point) {
							markets[j] = "market1, ";
							markets[k] = "market1, ";
							market1Point -= market1Prices[j] + market1Prices[k];
							cout << "testest2" << endl;
						}
					}
				}
				else {

				}
			}
		}
		while (market2Point >= 0) {
			for (int j = 0; j < ITEM_COUNT; j++) {
				if (market2Prices[j] - market2Point == 0 && markets[j] != "market 1, ") {
					markets[j] = "market 2, ";
					market2Point -= market2Prices[j];
					cout << "testest11" << endl;
				}
				else {
					for (int k = j + 1; k < ITEM_COUNT; k++) {
						if (market2Prices[j] + market2Prices[k] <= market2Point && markets[j] != "market1, " && markets[k] != "market1, ") {
							markets[j] = "market2, ";
							markets[k] = "market2, ";
							market2Point -= market2Prices[j] + market2Prices[k];
							cout << "testest22" << endl;
						}
					}
				}
			}
		}
	}
	
	*/

/*

// Return the money spent and assign each market to the "markets" variable
void buyItems() {
	int previousPrice = 0;
	int currentPrice = 0;
	int previousCombinationPrice = 0;
	int currentCombinationPrice = 0;
	int minprice = 10000;
	int maxprice = 0;
	while (market1Point != 0) {
		// if it reaches a point where furter purchase with points impossible break the loop
		for (int c = 0; c < ITEM_COUNT; c++) {
			if (market1Prices[c] < minprice) {
				minprice = market1Prices[c];
			}
		}
		if (minprice > market1Point) {
			break;
		}

		for (int i = 0; i < ITEM_COUNT; i++) {
			// compare single items with points
			// if single item is able to be bought with all points
			if (market1Prices[i] == market1Point) {
				market1Point = 0;
				markets[i] = "market1 ";
			}
			// if single item isnt able to be bought with all points. select the largest price below points
			else if (market1Prices[i] < market1Point) {
				for (int x = 1; x < ITEM_COUNT; x++) {
					if (market1Point > market1Prices[i] && market1Point > market1Prices[x])
						if (market1Prices[i] > market1Prices[x]) {
							market1Point -= market1Prices[i];
							markets[i] = "market1 ";
						}
						else {
							market1Point -= market1Prices[x];
							markets[x] = "market1 ";
						}
				}
			}
			// compare multiple combinations (2) with points
			else {
				for (int j = i + 1; j < ITEM_COUNT; j++) {
					previousCombinationPrice = currentCombinationPrice;
					currentCombinationPrice = market1Prices[i] + market1Prices[j];
					// if combination is able to be bought with all points
					if (currentCombinationPrice == market1Point) {
						market1Point = 0;
						markets[i] = "market1 ";
						markets[j] = "market1 ";
					}
					// if combination isnt able to be bought with all points. select the largest combination below points
					else if (market1Point >= currentCombinationPrice && market1Point >= previousCombinationPrice) {
						if (currentCombinationPrice > previousCombinationPrice) {
							market1Point -= currentCombinationPrice;
							markets[i] = "market1 ";
							markets[j] = "market1 ";
						}
						else {
							market1Point -= previousCombinationPrice;
							markets[i] = "market1 ";
							markets[j] = "market1 ";
						}
					}
				}
			}
		}
	}
	/*
		previousPrice = 0;	currentPrice = 0;	previousCombinationPrice = 0;	currentCombinationPrice = 0;	minprice = 10000;	maxprice = 0;
	while (market2Point != 0) {
		// if it reaches a point where furter purchase with points impossible break the loop
		for (int c = 0; c < ITEM_COUNT; c++) {
			if (market2Prices[c] < minprice) {
				minprice = market2Prices[c];
			}
		}
		if (minprice > market2Point) {
			break;
		}

		for (int i = 0; i < ITEM_COUNT; i++) {
			// compare single items with points
			// if single item is able to be bought with all points
			if (market2Prices[i] == market2Point && markets[i] != "market1 ") {
				market2Point = 0;
				markets[i] = "market2 ";
			}
			// if single item isnt able to be bought with all points. select the largest price below points
			else if (market2Prices[i] < market2Point) {
				for (int x = 1; x < ITEM_COUNT; x++) {
					if (market2Point > market2Prices[i] && market2Point > market2Prices[x])
						if (market2Prices[i] > market2Prices[x] && markets[i] != "market1 ") {
							market2Point -= market2Prices[i];
							markets[i] = "market2 ";
						}
						else if (markets[x] != "market1 ") {
							market2Point -= market2Prices[x];
							markets[x] = "market2 ";
						}
				}
			}
			// compare multiple combinations (2) with points
			else {
				for (int j = i + 1; j < ITEM_COUNT; j++) {
					previousCombinationPrice = currentCombinationPrice;
					currentCombinationPrice = market2Prices[i] + market2Prices[j];
					// if combination is able to be bought with all points
					if (currentCombinationPrice == market2Point && markets[i] != "market1 " && markets[j] != "market1 ") {
						market2Point = 0;
						markets[i] = "market2 ";
						markets[j] = "market2 ";
					}
					// if combination isnt able to be bought with all points. select the largest combination below points
					else if (market2Point >= currentCombinationPrice && market2Point >= previousCombinationPrice && markets[i] != "market1 " && markets[j] != "market1 ") {
						if (currentCombinationPrice > previousCombinationPrice) {
							market2Point -= currentCombinationPrice;
							markets[i] = "market2 ";
							markets[j] = "market2 ";
						}
						else {
							market2Point -= previousCombinationPrice;
							markets[i] = "market2 ";
							markets[j] = "market2 ";
						}
					}
				}
			}
		}
	}
	*/