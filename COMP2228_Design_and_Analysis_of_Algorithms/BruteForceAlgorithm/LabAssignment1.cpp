#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;
const int rows = 8, columns = 8;
char area[rows][columns];

void fillGameArea(char area[rows][columns]) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            area[i][j] = ' ';
        }
    }
}

bool isvalidcoordinate(int row, int column) {
    if (row >= 0 && row < rows && column >= 0 && column < columns) {
        return true;
    }
    else {
        return false;
    }
}

void assignMonsters() {
    int c = 1;
    srand(time(NULL));
    int i = rand() % 8;
    int j = rand() % 8;
    area[i][j] = 'M';
    ///////////////////
    i = rand() % 8;
    j = rand() % 8;
    while (c < 5) {
        if (area[i][j] == 'M' || area[i + 1][j] == 'M' || area[i - 1][j] == 'M' || area[i + 2][j] == 'M' || area[i - 2][j] == 'M' || area[i][j + 1] == 'M' ||
            area[i][j - 1] == 'M' || area[i][j + 2] == 'M' || area[i][j - 2] == 'M' || area[i + 1][j + 1] == 'M' ||
            area[i - 1][j + 1] == 'M' || area[i - 1][j - 1] == 'M' || area[i + 1][j + 2] == 'M' || area[i - 1][j + 2] == 'M' || area[i + 1][j - 1] == 'M' ||
            area[i - 1][j - 2] == 'M' || area[i + 2][j + 2] == 'M' || area[i - 2][j + 2] == 'M' || area[i - 2][j - 2] == 'M' )
        {
            i = rand() % 8;
            j = rand() % 8;
            
        }
        else {
            area[i][j] = 'M';
            c++;
        }
    }
}

void assignHero() {
    srand(time(NULL));
    int i, j;
    do {
       i = rand() % 8;
       j = rand() % 8;
    } while (area[i][j] != ' ');
    area[i][j] = 'H';
}
    

void printgamearea(char area[rows][columns]) {
    for (int a = 0; a < rows; a++) {
        cout << a << " ";
    }
    cout << endl;
    for (int i = 0; i < rows; i++) {
        cout << i << " ";
        for (int j = 0; j < columns; j++) {
            cout << "[" << area[i][j] << "]";
        }
        cout << endl;
    }
}

