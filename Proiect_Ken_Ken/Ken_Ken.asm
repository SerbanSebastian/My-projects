.386
.model flat, stdcall
includelib msvcrt.lib
extern exit : proc
extern malloc : proc
extern fscanf : proc
extern fopen : proc
extern fclose : proc
extern memset : proc
extern printf : proc
extern scanf : proc

includelib canvas.lib
extern BeginDrawing : proc

public start

.data
	spatiu DB " ", 0
	window_width equ 640
	window_height equ 480
	arg1 equ 8
	arg2 equ 12
	arg3 equ 16
	arg4 equ 20
	arg5 equ 24
	arg6 equ 28
	arg7 equ 32
	var DD 0
	game_title DB "KenKen", 0
	all_moves DD 0
	cages DD 0
	window DD 0
	format DB "%d %d", 0
	format1 DB "%d", 0
	format2 DB "%d %c %d", 0
	symbol DD 0
	operators DD 0
	quantity DD 0
	folder_name DB "KenKen.txt", 0
	folder_read DB "r", 0
	pfin DD 0
	x DD 0
	y DD 0
	contor DD 0
	first_coord DD 0
	second_coord DD 0
	i DD 0
	j DD 0
	kenken DD 2, 1, 3, 1, 3, 2, 3, 2, 1
	n DD 0
	values DD 0
	distance DD 0
	distancey DD 0
	place DD 0
	square_x1_3 EQU	170
	square_y1_3 EQU	90
	square_x2_3 EQU	470
	square_y2_3 EQU	390
	square_x1_4 EQU	160
	square_y1_4 EQU	80
	square_x2_4 EQU	480
	square_y2_4 EQU	400
	square_x1_5 EQU	150
	square_y1_5 EQU	70
	square_x2_5 EQU	490
	square_y2_5 EQU	410
	square_x1_6 EQU	140
	square_y1_6 EQU	60
	square_x2_6 EQU	500
	square_y2_6 EQU	420
	square_x1_7 EQU	145
	square_y1_7 EQU	65
	square_x2_7 EQU	495
	square_y2_7 EQU	415
	square_x1_8 EQU	120
	square_y1_8 EQU	40
	square_x2_8 EQU	520
	square_y2_8 EQU	440
	square_x1_9 EQU	95
	square_y1_9 EQU	15
	square_x2_9 EQU	545
	square_y2_9 EQU	465
	nothing_message DB " ", 0
	error_message DB "Valoarea este mai mare decat permite puzzle-ul", 0
	symbol_width EQU 10
	symbol_height EQU 20
include digits.inc
include letters.inc
include top.inc
.code

find_coords_matrix macro x, y, x_start, y_start, x_stop, y_stop, edge_length
local while_y, while_x, not_inside, end_macro
	pusha

	mov eax, x
	mov i, 0
	mov j, 0
	cmp eax, x_start
	jl not_inside
		cmp eax, x_stop
		jg not_inside
			mov eax, y
			cmp eax, y_start
			jl not_inside
				cmp eax, y_stop
				jg not_inside
					mov ebx, y_start
					while_y:
						add ebx, edge_length
						add i, 1
						cmp eax, ebx
					jg while_y
					mov eax, x
					mov ebx, x_start
					while_x:
						add ebx, edge_length
						add j, 1
						cmp eax, ebx
					jg while_x
					jmp end_macro
	not_inside:
		mov i, -1
		mov j, -1
	end_macro:
	popa
endm

find_coords_window macro i, j, x_start, y_start, edge_length
local
	pusha

	mov eax, edge_length
	mov ebx, j
	mul ebx
	add eax, x_start
	mov x, eax
	mov eax, edge_length
	mov ebx, i
	mul ebx
	add eax, y_start
	mov y, eax

	popa
endm

draw_square macro x1, y1, x2, y2, edge_length
local while_loop_down_right, while_loop_up_left
	pusha
	
	mov eax, y1
	mov ebx, window_width
	mul ebx
	add eax, x1
	shl eax, 2
	add eax, window
	mov ebx, eax
	mov ecx, edge_length
	while_loop_down_right:
		mov dword ptr[eax], 0h
		mov dword ptr[ebx], 0h
		add eax, 4
		add ebx, window_width * 4 
	loop while_loop_down_right
	
	mov eax, y2
	mov ebx, window_width
	mul ebx
	add eax, x2
	shl eax, 2
	add eax, window
	mov ebx, eax
	mov ecx, edge_length
	while_loop_up_left:
		mov dword ptr[eax], 0h
		mov dword ptr[ebx], 0h
		sub eax, window_width * 4
		sub ebx, 4
	loop while_loop_up_left
	
	popa
