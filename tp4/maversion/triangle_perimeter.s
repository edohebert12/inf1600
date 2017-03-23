.globl _ZNK9CTriangle12PerimeterAsmEv

_ZNK9CTriangle12PerimeterAsmEv:
        push %ebp      /* save old base pointer */
        mov %esp, %ebp /* set ebp to current esp */
        
      	movl 8(%ebp), %eax
	movl $1, %edx
	flds (%eax, %edx,4)
	incl %edx
	flds (%eax, %edx,4)
	faddp 
	incl %edx
	flds (%eax, %edx,4)
	faddp 
        
        leave          /* restore ebp and esp */
        ret            /* return to the caller */
