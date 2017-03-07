.data
	r:
		.int 0
	c:
		.int 0
	i:
		.int 0
	order:
		.int 0
	index:
		.int 0
	index1:
		.int 0
	index2:
		.int 0


.globl matrix_multiply_asm

matrix_multiply_asm:
	push %ebp      /* save old base pointer */
	mov %esp, %ebp /* set ebp to current esp */
	
	movl 16(%ebp), %eax                 # matorder
	movl %eax, order                    # order = matorder
	movl 8(%ebp), %ecx                  # ecx = inmatdata
	movl 12(%ebp), %edx                 # edx = outmatdata
	
	condition1:                         # for(c = 0; c < matorder; c++)
		movl c, %eax
		cmpl %eax, order
		jne condition2                  # if(c < matorder) -> condition2 (c varie entre 0 et matorder donc la condition jne est bonne)
		movl r, %eax
		incl %eax                       # r++
		movl %eax, r
		movl $0, c                      # c = 0
		jmp condition2                  # -> condition2
		
	condition2:                         # for(r = 0; r < matorder; r++)
		movl r, %eax
		cmpl %eax, order                   # on sort de la boucle quand (r == matorder)
		je fin 
		movl $0, %eax                   # eax = buffer
		
		boucle:                         # for(i = 0; i < matorder; i++)
			movl i, %ebx
			cmpl %ebx, order
			je affecter                  # if (i == matorder)
			
			movl r, %esi
			movl order, %edi
			imul %esi, %edi
			movl i, %esi
			addl %esi, %edi
			movl %edi, index1
			movl i, %esi
			movl order, %edi
			imul %esi, %edi
			movl c, %esi
			addl %esi, %edi
			movl %edi, index2
			
			movl index1, %ebx
			movl (%ecx, %ebx, 4), %esi
			movl index2, %ebx
			movl (%ecx, %ebx, 4), %edi
			imul %esi, %edi
			addl %edi, %eax

			movl i, %ebx
			incl (%ebx)
			movl %ebx, i
			jmp boucle
		
		affecter:
			movl index, %ebx
			movl %eax, (%edx, %ebx, 4)

			movl index, %eax
			addl $4, (%eax)
			movl %eax, index
			movl c, %eax
			incl (%eax)
			movl %eax, c
			jmp condition1
		
	fin:
		leave          /* restore ebp and esp */
		ret            /* return to the caller */
