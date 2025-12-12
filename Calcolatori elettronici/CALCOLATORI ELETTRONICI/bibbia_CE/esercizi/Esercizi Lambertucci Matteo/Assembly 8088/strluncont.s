! 

_EXIT = 1
_PRINTF = 127

.SECT .TEXT
   main:
      MOV  SP, BP
      MOV  AX, end
      PUSH stringa
      CALL lun
      MOV  SP, BP
      PUSH (occ)
      PUSH stringa
      CALL contains
      MOV  SP, BP
      PUSH DX     ! contiene il valore booleano contains.
      PUSH BX
      PUSH stampa
      PUSH _PRINTF
      SYS
      MOV  SP, BP
      PUSH 0
      PUSH _EXIT
      SYS
      MOV  SP, BP

lun:
   PUSH BP
   MOV  BP, SP
   MOV  BX, 4(BP)
   SUB  AX, BX    !lunghezza stringa
   MOV  CX, AX
   MOV  BX, CX
   MOV  SP, BP
   POP  BP
   RET

contains:
   PUSH BP
   MOV  BP, SP
   MOV  DI, 4(BP)  ! stringa
   MOVB AL, 6(BP)  ! carattere (un byte)
   MOV  DX, 0
   1:   SCASB
   JE 2f
   LOOP 1b
   JMP 3f
   2:   MOV DX, 1
   3:   MOV SP, BP
   POP  BP
   RET
.SECT .DATA
   stringa: .ASCII "ciao."
   end:     .SPACE 1
   occ:     .ASCII "o" 
   stampa:  .ASCII "\n Stringa di Lunghezza = %d ==> Contains = %d.\n"
.SECT .BSS