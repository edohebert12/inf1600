.data
temporaire:
	.float 2
.globl	_ZNK9CTriangle9HeightAsmEv

_ZNK9CTriangle9HeightAsmEv:
        push %ebp      /* save old base pointer */
        mov %esp, %ebp /* set ebp to current esp */
        
	
	movl 8(%ebp),%edx
	push %edx
	fld 12(%edx)
	movl (%edx), %ecx
	call *16(%ecx)
	fdivp
	flds temporaire
	fmulp 
        
        leave          /* restore ebp and esp */
        ret            /* return to the caller */