endm

draw_grid macro x1, y1, units, edge_length
local loop_down_right, draw_line_loop
	pusha
	
	mov eax, edge_length
	mov ecx, units
	mov edx, 0
	div ecx
	mov distance, eax
	mov ebx, window_width
	mul ebx
	shl eax, 2
	mov distancey, eax
	mov eax, distance
	shl eax, 2
	mov distance, eax
	mov ecx, units
	mov eax, y1
	mov ebx, window_width
	mul ebx
	add eax, x1
	shl eax, 2
	add eax, window
	mov ebx, eax
	
	loop_down_right:
		push eax
		push ebx
		push ecx
		
		mov ecx, edge_length
		draw_line_loop:
			mov dword ptr[eax], 0h
			mov dword ptr[ebx], 0h
			add ebx, 4
			add eax, window_width * 4
			sub ecx, 1
			cmp ecx, 0
		jne draw_line_loop
		
		pop ecx
		pop ebx
		pop eax
		add eax, distance
		add ebx, distancey
	loop loop_down_right
	
	popa
endm

mov_matrix macro value
	mov ebx, value
	mov dword ptr[eax], ebx
	add eax, 4
endm
read proc
	push ebp
	mov ebp, esp
	pusha
	
	push 2000
	call malloc
	add esp, 4
	mov all_moves, eax
	
	push offset cages		
	push offset format1
	push pfin
	call fscanf
	add esp, 12
	mov ecx, cages
	mov eax, all_moves

	while_read_loop:
		push ecx
		push eax
		push offset quantity
		push offset symbol
		push offset operators
		push offset format2
		push pfin
		call fscanf
		add esp, 20
		pop eax
		
		mov_matrix operators
		mov_matrix quantity
		mov_matrix symbol
		mov ecx, operators
		while_read_operators:
			push eax
			push ecx
			push offset second_coord
			push offset first_coord
			push offset format
			push pfin
			call fscanf
			add esp, 16
			pop ecx
			pop eax
			
			mov_matrix first_coord
			mov_matrix second_coord
			dec ecx
		jnz while_read_operators
		push eax
		push offset operators
		push offset format1
		push pfin
		call fscanf
		add esp, 12
		pop eax
		pop ecx
		mov_matrix operators
		dec ecx
	jnz while_read_loop
	popa
	mov esp, ebp
	pop ebp
	ret
read endp

; procedura make_text afiseaza o litera sau o cifra la coordonatele date
; arg1 - simbolul de afisat (litera, cifra sau simbol matematic)
; arg2 - pointer la vectorul de pixeli
; arg3 - pos_x
; arg4 - pos_y
make_text proc
	push ebp
	mov ebp, esp
	pusha
	
	mov eax, [ebp+arg1] ; citim simbolul de afisat
	cmp eax, 'A'
	jl make_digit
	cmp eax, 'Z'
	jg make_digit
	sub eax, 'A'
	lea esi, letters
	jmp draw_text
make_digit:
	cmp eax, 9
	jle cifra_ne_ASCII
	cmp eax, '0'
	jl make_simbol
	cmp eax, '9'
	jg make_simbol
	sub eax, '0'
cifra_ne_ASCII:
	lea esi, digits
	jmp draw_text
make_simbol:
	cmp eax, '*'
	jl make_space
	cmp eax, '/'
	jg make_space
	sub eax, '*'
	lea esi, top
	jmp draw_text
make_space:	
	mov eax, 26 ; de la 0 pana la 25 sunt litere, 26 e space
	lea esi, letters
	
draw_text:
	mov ebx, symbol_width
	mul ebx
	mov ebx, symbol_height
	mul ebx
	add esi, eax
	mov ecx, symbol_height
bucla_simbol_linii:
	mov edi, [ebp+arg2] ; pointer la matricea de pixeli
	mov eax, [ebp+arg4] ; pointer la coord y
	add eax, symbol_height
	sub eax, ecx
	mov ebx, window_width
	mul ebx
	add eax, [ebp+arg3] ; pointer la coord x
	shl eax, 2 ; inmultim cu 4, avem un DWORD per pixel
	add edi, eax
	push ecx
	mov ecx, symbol_width
