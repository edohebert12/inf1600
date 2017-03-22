.globl _ZNK7CCircle7AreaAsmEv

_ZNK7CCircle7AreaAsmEv:
        push %ebp      /* save old base pointer */
        mov %esp, %ebp /* set ebp to current esp */
        
        mov 8(%ebp), %eax      # CCircle
	fld 4(%eax)            # mRadius
	fld 4(%eax)            # mRadius
	fmulp                  # mRadius²
	fldpi                  # 3.14159...
	fmulp                  # pi * mRadius²
        
        leave          /* restore ebp and esp */
        ret            /* return to the caller */
