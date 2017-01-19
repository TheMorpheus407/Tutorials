#include <stdio.h>
#include <iostream>
#include <string>
#include <pthread.h>

void *laufenlassen(void *tid)
{
  long id = (long)tid;
  std::cout << "working hard at " << id << std::endl;
  pthread_exit(NULL);
}

int main(int argc, char const *argv[]) {
  void *status;
  pthread_t fred[10];
  pthread_attr_t attribute;
  pthread_attr_init(&attribute);
  pthread_attr_setdetachstate(&attribute, PTHREAD_CREATE_JOINABLE);
  for (long i = 0; i < 10; i++) {
    std::cout << "Creating thread " << i << std::endl;
    pthread_create(&fred[i], &attribute, laufenlassen, (void *)i);
    pthread_join(fred[i], &status);
    std::cout << "Fred " << i <<" ist fertig." << std::endl;
  }

  for(int i = 0; i < 10; i++)
  {
    pthread_join(fred[i], &status);
    std::cout << "Fred " << i <<" ist fertig." << std::endl;
  }
  return 0;
}
