#include <iostream>

using namespace std;

string keys(char c) {
    if (c == '2') return "abc";
    if (c == '3') return "def";
    if (c == '4') return "ghi";
    if (c == '5') return "jkl";
    if (c == '6') return "mno";
    if (c == '7') return "pqrs";
    if (c == '8') return "tuv";
    if (c == '9') return "wxyz";
    return "";
}

int combinationsPossible(string input, string output[]) {
    if (input.length() == 0) {
        output[0] = "";
        return 1;
    }

    if (input.length() == 1) {
        string key = keys(input[0]);
        for (int i = 0; i < key.length(); ++i) {
            output[i] = string(1, key[i]);
        }
        return key.length();
    }

    string inputremain = input.substr(1);
    int rest = combinationsPossible(inputremain, output);
    string key = keys(input[0]);
    for (int i = 0; i < key.length() - 1; ++i) {
        for (int j = 0; j < rest; ++j) {
            output[j + (i + 1) * rest] = output[j];
        }

    }
    for (int i = 0; i < key.length(); ++i) {
        for (int j = 0; j < rest; ++j) {
            output[i * rest + j] += key[i];
        }

    }
    return rest * key.length();
}

int main(){
    string input;
    string output[9999];
    cout << "input the numbers ";
    cin >> input;
    int allcomb = combinationsPossible(input,output);
    string words[] = {"foo","bar","baz","foobar","emo","cap","car","cat","da","ec","fc","emre"};
    string match[9999];
    string foundmatch;
    bool matchfound;
    int matchCount = -1;
    for (int i = 0; i < allcomb ; ++i) {
        cout << output[i] << " ";
        for (int j = 0; j < sizeof(words) / sizeof(words[0]); ++j) {
            if (output[i] == words[j]){
                matchCount++;
                matchfound = true;
                foundmatch = words[j];
            }
        }
        if (matchfound == true){
            match[matchCount] = foundmatch;
        }
    }
    cout << endl;
    cout << "matches: ";
    for (int i = 0; i <= matchCount; ++i) {
        cout << match[i] << ", ";
    }
    cout << endl;
    cout << "number of possible combinations " << allcomb << endl;
    cout << "number of words in the match list " << sizeof(words) / sizeof(words[0]) << endl;
    cout << "number of words that match " << matchCount+1 << endl;
    // 3763 emre
}