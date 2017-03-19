.data
	r:
		.int 0 # row index
	c:
		.int 0 # column index
	i:
		.int 0 # multiplication index
	order:
		.int 0 # matorder
	index:
		.int 0 # affectation
	index1:
		.int 0 # i + r * matorder
	index2:
		.int 0 # c + i * matorder


.globl matrix_multiply_asm

matrix_multiply_asm:
	push %ebp      /* save old base pointer */
	mov %esp, %ebp /* set ebp to current esp */
	
	movl 20(%ebp), %eax                 # matorder
	movl %eax, order                    # order = matorder
	movl 8(%ebp), %ecx                  # ecx = inmatdata1
	movl 12(%ebp), %edx                 # edx = inmatdata2
	
	condition1:                             # for(c = 0; c < matorder; c++)
		movl c, %eax
		cmpl %eax, order
		jne condition2                  # if(c < matorder) -> condition2 (c varie entre 0 et matorder donc la condition jne est bonne)
		movl r, %eax                    # c == matorder
		incl %eax                       # r++
		movl %eax, r
		movl $0, c                      # c = 0
		jmp condition2                  # -> condition2
		
	condition2:                             # for(r = 0; r < matorder; r++)
		movl r, %eax
		cmpl %eax, order                # on sort de la boucle quand (r == matorder)
		je fin 
		xor %eax, %eax                  # eax = buffer pour le résultat
		
		boucle:                              # for(i = 0; i < matorder; i++)
			movl i, %ebx
			cmpl %ebx, order
			je affecter                  # if (i == matorder) fin de la boucle
			
			movl r, %esi
			movl order, %edi
			imul %esi, %edi
			movl i, %esi
			addl %esi, %edi              # %edi = i + r * matorder
			movl %edi, index1            # index1 = i + r * matorder
			movl i, %esi
			movl order, %edi
			imul %esi, %edi
			movl c, %esi
			addl %esi, %edi
			movl %edi, index2            # index2 = c + i * matorder
			
			movl index1, %ebx
			movl (%ecx, %ebx, 4), %esi   # %esi = inmatdata1[i + r * matorder]
			movl index2, %ebx
			movl (%edx, %ebx, 4), %edi   # %edi = inmatdata2[c + i * matorder]
			imul %esi, %edi              # on multiplie les deux éléments
			addl %edi, %eax              # on ajoute le résultat dans %eax

			movl i, %ebx                 # i++
			incl (%ebx)
			movl %ebx, i
			jmp boucle
		
		affecter:
			movl index, %ebx
			movl 16(%ebp), %esi          # %esi = outmatdata
			movl %eax, (%esi, %ebx, 4)

			movl index, %eax             # index d'affectation ++
			addl $1, (%eax)
			movl %eax, index
			movl c, %eax                 # c++
			incl (%eax)
			movl %eax, c
			jmp condition1
		
	fin:
		leave          /* restore ebp and esp */
		ret            /* return to the caller */
