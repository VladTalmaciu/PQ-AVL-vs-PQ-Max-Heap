Talmaciu Vlad


					README
			Structuri de Date - Cozi de Prioritate


	1. Introducere
	Au fost implementate doua cozi de prioritate: una bazata pe un max-heap, iar
cealalta, pe un arbore AVL.
	Au fost apoi generate teste pentru compararea performantelor celor doua structuri.


	2. Implementare
	MaxHeapPQ este bazata pe implementarea standard a unui max-heap, la care nu au fost
aduse modificari.
	AVLTreePQ a fost implementata peste o structura de arbore AVL unde nodurile au
un contor (pentru a retine numarul de elemente cu aceeasi prioritate).
	deleteMax si getMax returneaza -1 in cazul in care coada este goala.


	3. Testare
	Au fost generate teste modificand plaja de valori pentru prioritati, numarul de 
operatii si frecventa stergerilor.
	Astfel, s-au obtinut cate 10 teste cu:
		VALORI			OPERATII		STERGERI
		 0-24			  1000			  rare
	        0-99999			  1000			  rare
		 0-99 			1000000			  rare
	       0-999999			1000000			  rare
		 0-24			  1000			  dese
		0-99999		          1000			  dese
		 0-99			1000000			  dese
	       0-999999			1000000			  dese
	Pentru testarea corectitudinii, au fost generate fisiere de referinta folosind un
PriorityQueue in paralel cu generarea operatiilor pentru fiecare test.
	Cate o coada din fiecare a fost supusa testelor, iar timpii obtinuti pentru
cele doua implementari au fost comparati pentru fiecare test si fiecare categorie de teste.
	