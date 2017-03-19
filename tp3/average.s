.data
r:
   .int 0
c: 
   .int 0
temp:
   .int 0

.global matrix_row_aver_asm

matrix_row_aver_asm:
        push %ebp      			/* Save old base pointer */
        mov %esp, %ebp 			/* Set ebp to current esp */
        push %esi
        push %ebx
        push %edi

        movl 8(%ebp), %esi        # tableau inmatdata
        movl 12(%ebp), %ebx       # tableau outmatdata
        movl 16(%ebp), %ecx      # metaorder
        
        Boucle1:
        movl r,%edi
        cmpl %edi, %ecx          # comparer r avec matorder
        je  retour
        mov c,%edx
        movl $0, %edx           # initialise c pour la prochaine boucle
        movl %edx, c
        movl $0, %eax
        jmp Boucle2
        
        continueBoucle1:
        movl $0, %edx
        div %ecx
        movl r,%edi
        movl %eax, (%ebx,%edi,4)    # Ajouter la valeur de elem dans le tableau outmatdata
        jmp incrementerR
        

        Boucle2:
        movl c,%edx      # comparer c avec matorder
        cmpl %edx,%ecx
        je continueBoucle1
        movl r,%edi
        imul %ecx, %edi    #mettre la position du nombre a recuperer du tableau inmatdata dans %edx
        add %edi, %edx   
        add (%esi,%edx,4),%eax  #mettre le nombre dans elem
        jmp incrementerC


        incrementerC:
        movl c,%edx
        incl %edx
        movl %edx, c
        jmp Boucle2

        incrementerR:
        movl r, %edi
        incl %edi
        movl %edi, r
        jmp Boucle1



        
   

        retour:	
        pop %esi
        pop %ebx
        pop %edi	
        leave          			/* Restore ebp and esp */
        ret           			/* Return to the caller */
		
