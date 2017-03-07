.data
	ordre:
		.int 0

.globl matrix_diagonal_asm

matrix_diagonal_asm:
	push %ebp      /* save old base pointer */
	mov %esp, %ebp /* set ebp to current esp */
	
	movl 16(%ebp), %eax                 # matorder
	movl %eax, ordre                    # ordre = matorder
	movl $0, %eax                       # eax = r
	movl $0, %ebx                       # ebx = c
	movl 8(%ebp), %ecx                  # ecx = inmatdata
	movl 12(%ebp), %edx                 # edx = outmatdata
	movl $0, %esi                       # esi = r * 4 + c
	movl $0, %edi                       # edi = index (r * matorder + c)
	jmp condition1
	
	condition1:
		cmpl %ebx, ordre
		jne condition2                  # if(c < matorder) -> condition2 (c varie entre 0 et matorder donc la condition jne est bonne)
		incl %eax                       # r++
		movl $0, %ebx                   # c = 0
		jmp condition2                  # -> condition2
		
	condition2:
		cmpl %eax, ordre                # on sort de la boucle quand (r == matorder)
		je fin                          # if(r < matorder)
		
		cmpl %eax, %ebx                 # if(r == c)
		jne pasdiagonale                # r != c -> pasdiagonale
		movl (%ecx, %esi, 1), %edi      # edi = inmatdata[r * 4 + c]
		movl %edi, (%edx, %esi, 1)      # outmatdata[r * 4 + c] = inmatdata[r * 4 + c]
		jmp repeat                      # on recommence
		
	pasdiagonale:
		movl $0, %edi                   # edi = 0
		movl %edi, (%edx, %esi, 1)      # outmatdata[r * 4 + c] = 0
		jmp repeat                      # on recommence

	repeat:
		addl $4, %esi                   # index += 4
		incl %ebx                       # c++
		jmp condition1                  # on revient à la boucle
		
	fin:
		leave          /* restore ebp and esp */
		ret            /* return to the caller */
