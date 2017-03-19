.data
c: 
     .int 0
r:   
     .int 0
temp:
     .int 0

.globl matrix_transpose_asm

matrix_transpose_asm:
        push %ebp      /* save old base pointer */
        mov %esp, %ebp /* set ebp to current esp */
        
        /* Write your solution here */
       push %edi
       push %esi
       
       movl 8(%ebp),%esi     # le tableau inmatdata
       movl 12(%ebp),%ebx    # le tableau  outmatdata
       movl 16(%ebp), %edi   # mataorder        

       Boucle1:
       movl c, %ecx       # initialise C a chaque boucle 
       movl $0,%ecx
       movl %ecx, c
       movl r, %eax
       cmpl %eax, %edi    # comparer la valeur de r et le matorder
       je retour
       jmp Boucle2
       

       
      Boucle2:
        movl c, %ecx
        cmpl %ecx, %edi    # comparer la valeur de C et matorder
        je incrementerR            
        movl r, %eax
        imul  %edi,%eax
        add %eax, %ecx         # mettre la position du nombre a mettre dans outmatdata dans %ecx
        movl %ecx, temp
        movl c, %ecx
        movl r,%eax
        imul %edi,%ecx
        add %ecx, %eax          #mettre la posirtion du nombre a recuperer dans %eax



        movl temp, %ecx
        movl (%esi,%eax,4),%edx
        movl %edx, (%ebx, %ecx, 4)    # mettre ce nombre dans le tableau outmatdata
        jmp incrementerC
        
        incrementerC:
         movl c, %ecx
         incl %ecx
         mov %ecx, c
         jmp Boucle2	

        incrementerR:
        mov r, %eax
        incl %eax
        movl %eax, r
        jmp Boucle1
       
     
        retour:
        pop %edi
        pop %esi
        pop %esp
        leave          /* restore ebp and esp */
        ret            /* return to the caller */
