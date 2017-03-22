.data
        factor: .float 2.0 /* use this to divide by two */

.globl _ZNK9CTriangle7AreaAsmEv

_ZNK9CTriangle7AreaAsmEv:
        push %ebp      /* save old base pointer */
        mov %esp, %ebp /* set ebp to current esp */
        
        mov 8(%ebp), %eax    # CTriangle
	mov (%eax), %edx     # vtable
	mov 8(%edx), %edx    # PerimeterCpp()
	push %eax            # push l'objet CTriangle
	call *%edx           # appel de la fonction -> perimetre dans %st(0)
	add $4, %esp         # retablissement de %esp

	lea factor, %ecx     # %ecx = &factor
	fld (%ecx)           # 2.0
	fdivrp               # P / 2.0 = p
	fst (%ecx)           # %ecx = p
	
	fld 4(%eax)          # a
	fsubrp               # p - a
	fld (%ecx)           # p
	fld 8(%eax)          # b
	fsubrp               # p - b
	fld (%ecx)           # p
	fld 12(%eax)         # c
	fsubrp               # p - c
	fld (%ecx)           # p
	fmulp                # p(p - c)
	fmulp                # p(p - c)(p - b)
	fmulp                # p(p - c)(p - b)(p - a)
	fsqrt                # sqrt(p(p - c)(p - b)(p - a))
	
        leave          /* restore ebp and esp */
        ret            /* return to the caller */
