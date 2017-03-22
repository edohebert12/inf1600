.data
        factor: .float 2.0 /* use this to multiply by two */

.text
.globl _ZNK7CCircle12PerimeterAsmEv

_ZNK7CCircle12PerimeterAsmEv:
        push %ebp      /* save old base pointer */
        mov %esp, %ebp /* set ebp to current esp */

        mov 8(%ebp), %eax   # CCircle
	fld 4(%eax)         # mRadius
	fld factor          # 2.0
	fmulp               # 2.0 * mRadius
	fldpi               # 3.14159...
	fmulp               # 2.0 * pi * mRadius
        
        leave          /* restore ebp and esp */
        ret            /* return to the caller */
