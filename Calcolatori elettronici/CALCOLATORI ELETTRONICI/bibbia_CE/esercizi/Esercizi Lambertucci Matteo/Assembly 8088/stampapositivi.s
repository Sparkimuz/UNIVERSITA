! Esame 26/06/2023: Dato un vettore di WORD stampa tutti i valori positivi.
_EXIT             = 1
_PRINTF           = 127
.SECT   .TEXT
start:
   MOV            SP, BP
   MOV            CX, endVettore - vettore
   SHR            CX, 1
   MOV            BX, vettore
   MOV            DX, (limite)
   MOV            SI, 0
   1:   CMP       (BX)(SI), DX
   JL             2f
   MOV            SP, BP 
   MOV            AX, (BX)(SI)
   PUSH           DX
   PUSH           AX
   PUSH           format
   PUSH           _PRINTF
   SYS
   2:   ADD         SI, 2
   LOOP            1b
   MOV             SP, BP
   PUSH            0
   PUSH            _EXIT
   SYS
   MOV             SP, BP
.SECT   .DATA
   vettore:        .WORD    3, -4, -7, 11, 34, -4, 22, 0, 5
   endVettore:     .SPACE   1
   limite:         .WORD    0
   format:         .ASCII   "%d > %d.\n"
.SECT   .BSS