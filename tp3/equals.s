.globl matrix_equals_asm

matrix_equals_asm:
    push %ebp      /* Save old base pointer */
    mov %esp, %ebp /* Set ebp to current esp */
	
	movl 16(%ebp), %ebx                 # ebx = matorder
	imul %ebx, %ebx                     # ebx = matorder * matorder
	movl $0, %eax                       # eax = index
	movl 8(%ebp), %ecx                  # ecx = inmatdata1
	movl 12(%ebp), %edx                 # edx = inmatdata2
	jmp boucle
	
	boucle:
		cmpl %eax, %ebx                 # if(index == nombre éléments à parcourir)
		je fin                          # alors on a fini de parcourir les matrices et on retourne 1
		
		movl (%ecx, %eax, 4), %esi      # esi = inmatdata1[index]
		movl (%edx, %eax, 4), %edi      # edi = inmatdata2[index]
		cmpl %esi, %edi
		je repeat                       # on continue si les deux éléments sont égaux
		movl $0, %eax                   # sinon on retourne 0
		jmp return
	
	repeat:
		incl %eax                       # index++
		jmp boucle

	fin:
		movl $1, %eax                   # étiquette pour retourner 1
		jmp return
	
	return:
    	leave          /* Restore ebp and esp */
    	ret            /* Return to the caller */
