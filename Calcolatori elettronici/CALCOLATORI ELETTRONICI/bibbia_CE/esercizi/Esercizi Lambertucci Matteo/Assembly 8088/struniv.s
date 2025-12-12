_EXIT = 1
_PRINTF = 127

.SECT .TEXT
   main: 
      MOV SP, BP
      MOV CX, end - str
      PUSH (x)
      PUSH str
      CALL verificauniversale
      MOV SP, BP
      PUSH DX
      PUSH format
      PUSH _PRINTF
      SYS
      MOV SP, BP
      PUSH 0
      PUSH _EXIT
      SYS

   verificauniversale:
      PUSH BP
      MOV BP, SP
      MOV DX, 1
      MOV DI, 4(BP)
      MOVB AL, 6(BP)
      REPE SCASB
      JNE 1f
      JMP 2f
      1: MOV DX, 0
      2: MOV SP, BP
      POP BP 
      RET

.SECT .DATA
   str: .ASCII "aaaaaaaaba"
   end: .SPACE 1
   x:   .ASCII "a"
   format: .ASCII "%d"
.SECT .BSS