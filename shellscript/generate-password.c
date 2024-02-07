
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{ // main

int longitud = 0;

char *parametroN = NULL;

if( argc > 0 )
{
	parametroN = argv[1];
} // if


if( parametroN == NULL ){
	printf("Agrega un parametro numerico !");
	printf("\n");
	return 0;
} // if


sscanf( parametroN, "%d", &longitud );
printf("%d", longitud );
printf("\n");






printf("\n");
printf("numeros ascii 48-57");
printf("\n");
for( int i = 48; i < 58; i++ )
{
	printf("%c ", i );
}
printf("\n");
printf("\n");


printf("letras ascii 65-90");
printf("\n");
for( int i = 65; i < 91; i++ )
{
	printf("%c ", i );
} // for
printf("\n");



// 48 - 57
int digitoRandom = 0;

printf("\n");
printf("numero random:");
printf("\n");
for( int i = 0; i < longitud; i++ )
{
	digitoRandom = rand() % 10;
	printf("%d ", digitoRandom + rand() );
}
printf("\n");
printf("\n");





return 0;
} // main
