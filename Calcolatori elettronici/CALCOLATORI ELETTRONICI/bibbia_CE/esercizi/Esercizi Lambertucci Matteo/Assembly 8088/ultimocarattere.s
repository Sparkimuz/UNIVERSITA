! Vede se l'ultimo carattere della stringa è ".". 

_EXIT = 1
_PRINTF = 127

.SECT .TEXT
   main:
      MOV  SP, BP
      MOV  CX, end - stringa
      PUSH (x)
      PUSH stringa
      CALL ultimocarattere
      MOV  SP, BP
      PUSH DX   
      PUSH format
      PUSH _PRINTF
      SYS
      MOV  SP, BP
      PUSH 0
      PUSH _EXIT
      SYS
      MOV  SP, BP

ultimocarattere:
   PUSH BP
   MOV  BP, SP
   MOV  DI, 4(BP)  ! stringa   (+ byte)
   MOVB AL, 6(BP)  ! carattere (un byte)
   MOV  DX, 0
   MOV  SP, BP
   1:  CMP CX, 1
   JE 2f
   SCASB
   LOOP 1b
   2:  SCASB
   JNE 3f
   MOV DX, 1
   3: MOV  SP, BP
   POP  BP
   RET
   
.SECT .DATA
   stringa:        .ASCII "occccd."
   end:            .SPACE 1
   x:     .ASCII "." 
   format:         .ASCII "%d"

.SECT .BSS