bucla_simbol_coloane:
	cmp byte ptr [esi], 0
	je simbol_pixel_alb
	mov dword ptr [edi], 0
	jmp simbol_pixel_next
simbol_pixel_alb:
	mov dword ptr [edi], 0FFFFFFh
simbol_pixel_next:
	inc esi
	add edi, 4
	loop bucla_simbol_coloane
	pop ecx
	loop bucla_simbol_linii
	popa
	mov esp, ebp
	pop ebp
	ret
make_text endp

make_text_macro macro simbol, drawArea, x, y
	push y
	push x
	push drawArea
	push simbol
	call make_text
	add esp, 16
endm
; arg1 - x_start
; arg2 - y_start
; arg3 - edge_length
draw_cages proc
	push ebp
	mov ebp, esp
	pusha
	
	mov eax, all_moves
	mov ecx, cages
	while_write_cages:
		push ecx
		mov ecx, dword ptr[eax]
		add eax, 4
		mov ebx, dword ptr[eax]
		mov quantity, ebx
		add eax, 4
		mov ebx, dword ptr[eax]
		mov symbol, ebx
		add eax, 4
		while_write:
			mov ebx, dword ptr[eax]
			mov i, ebx
			add eax, 4
			mov ebx, dword ptr[eax]
			mov j, ebx
			add eax, 4
			find_coords_window i, j, [ebp + arg1], [ebp + arg2], [ebp + arg3]
			mov ebx, x
			sub ebx, [ebp + arg3]
			add ebx, 1
			mov x, ebx
			mov ebx, y
			sub ebx, [ebp + arg3]
			add ebx, 1
			mov y, ebx
			push ecx
			push eax
			make_text_macro symbol, window, x, y
			add x, 10
			make_text_macro quantity, window, x, y
			pop eax
			pop ecx
			dec ecx
		jnz while_write
		pop ecx
		add eax, 4
		dec ecx
	jnz while_write_cages
	
	popa
	mov esp, ebp
	pop ebp
	ret
draw_cages endp

find_place_matrix macro i, j, n
	pusha
	mov eax, i
	sub eax, 1
	mov ebx, n
	mul ebx
	add eax, j
	sub eax, 1
	mov ebx, 4
	mul ebx
	mov place, eax
	popa
endm
;arg1 - x
;arg2 - y
;arg3 - x_start
;arg4 - y_start
;arg5 - x_stop
;arg6 - y_stop
;arg7 - edge_length
input_click proc
	push ebp
	mov ebp, esp
	pusha
	
	push offset var
	push offset format1
	call scanf
	add esp, 8
	mov eax, n
	cmp eax, var
	
	jl not_ok
		mov eax, var
		cmp eax, 1
		jl ok
		find_coords_matrix [ebp + arg1], [ebp + arg2], [ebp + arg3], [ebp + arg4], [ebp + arg5], [ebp + arg6], [ebp + arg7]
		mov eax, i
		cmp eax, 0
		jl not_ok
			find_place_matrix i, j, n
			mov eax, values
			mov ebx, var
			add eax, place
			mov dword ptr[eax], ebx
			find_coords_window i, j, [ebp + arg3], [ebp + arg4], [ebp + arg7]
			sub x, 11
			sub y, 21
			make_text_macro var, window, x, y
		jmp ok
	not_ok:
		push offset error_message
		call printf
		add esp, 4
	ok:
	popa
	mov esp, ebp
	pop ebp
	ret
input_click endp

