.data
	i:
		.int 0
	max:
		.int 8

.global func_s

func_s:
	boucle:
        	mov i, %eax
		mov max, %ebx
		cmp %ebx, %eax
		ja fin
		mov d, %eax
		mov e, %ebx
		add %ebx, %eax
		mov b, %ebx
		sub %ebx, %eax
		mov %eax, a
	
	condition:
		mov b, %ebx
		mov c, %ecx
		sub $1000, %ebx
		add $500, %ecx
		cmp %ecx, %ebx
		jae else
		mov c, %ecx
		sub $500, %ecx
		mov %ecx, c
		mov b, %ebx
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
