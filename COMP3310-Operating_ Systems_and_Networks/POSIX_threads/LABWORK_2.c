#include<stdio.h>
#include<pthread.h>
int num = -1;
// int i = 0;
pthread_mutex_t lock;
	FILE *fp;
void num1()
{
	 //	FILE *fp;
 //	fp = fopen("1.txt", "w");
 while(num<10)
 {
 	pthread_mutex_lock(&lock);
 	num++;
 	printf("thread 1 %d\n",num);
 	// fprintf(fp, "%s\n","thread 1 ",num);
 	int current = num;
 	 fprintf(fp, "%s\n","thread 1 ",current);
 	pthread_mutex_unlock(&lock);
	sleep(2);
 }
}
void num2()
{
	//	 	FILE *fp;
 //	fp = fopen("1.txt", "w");
 while(num<10)
 {
 		sleep(1);
 	pthread_mutex_lock(&lock);
 	num++;
 	printf("Thread 2 %d\n",num);
 	fprintf(fp, "%s\n","thread 2 ",num);
 	pthread_mutex_unlock(&lock);
 	sleep(1);
 }
}
void main()
{
	//FILE *fp;
	fp = fopen("1.txt", "w");
	//int i = 0;
	pthread_t t1,t2;
		pthread_mutex_init(&lock, NULL);
 	pthread_create(&t1,NULL,num1,NULL);
 	pthread_create(&t2,NULL,num2,NULL);
 	pthread_join(t1,NULL);
 	pthread_join(t2,NULL);
 	
}
