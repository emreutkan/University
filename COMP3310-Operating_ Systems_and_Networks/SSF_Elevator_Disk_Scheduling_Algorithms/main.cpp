#include <iostream>
#include <bits/stdc++.h>

using namespace std;


int size = 8;
void ElevatorAlgorithm(int arr[], int head, string direction)
{
    int disk_size = 100;
    int seek_count = 0;
    int distance, cur_track;
    vector<int> left, right;
    vector<int> seek_sequence;

    if (direction == "left")
        left.push_back(0);
    else if (direction == "right")
        right.push_back(disk_size - 1);

    for (int i = 0; i < size; i++) {
        if (arr[i] < head)
            left.push_back(arr[i]);
        if (arr[i] > head)
            right.push_back(arr[i]);
    }

    sort(left.begin(), left.end());
    sort(right.begin(), right.end());

    int run = 2;
    while (run--) {
        if (direction == "left") {
            for (int i = left.size() - 1; i >= 0; i--) {
                cur_track = left[i];
                seek_sequence.push_back(cur_track);
                distance = abs(cur_track - head);
                seek_count += distance;
                head = cur_track;
            }
            direction = "right";
        }
        else if (direction == "right") {
            for (int i = 0; i < right.size(); i++) {
                cur_track = right[i];
                seek_sequence.push_back(cur_track);
                distance = abs(cur_track - head);
                seek_count += distance;
                head = cur_track;
            }
            direction = "left";
        }
    }

    cout << "Seek Sequence is" << endl;

    for (int i = 0; i < seek_sequence.size(); i++) {
        cout << seek_sequence[i] << endl;
    }


    cout << "Total number of seek operations = " << seek_count << endl;
}

void ShortestSeekFirst(){
    int i,n,k,req[50],mov=0,cp,index[50],min,a[50],j=0,mini,cp1;
    printf("enter the current position\n");
    scanf("%d",&cp);
    //printf("enter the number of requests\n");
    // scanf("%d",&n);
    n = size;
    cp1=cp;
    printf("enter the request order\n");
    for(i=0;i<n;i++)
    {
        scanf("%d",&req[i]);
    }
    for(k=0;k<n;k++)
    {
        for(i=0;i<n;i++)
        {
            index[i]=abs(cp-req[i]);
        }
        min=index[0];
        mini=0;
        for(i=1;i<n;i++)
        {
            if(min>index[i])
            {
                min=index[i];
                mini=i;
            }
        }
        a[j]=req[mini];
        j++;
        cp=req[mini];
        req[mini]=999;
    }
    printf("Seek sequence is : ");
    printf("\n");
    printf("%d",cp1);
    printf("\n");
    mov=mov+abs(cp1-a[0]);
    printf("%d",a[0]);
    for(i=1;i<n;i++)
    {
        mov=mov+abs(a[i]-a[i-1]);
        printf("\n");
        printf("%d",a[i]);
    }
    printf("\n");
    printf("total head movement = %d\n",mov);
}

int main() {

    ShortestSeekFirst();
    int head;
    string direction;
    int arr[size];
    cout << "enter initial head position" << endl;
    cin >> head ;
    cout << "enter direction left or right" << endl;
    cin >> direction;
    cout << "enter direction left or right" << endl;
    cout << "fixed input size is 8 defined at line 7 " << endl;
    cout << "Enter sequence" << endl;
    for (int i = 0; i < size ; ++i) {
        cin >> arr[i];
    }
    ElevatorAlgorithm(arr, head, direction);
    return 0;
}