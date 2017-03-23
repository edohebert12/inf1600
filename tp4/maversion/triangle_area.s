.data
temporaire: 	.float 2

.globl _ZNK9CTriangle7AreaAsmEv

_ZNK9CTriangle7AreaAsmEv:
        push %ebp      /* save old base pointer */
        mov %esp, %ebp /* set ebp to current esp */
	push %ebx
	push %edi
	push %esi
        
	movl  8(%ebp), %eax
	push  %eax
	movl (%eax), %edi
	call *8(%edi)      # p dans %eax
	movl  8(%ebp),%edx
	movl $1, %ecx
	flds temporaire
	fdivrp
	fstp temporaire

	flds temporaire
	flds (%edx, %ecx,4)
	fsubrp
	incl %ecx


	flds temporaire
	flds (%edx, %ecx,4)
	fsubrp
	fmulp
	incl %ecx
	
	flds temporaire
	flds (%edx, %ecx,4)
	fsubrp
	fmulp

	flds temporaire
	fmulp
	fsqrt

	pop %esi
	pop %edi
	pop %ebx
	
        leave          /* restore ebp and esp */
        ret            /* return to the caller */