int main()
{
    fillGameArea(area);
    printgamearea(area);
    cout << isvalidcoordinate(8, 8) << endl;
    cout << isvalidcoordinate(0, 0) << endl;
    cout << isvalidcoordinate(9, 5) << endl;
    assignMonsters();
    assignHero();
    printgamearea(area);

    int hrow = 0, hcol = 0;
    // find hero 
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            if (area[i][j] == 'H') {
                hrow = i;
                hcol = j;

                cout << "hero position: " << hrow << "," << hcol << endl;
                break;
            }
        }
    }

    // find monsters && store monsters
    int c = 0;
    int m[10];
    while (c < 10)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (area[i][j] == 'M') {
                    area[i][j] == ' ';
                    m[c] = i;
                    m[c + 1] = j;
                    c = c + 2;
                }
            }
        }

    // print locations 
    for (int i = 0; i < 10;) {
        cout << "monster " << (i / 2) + 1 << " position : " << m[i] << "," << m[i + 1] << endl;
        i = i + 2;
    }
    cout <<  "/***************/" << endl << endl;
    // 
    int STAMINA = 10;
    int GOLD = 0;
    int slayenmonsters = 0;
    int new_pos_x = 0;
    int new_pos_y = 1;
    int deletekey = 11;
    while (STAMINA > 0) {
        int closestDistance = 10000;
        int closestM = 1;
        for (int i = 0; i < 10; i = i + 2) { // 0 2 4 6 8 10
            int compare = abs(hrow - m[i]) + abs(hcol - m[i + 1]);
            if (compare < closestDistance) {
                closestM = (i / 2) + 1;
                closestDistance = compare;
                new_pos_x = m[i];
                deletekey = i;
                new_pos_y = m[i+1];
            }
        }
        if (STAMINA == 0) {
            cout << "stamina reached 0 cannot continue " << endl;
            break;
        }
        else if (STAMINA < closestDistance) {
            cout << "Stamina =  " << STAMINA << " closest monster distance " << closestDistance << endl;  cout << endl;
            cout << "not enough stamina cannot continue" << endl;
            break;
        }
        else if (STAMINA >= closestDistance) {
            // change heroes position to slayen monster

            //
            slayenmonsters++;
            
            //  add traveled directions
            int x = m[deletekey]-hrow;
            if (x > 0) {
                while (x > 0) {
                    cout << "down , ";
                    x--;
                }
            }
            else if (x < 0) {
                while (x < 0) {
                    cout << "up , ";
                    x++;
                }
            }
            int y = m[deletekey + 1] - hcol;
            if (y > 0) {
                while (y > 0) {
                    cout << "right , ";
                    y--;
                }
            }
            else if (y < 0) {
                while (y < 0) {
                    cout << "left , ";
                    y++;
                }
            }
            cout << closestM << ". monster " << " has slayen      " << endl << endl;
            //
            hrow = new_pos_x;
            hcol = new_pos_y;
            m[deletekey] = 999;
            m[deletekey+1] = 999;
            STAMINA = STAMINA - closestDistance;
            GOLD = GOLD + 5;
        }
    }
    cout << endl << "/********/" << endl;
    cout << "Slayen Monsters = " << slayenmonsters << endl;
    cout << "Earned Gold = " << GOLD << endl;
    cout << "Remaining Stamina = " << STAMINA << endl;
    cout << "/********/";
 
}


