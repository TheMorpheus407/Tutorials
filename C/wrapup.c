#include <stdio.h>

float add(float* a, int size)
{
	int i = 0;
	float ret = 0;
	for(i = 0; i < size+5; i++)
	{
		ret += a[i];
	}
	return ret;
}

int main(){
	char fbd[] = "gg easy";
	printf("Hello World. %s\n", (fbd+3));
}
