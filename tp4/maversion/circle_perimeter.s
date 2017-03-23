.data
        factor: .float 2.0 /* use this to multiply by two */
        
.text
.globl _ZNK7CCircle12PerimeterAsmEv

_ZNK7CCircle12PerimeterAsmEv:
        push %ebp      /* save old base pointer */
        mov %esp, %ebp /* set ebp to current esp */

        fld (factor)
	fldpi 
        fmulp
	movl 8(%ebp), %eax 
        fld 4(%eax)
	fmulp
  
        leave          /* restore ebp and esp */
        ret            /* return to the caller */