// codes that i tried while learning the concept 

    /* // calculate which monster is closest to heroes starting point

        int closestM = 0;
        int minXdiff = hrow - m[0];
        int minYdiff = hcol - m[1];
        int mindiss = hrow - m[0] + hcol - m[1];
        for (int i = 2; i < 10;) {
            // m[i] current monsters X
            // m[i + 1] current monsters Y
            int Xdiff = hrow - m[i];
            int Ydiff = hcol - m[i + 1];
            Xdiff = abs(Xdiff);
            Ydiff = abs(Ydiff);
            if (Xdiff < minXdiff && Ydiff < minYdiff) {
                    closestM = i;
                    mindiss = hrow - m[i] + hcol - m[i+1];
            }

            i = i + 2;
        }

    */

    /*
        // loops 5 times because we have 5 monsters goes to closest monster, repositions the hero and goes to the next monster until stamina is not enough or reaches 0
        int GOLD = 0;
        int STAMINA = 10;
        int slayenmonsters = 0;

        int closestM = 1;
        int minXdiff = abs(hrow - m[0]);
        int minYdiff = abs(hcol - m[1]);
        int closestDistance = abs(hrow - m[0]) + abs(hcol - m[1]);
        for (int i = 2; i < 10;) {
            // m[i] current monsters X
            // m[i + 1] current monsters Y
            int Xdiff = abs(hrow - m[i]);
            int Ydiff = abs(hcol - m[i + 1]);
            int currentmonstersdistance = Xdiff + Ydiff;
            if (closestDistance > currentmonstersdistance) {
                //
                closestM = (i / 2) + 1;
                closestDistance = currentmonstersdistance;
                // if enough stamina exist slay the monster
                if (STAMINA > 0 && STAMINA >= closestDistance) {

                    // change heroes position to slayen monster
                    hrow = m[i];
                    hcol = m[i + 1];
                    //
                    slayenmonsters++;
                    STAMINA = STAMINA - closestDistance;
                    GOLD = GOLD + 5;
                }
                else if (STAMINA == 0) {
                    cout << "stamina reached 0 cannot continue " << endl;
                }
                else if (STAMINA > 0 && STAMINA < closestDistance) {
                    cout << "not enough stamina cannot continue" << endl;
                }

            }
            i = i + 2;
        }
            cout << "Slayen Monsters = " << slayenmonsters << endl;
            cout << "Earned Gold = " << GOLD << endl;
            cout << "Remaining Stamina = " << STAMINA << endl;


    */
    /*
        int GOLD = 0;
        int STAMINA = 10;
        int slayenmonsters = 0;
        int closestDistance = 0;
        int new_pos_x = 0;
        int new_pos_y = 1;
        while (STAMINA > 0) {
            for (int i = 0; i < 10;) { // 0 2 4 6 8 10
                int closestM = 1;
                int minXdiff = abs(hrow - m[i]);
                int minYdiff = abs(hcol - m[i + 1]);
                closestDistance = minXdiff + minYdiff;
                // m[i] current monsters X
                // m[i + 1] current monsters Y
                int Xdiff = abs(hrow - m[i + 2]);
                int Ydiff = abs(hcol - m[i + 3]);
                int currentmonstersdistance = Xdiff + Ydiff;
                if (closestDistance > currentmonstersdistance) {
                    //
                    closestM = (i / 2) + 1;
                    cout << "closest m " << closestM << endl;
                    closestDistance = currentmonstersdistance;
                    new_pos_x = m[closestM * 2 - 1];
                    new_pos_y = m[closestM * 2];

                }
                i = i + 2;
            }
            if (STAMINA >= closestDistance) {
                // change heroes position to slayen monster
                hrow = new_pos_x;
                hcol = new_pos_y;
                //
                slayenmonsters++;
                STAMINA = STAMINA - closestDistance;
                GOLD = GOLD + 5;
            }
            else if (STAMINA == 0) {
                cout << "stamina reached 0 cannot continue " << endl;
                break;
            }
            else if (STAMINA < closestDistance) {
                cout << "Stamina = " << STAMINA << "closest monster distance " << closestDistance << endl;
                cout << "not enough stamina cannot continue" << endl;
                break;
            }
        }
            cout << "Slayen Monsters = " << slayenmonsters << endl;
            cout << "Earned Gold = " << GOLD << endl;
            cout << "Remaining Stamina = " << STAMINA << endl;
    */
    /*
       int STAMINA = 10;
        int GOLD = 0;
        int slayenmonsters = 0;
        int new_pos_x = 0;
        int new_pos_y = 1;
        int deletekey = 11;
        while (STAMINA > 0) {
            int closestDistance = 10000;
            int closestM = 1;
            for (int i = 0; i < 10; i = i + 2) { // 0 2 4 6 8 10
                int compare = abs(hrow - m[i]) + abs(hcol - m[i + 1]);
                if (compare < closestDistance) {
                    closestM = (i / 2) + 1;
                    closestDistance = compare;
                    new_pos_x = m[i];
                    deletekey = i;
                    new_pos_y = m[i+1];
                }
            }
            if (STAMINA == 0) {
                cout << "stamina reached 0 cannot continue " << endl;
                break;
            }
            else if (STAMINA < closestDistance) {
                cout << "Stamina = " << STAMINA << "closest monster distance " << closestDistance << endl;
                cout << "not enough stamina cannot continue" << endl;
                break;
            }
            if (STAMINA >= closestDistance) {
                // change heroes position to slayen monster
                hrow = new_pos_x;
                hcol = new_pos_y;
                //
                slayenmonsters++;
                cout << "monster " << closestM << " has slayen" << endl;
                //  add traveled directions
                m[deletekey] = 999;
                m[deletekey+1] = 999;
                STAMINA = STAMINA - closestDistance;
                GOLD = GOLD + 5;
            }


        }

        cout << "Slayen Monsters = " << slayenmonsters << endl;
        cout << "Earned Gold = " << GOLD << endl;
        cout << "Remaining Stamina = " << STAMINA << endl;
*/
