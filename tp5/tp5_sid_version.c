
#include <stdio.h>

unsigned int Decryption_fct(unsigned int le)
{
	unsigned int be;



	// * Remplacez le code suivant par de l'assembleur en ligne
	// * en utilisant le moins d'instructions possible

	// be = (le & 0xff000000) | (le&0xff) << 16  | (le & 0xff00) | (le & 0xff0000) >> 16;



	asm volatile (


		"movl %1 , %%ebx;	\n\t"
		"movl %%ebx, %0; \n\t"
		"andl $0xff000000 , %0;\n\t"
		"andl $0xff , %1; \n\t"
		"shll $16 , %1; \n\t"
		"orl %1 , %0; \n\t"
		"movl %%ebx , %1; \n\t"
		"andl $0xff00 , %1; \n\t"
		"orl %1 , %0; \n\t"
		"movl %%ebx , %1; \n\t"
		"andl $0xff0000 , %1; \n\t"
		"shrl $16 , %1; \n\t"
		"orl %1 , %0; \n\t"
		:"=r" (be)  //sorties (s'il y a lieu)
		:"g" (le) //entrées
		:"ebx"  //registres modifiés (s'il y a lieu)
);
	/*
	 * Remplacez le code suivant par de l'assembleur en ligne
	 * en utilisant le moins d'instructions possible
	 */
	// be = (le & 0xff000000) | (le & 0xff) << 16  | (le & 0xff00) | (le & 0xff0000) >> 16;



	asm volatile (
		"movl %%eax, %%ecx;\n\t"
		"andl $0xff00ff00, %%ecx;\n\t"
		"movl %%eax, %%edx;\n\t"
		"andl $0xff0000, %%edx;\n\t"
		"shrl $16, %%edx;\n\t"
		"orl %%edx, %%ecx;\n\t"
		"movl %%eax, %%edx;\n\t"
		"andl $0xff, %%edx;\n\t"
		"shll $16, %%edx;\n\t"
		"orl %%edx, %%ecx;\n\t"
		"movl %%ecx, %%eax;"
		: "=a"(be)
		: "a"(le)
		: "ecx", "edx"
	);

>>>>>>> 6d88b2ec62ad6f363948c57a58e82c48ae0a74bc
	return be;
}

int main()
{
	unsigned int data = 0xeeaabbff;

	printf("Représentation crypte en little-endian:   %08x\n"
	       "Représentation decrypte en big-endian:    %08x\n",
	       data,
	       Decryption_fct(data));

	return 0;
}
