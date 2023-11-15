## Repo
`java-exceptions-books`

## Todo
Vogliamo gestire il **catalogo di libri** di una biblioteca.

Un **libro** è composto da :
- `titolo`
- `numero pagine`
- `autore`
- `editore`

Scrivere un programma che inserisce `n` libri in un `array`.

Chiedere i dati di un libro (titolo, numero pagine, autore, editore), istanziare un nuovo oggetto della classe `Book` e lo inserirlo nell’`array`.
Farlo per il numero di elementi previsti nell’`array` (`n`).

Quando vengono inseriti i dati, verificare che siano corretti (*es.* non accettare titolo o autore o editore vuoto, numero pagine ≤ 0). Se ci sono errori, lanciare un’eccezione e gestirla mostrando in console il tipo di errore.

Implementare i `getter` e `setter` di tutti gli attributi del libro gestendo anche in questo caso eventuali errori di dati non coerenti (che generano quindi **eccezione**).

Al termine dell’inserimento scrivere **tutti i dati dei libri in un file** e in seguito **rileggerli dal file** e mostrarli in console.