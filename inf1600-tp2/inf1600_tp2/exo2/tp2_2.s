.global func_s

func_s:
	
	flds f
	flds g
	fsubrp
	fstps a
	flds b
	flds d
	fmulp
	flds c
	fsubrp
	flds a
	fdivrp
	flds e
	faddp
	fstps a
	flds g
	flds e
	fsubrp
	flds f
	fdivrp
	flds a
	fmulp
	fstps a
	
	ret
