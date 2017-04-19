
#include <stdio.h>

unsigned int Decryption_fct(unsigned int le)
{
	unsigned int be;

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
