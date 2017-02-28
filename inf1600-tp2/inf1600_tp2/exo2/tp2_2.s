.global func_s

func_s:
	
	flds f    # load f
	flds g    # load g     (contenu de la m�moire: f | g)
	fsubrp    # f - g
	fstps a   # on utilise a comme m�moire temporaire puisqu'on en n'a pas besoin avant la fin
	flds b    # load b
	flds d    # load d     (contenu de la m�moire: b | d)
	fmulp     # b * d
	flds c    # load c     (contenu de la m�moire: b * d | c)
	fsubrp    # (b * d) - c
	flds a    # load a     (contenu de la m�moire: (b * d) - c | f - g)
	fdivrp    # ((b * d) - c) / (f - g)
	flds e    # load e     (contenu de la m�moire: ((b * d) - c) / (f - g) | e
	faddp     # ((b * d) - c) / (f - g) + e
	fstps a   # le r�sultat est mis dans a
	flds g    # load g
	flds e    # load e     (contenu de la m�moire: g | e)
	fsubrp    # g - e
	flds f    # load f     (contenu de la m�moire: g - e | f)
	fdivrp    # (g - e) / f
	flds a    # load a     (contenu de la m�moire: (g - e) / f | ((b * d) - c) / (f - g) + e)
	fmulp     # ((g - e) / f) * (((b * d) - c) / (f - g) + e)
	fstps a   # le r�sultat vas dans a
	
	ret       # fin de l'op�ration
