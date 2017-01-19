#include <stdio.h>
#include <string.h>
#include <stdlib.h>


int main() {
	char *description;

	description = malloc(2000*sizeof(char));
	if(description == NULL)
	{
		return -1;
	}
	else
	{
		strcpy(description, "Dies ist eine Buchbeschreibung. Sie ist sehr gut.");
	}
	printf("%s\n", description);
	free(description);

	return 0;
}