; functia de desenare - se apeleaza la fiecare click
; sau la fiecare interval de 200ms in care nu s-a dat click
; arg1 - evt (0 - initializare, 1 - click, 2 - s-a scurs intervalul fara click)
; arg2 - x
; arg3 - y
draw proc
	push ebp
	mov ebp, esp
	pusha
	
	mov eax, [ebp + arg1]
	cmp eax, 1
	je click_event
	cmp eax, 2
	je nothing_event
	
	mov eax, window_width
	mov ebx, window_height
	mul ebx
	shl eax, 2
	push eax
	push 255
	push window
	call memset
	add esp, 12
	
	push offset folder_read
	push offset folder_name
	call fopen
	add esp, 8
	mov pfin, eax
	push offset n
	push offset format1
	push pfin
	call fscanf
	add esp, 12
	mov eax, n
	mov ebx, n
	mul ebx
	shl eax, 2
	push eax
	call malloc
	add esp, 4
	mov values, eax
	mov eax, n
	
	cmp eax, 3
	je area_3
	
	cmp eax, 4
	je area_4
	
	cmp eax, 5
	je area_5
	
	cmp eax, 6
	je area_6
	
	cmp eax, 7
	je area_7
	
	cmp eax, 8
	je area_8
	
	cmp eax, 9
	je area_9
	
	area_3:
		draw_square square_x1_3, square_y1_3, square_x2_3, square_y2_3, 301
		draw_grid square_x1_3, square_y1_3, 3, 301
		call read
		push 100
		push square_y1_3
		push square_x1_3
		call draw_cages
		add esp, 12
		
		jmp end_draw
	area_4:
		draw_square square_x1_4, square_y1_4, square_x2_4, square_y2_4, 321
		draw_grid square_x1_4, square_y1_4, 4, 321
		call read
		push 80
		push square_y1_4
		push square_x1_4
		call draw_cages
		add esp, 12
		
		jmp end_draw
	area_5:
		draw_square square_x1_5, square_y1_5, square_x2_5, square_y2_5, 341
		draw_grid square_x1_5, square_y1_5, 5, 341
		call read
		push 65
		push square_y1_5
		push square_x1_5
		call draw_cages
		add esp, 12
		
		jmp end_draw
	area_6:
		draw_square square_x1_6, square_y1_6, square_x2_6, square_y2_6, 361
		draw_grid square_x1_6, square_y1_6, 6, 361
		call read
		push 60
		push square_y1_6
		push square_x1_6
		call draw_cages
		add esp, 12
		
		jmp end_draw
	area_7:
		draw_square square_x1_7, square_y1_7, square_x2_7, square_y2_7, 351
		draw_grid square_x1_7, square_y1_7, 7, 351
		call read
		push 50
		push square_y1_7
		push square_x1_7
		call draw_cages
		add esp, 12
		
		jmp end_draw
	area_8:
		draw_square square_x1_8, square_y1_8, square_x2_8, square_y2_8, 401
		draw_grid square_x1_8, square_y1_8, 8, 401
		call read
		push 50
		push square_y1_8
		push square_x1_8
		call draw_cages
		add esp, 12
		
		jmp end_draw
	area_9:
		draw_square square_x1_9, square_y1_9, square_x2_9, square_y2_9, 451
		draw_grid square_x1_9, square_y1_9, 9, 451
		call read
		push 50
		push square_y1_9
		push square_x1_9
		call draw_cages
		add esp, 12
		
		jmp end_draw
	click_event:
		mov eax, n
		cmp eax, 3
		je is_3
		cmp eax, 4
		je is_4
		cmp eax, 5
		je is_5
		cmp eax, 6
		je is_6
		cmp eax, 7
		je is_7
		cmp eax, 8
		je is_8
		jmp is_9
		
		is_3:
			push 100
			push square_y2_3
			push square_x2_3
			push square_y1_3
			push square_x1_3
			push [ebp + arg3]
			push [ebp + arg2]
			call input_click
			add esp, 28
		jmp end_draw
		is_4:
			
		jmp end_draw
		is_5:
			
		jmp end_draw
		is_6:
			
		jmp end_draw
		is_7:
			
		jmp end_draw
		is_8:
			
		jmp end_draw
		is_9:
		
		jmp end_draw
	nothing_event:
		mov ebx, n
		mov eax, n
		mul ebx
		mov ecx, eax
		mov esi, offset kenken
		mov edi, values
		while_verif:
			mov eax, dword ptr[edi]
			mov ebx, dword ptr[esi]
			cmp eax, ebx
			jne nu_e_solutie
			add esi, 4
			add edi, 4
		loop while_verif
			make_text_macro 'C', window, 280, 60
			make_text_macro 'O', window, 290, 60
			make_text_macro 'N', window, 300, 60
			make_text_macro 'G', window, 310, 60
			make_text_macro 'R', window, 320, 60
			make_text_macro 'A', window, 330, 60
			make_text_macro 'T', window, 340, 60
			make_text_macro 'S', window, 350, 60
		nu_e_solutie:
	end_draw:
		popa
		mov esp, ebp
		pop ebp
		ret
draw endp


start:
	mov eax, window_width
	mov ebx, window_height
	mul ebx ; EAX = EAX * EBX
	shl eax, 2 ; EAX = EAX * 4
	push eax
	call malloc
	add esp, 4
	mov window, eax
	
	push offset draw
	push window
	push window_height
	push window_width
	push offset game_title
	call BeginDrawing
	add esp, 20
	
	push 0
	call exit
end start