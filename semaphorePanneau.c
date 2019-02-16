#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>
#include<pthread.h>
#include<time.h>
#include<unistd.h>
#include<semaphore.h>

sem_t semaphore[10];
int indexColleur = 0;
pthread_mutex_t mutexColleur;
pthread_mutex_t verification[10];

typedef struct{
  int texte[100];
  int nb_place;
}panneau;

void* lirePanneau(void * arg){
  panneau *temp = (panneau*)arg;
  while(1){
    int choix = rand()%100+0;
    int choixTab = rand()%10;
    sleep(rand()%8+5);
    sem_wait(&semaphore[choixTab]);
    printf("%d\n", temp[choixTab].texte[choix]);
    sem_post(&semaphore[choixTab]);
  }
  pthread_exit(NULL);
}

void* changerAffiche(void * arg){
  panneau *temp = (panneau*) arg;
  while(1){
    sleep(3);
    int choixPanneauAchanger = rand()%10;
    pthread_mutex_lock(&verification[choixPanneauAchanger]);

      for(int i=0; i<temp[choixPanneauAchanger].nb_place;i++){
          sem_wait(&semaphore[choixPanneauAchanger]);
      }

      printf("je change le PANNEAUX %d\n", choixPanneauAchanger);
        for(int i=0;i<100;i++){
          temp[choixPanneauAchanger].texte[i] = rand()%100+0;
        }

      for(int i=0; i<temp[choixPanneauAchanger].nb_place;i++){
          sem_post(&semaphore[choixPanneauAchanger]);
      }
    pthread_mutex_unlock(&verification[choixPanneauAchanger]);
  }
  pthread_exit(NULL);
}

int main(int argc, char * argv[]){
  srand(time(NULL));
  panneau p[10];
  for(int j=0;j<10;j++){
    p[j].nb_place = rand()%10+20;
    for(int i=0;i<100;i++){
      p[j].texte[i] = rand()%100+0;
    }
  }
  for(int i=0;i<10;i++){
    sem_init(&semaphore[i],0,p[i].nb_place);
    pthread_mutex_init(&verification[i], NULL);
  }

  pthread_t mesLecteurs[100];
  pthread_t colleurAffiche[10];
  for(int i=0; i<100;i++){
    int ret = pthread_create(&mesLecteurs[i],NULL,lirePanneau,(void *) p);
  }
  for(int i=0;i<10;i++){
    int ret2 = pthread_create(&colleurAffiche[i],NULL,changerAffiche,(void*) p);
  }
  for(int i=0; i<100;i++){
    pthread_join(mesLecteurs[i],NULL);
  }
  for(int i=0;i<10;i++){
    pthread_join(colleurAffiche[i],NULL);
  }

  exit(EXIT_SUCCESS);

}
