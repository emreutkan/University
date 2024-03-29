%include "asm_io.inc"

segment .data

prompt1 db "Enter a character: ", 0
prompt2 db "Enter an integer: ", 0
outmsg1 db "The character entered was: ", 0
outmsg2 db "The integer entered was: ", 0

segment .bss

input1 resd 1 ; char
input2 resd 1 ; int

segment .text
global _asm_main
_asm_main:
enter 0,0 ; setup routine
pusha

mov eax, prompt1 ; print out prompt
call print_string

call read_char ; read char
mov [input1], eax ; store into input1

mov eax, prompt2 ; print out prompt
call print_string

call read_int ; read integer
mov [input2], eax ; store into input2

mov eax, outmsg1
call print_string ; print out first message
mov eax, [input1]
call print_char ; print out char
call print_nl ; print new-line

mov eax, outmsg2
call print_string ; print out second message
mov eax, [input2]
call print_int ; print out input2
call print_nl ; print new-line

popa
mov eax, 0 ; return back to C
leave
ret