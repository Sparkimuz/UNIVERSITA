_EXIT = 1
_PRINTF = 127

.SECT .TEXT
   MOV     SP, BP
   MOV     CX, format - str
   PUSH    str
   CALL    stampa   
   MOV     SP, BP
   PUSH    0
   PUSH    _EXIT
   SYS
   MOV     SP, BP

   stampa: 
      PUSH    BP
      MOV     BP, SP
      MOV     BX, 4(BP)
      MOV     SI, 0
      1: MOV  AX, (BX)(SI)
      PUSH    AX
      PUSH    format
      PUSH    _PRINTF
      SYS
      MOV     SP, BP
      ADD     SI, 1
      LOOP    1b
      MOV     SP, BP
      POP     BP
      RET

.SECT .DATA
   str:     .ASCII " a aaa  09 "  
   format: .ASCII "%c"

.SECT .BSS
