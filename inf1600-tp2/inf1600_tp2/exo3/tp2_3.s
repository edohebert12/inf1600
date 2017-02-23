.data
	i:
		.int 0
	max:
		.int 10

.global func_s

func_s:	
	
	boucle:
		mov i, %ebx
		mov max, %ecx
		cmp %ebx, %ecx
		ja fin
		mov d, %eax
		add e, %eax
		sub b, %eax
		mov %eax, a
	
	condition:
		mov b, %ebx
		mov c, %ecx
		sub $1000, %ebx
		add $500, %ecx
		cmp %ebx, %ecx
		jnae else
		sub $1000, %ecx
		mov %ecx, c
		mov b, %ebx
		cmp %ebx, %ecx
		jna boucle
		sub 500, %ebx
		mov %ebx, b
		jmp boucle
	
	else:
		mov b, %ebx
		mov e, %ecx
		sub %ebx, %ecx
		mov %ebx, b
		mov d, %edx
		add $500, %edx
		mov %edx, d
		jmp boucle
		
	fin:
		ret
