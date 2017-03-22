.data
        factor: .float 2.0 /* use this to multiply by two */

.globl	_ZNK9CTriangle9HeightAsmEv

_ZNK9CTriangle9HeightAsmEv:
        push %ebp      /* save old base pointer */
        mov %esp, %ebp /* set ebp to current esp */
        
        mov 8(%ebp), %eax    # CTriangle
	mov (%eax), %ecx     # vtable
	mov 16(%ecx), %edx   # AreaCpp()
	push %eax            # push l'objet CTriangle
	call *%edx           # appel de la fonction -> aire dans %st(0)
	add $4, %esp         # retablissement de %esp
	
	fld factor           # 2.0
	fmulp                # 2.0 * A
	fld 12(%eax)         # mSides[2]
	fdivrp               # 2.0 * A / mSides[2]
        
        leave          /* restore ebp and esp */
        ret            /* return to the caller */
