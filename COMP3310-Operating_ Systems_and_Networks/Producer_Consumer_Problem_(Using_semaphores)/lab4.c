#include <pthread.h>
#include <semaphore.h>
#include <stdlib.h>
#include <stdio.h>
#define MaxItems 5 // Maximum items a producer can produce or a consumer can consume
#define BufferSize 5 // Size of the buffer
sem_t empty;
sem_t full;
int in = 0;
int out = 0;
int buffer[BufferSize];
pthread_mutex_t mutex;
void producer(int pno)
{
 int item;
 int i;
 for( i = 0; i < MaxItems; i++) {
 item = rand(); // Produce an random item
 sem_wait(&empty); //........  // down(empty)
 pthread_mutex_lock(&mutex); //........  // down(mutex)
 buffer[in] = item;
 printf("Producer %d: Insert Item %d at %d\n", pno,buffer[in],in);
 in = (in+1)%BufferSize;
 pthread_mutex_unlock(&mutex);  // ........ UP MUTEX
 sem_post(&full);  //........ UP FULL

 }
}
void consumer(int cno)
{
int i;
 for( i = 0; i < MaxItems; i++) {
 sem_wait(&full); // ........ DOWN FULL
 pthread_mutex_lock(&mutex); //........ DOWN MUTEX
 int item = buffer[out];
 printf("Consumer %d: Remove Item %d from %d\n",cno,item, out);
 out = (out+1)%BufferSize;
 pthread_mutex_unlock(&mutex);  // ........ UP MUTEX
 sem_post(&empty);  // ........ UP EMPTY
 }
}
int main()
{
 pthread_t pro[5],con[5];
 pthread_mutex_init(&mutex, NULL);
 sem_init(&empty,0,BufferSize);
 sem_init(&full,0,0);
 int a[5] = {1,2,3,4,5}; //Just used for numbering the producer and consumer
int i;
 for( i = 0; i < 5; i++) {
 pthread_create(&pro[i], NULL, producer, &a[i]);
 }
 for( i = 0; i < 5; i++) {
 pthread_create(&con[i], NULL, consumer, &a[i]);
 }
 for( i = 0; i < 5; i++) {
 pthread_join(pro[i], NULL);
 }
 for( i = 0; i < 5; i++) {
 pthread_join(con[i], NULL);
 }
 pthread_mutex_destroy(&mutex);
 sem_destroy(&empty);
 sem_destroy(&full);
 return 0;

}