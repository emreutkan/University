%include "asm_io.inc"

;
;
;

segment .data

msg  db "Enter an integer ; ",0
msg1 db "its the ascii code for a white space",0
msg2 db "its some non extended ascii code",0
msg3 db "its the ascii code for a digit",0
msg4 db "its the some extended ascii code",0
msg5 db "its not an ascii code",0

segment .bss

segment .text
global _asm_main
_asm_main:

enter 0,0
pusha

while:
	mov eax,msg
	call print_string
	call read_int
	cmp eax,0
	jge thenblock
	jmp elseblock
	
thenblock:
	cmp eax,48
	jge greaterthan48block
	cmp eax,32
	je equal32block
	cmp eax,127
	jle lowerthan127block
	jmp greaterthan128block
	
equal32block:
	mov eax, msg1
	call print_string
	call print_nl
	jmp while

greaterthan48block:
	cmp eax,57
	jle between48and57block
	cmp eax, 127
	jle lowerthan127block
	jmp greaterthan128block
	
lowerthan127block:
	mov eax, msg2
	call print_string
	call print_nl
	jmp while
	
between48and57block:
	mov eax, msg3
	call print_string
	call print_nl
	jmp while

greaterthan128block:
	cmp eax,255
	jg greaterthan255block
	mov eax, msg4
	call print_string
	call print_nl
	jmp while
	
greaterthan255block:
	mov eax, msg5
	call print_string
	call print_nl
	jmp while
	
elseblock:
	jmp end_while

end_while:
