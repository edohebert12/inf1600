.globl matrix_equals_asm

max:
	.int 0

index:
	.int 0, 0

offset:
	.int 0

matrix_equals_asm:
        push %ebp      /* Save old base pointer */
        mov %esp, %ebp /* Set ebp to current esp */

        /* Write your solution here */
	
        
        leave          /* Restore ebp and esp */
        ret            /* Return to the caller */
