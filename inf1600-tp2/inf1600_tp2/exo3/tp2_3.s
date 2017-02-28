.data
	i:
		.int 0
	max:
		.int 10

.global func_s

func_s:
	boucle:
        	mov i, %eax
		mov max, %ebx
		cmp %ebx, %eax
		ja fin
		mov d, %eax
		mov e, %ebx
		mov b, %ecx
		add %ebx, %eax
		sub %ecx, %eax
		mov %eax, a
	
	condition:
		mov b, %esi
		mov c, %edi
		sub $1000, %esi
		add $500, %edi
		cmp %edi, %esi
		jae else
		mov c, %edx
		sub $500, %edx
		mov %edx, c
		mov b, %ebx
		mov c, %ecx
		cmp %ecx, %ebx
		jna repeat
		mov b, %ebx
		sub $500, %ebx
		mov %ebx, b
		jmp repeat
	
	else:
		mov b, %ebx
		mov e, %ecx
		sub %ecx, %ebx
		mov %ebx, b
		mov d, %edx
		add $500, %edx
		mov %edx, d
		jmp repeat

	repeat:
		mov i, %eax
		add $1, %eax
		mov %eax, i
		jmp boucle
		
	fin:
		ret
