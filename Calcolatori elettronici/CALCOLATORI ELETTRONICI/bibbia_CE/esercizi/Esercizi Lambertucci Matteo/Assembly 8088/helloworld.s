! Simple "hello world" program

_EXIT	    = 1							!  1
_PRINTF	    = 127						!  2
.SECT       .TEXT						!  3
start:									!  4
	MOV     BP, SP      				!  5
	PUSH	format						!  6	
	PUSH	_PRINTF 					!  7
	SYS									!  8
	MOV     BP, SP      				!  9
	PUSH	0							!  10
	PUSH	_EXIT						!  11
	SYS									!  12
	MOV     BP, SP						!  13
.SECT       .DATA						!  14
format:     .ASCII	"\nHello World.\n"	!  15
.SECT       .BSS						!  16
