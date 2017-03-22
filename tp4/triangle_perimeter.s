.globl _ZNK9CTriangle12PerimeterAsmEv

_ZNK9CTriangle12PerimeterAsmEv:
        push %ebp      /* save old base pointer */
        mov %esp, %ebp /* set ebp to current esp */
	
	mov 8(%ebp), %eax   # CTriangle
	fld 4(%eax)         # mSides[0] = a
	fld 8(%eax)         # mSides[1] = b
	faddp               # a + b
	fld 12(%eax)        # mSides[2] = c
	faddp               # a + b + c
	
        leave          /* restore ebp and esp */
        ret            /* return to the caller */
