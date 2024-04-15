#include<stdio.h>

void main() {
    int nop, i, j;
    int wt[20], tt[20], b[20], p[20], proc[20];
    int total_wt = 0, total_tt = 0;
    float awt, att;

    printf("Enter the number of processes: ");
    scanf("%d", &nop);

    for (i = 0; i < nop; i++) {
        printf("Enter the process no, burst time and priority\n");
        scanf("%d %d %d", &proc[i], &b[i], &p[i]);
        wt[i] = 0;
        tt[i] = 0;
    }

    for (i = 0; i < nop; i++) {
        for (j = i + 1; j < nop; j++) {
            if (p[i] > p[j]) {
                int temp = p[i];
                p[i] = p[j];
                p[j] = temp;

                temp = b[i];
                b[i] = b[j];
                b[j] = temp;

                temp = proc[i];
                proc[i] = proc[j];
                proc[j] = temp;
            }
        }
    }

    for (i = 0; i < nop; i++) {
        tt[i] = b[i] + wt[i];
        total_tt += tt[i];
        if (i < nop - 1) {
            wt[i + 1] = tt[i];
        }
        total_wt += wt[i];
    }

    printf("\npno\tbtime\tatime\twtime\tttime\n");
    for (i = 0; i < nop; i++) {
        printf("P%d\t%d\t%d\t%d\t%d\n", proc[i], b[i], p[i], wt[i], tt[i]);
    }

    awt = (float)total_wt / nop;
    att = (float)total_tt / nop;

    printf("\nThe average waiting time is:%.5f\n", awt);
    printf("The average turn around time is:%.5f\n", att);
}
