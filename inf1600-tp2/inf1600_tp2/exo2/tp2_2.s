.global func_s

func_s:
	
	flds f    # load f
	flds g    # load g     (contenu de la mémoire: f | g)
	fsubrp    # f - g
	fstps a   # on utilise a comme mémoire temporaire puisqu'on en n'a pas besoin avant la fin
	flds b    # load b
	flds d    # load d     (contenu de la mémoire: b | d)
	fmulp     # b * d
	flds c    # load c     (contenu de la mémoire: b * d | c)
	fsubrp    # (b * d) - c
	flds a    # load a     (contenu de la mémoire: (b * d) - c | f - g)
	fdivrp    # ((b * d) - c) / (f - g)
	flds e    # load e     (contenu de la mémoire: ((b * d) - c) / (f - g) | e
	faddp     # ((b * d) - c) / (f - g) + e
	fstps a   # le résultat est mis dans a
	flds g    # load g
	flds e    # load e     (contenu de la mémoire: g | e)
	fsubrp    # g - e
	flds f    # load f     (contenu de la mémoire: g - e | f)
	fdivrp    # (g - e) / f
	flds a    # load a     (contenu de la mémoire: (g - e) / f | ((b * d) - c) / (f - g) + e)
	fmulp     # ((g - e) / f) * (((b * d) - c) / (f - g) + e)
	fstps a   # le résultat vas dans a
	
	ret       # fin de l'opération
