## Repo
`db-nations`

## Database
[[Databases/2023-11-24 - db-nations|DB Nation]]

## Todo
### Milestone 1
Creare un nuovo database in *PHPMyAdmin* e importare lo schema in allegato.
Scrivere una query *SQL* che restituisca la lista di tutte le nazioni mostrando `nome`, `id`, `nome della regione` e `nome del continente`, ordinata per nome della nazione.

### Milestone 2
Creare un progetto *Maven*, configurato in modo da potersi connettere ad un database MySQL (importare dipendenza `JDBC`). Nel progetto creare un programma che esegua la query della [[#Milestone 1]] e stampi a video il risultato.

### Milestone 3
Modificare il programma precedente per fare in modo che un utente possa inserire una ricerca e filtrare i risultati:
- chiedere all'utente di inserire una stringa di ricerca da terminale
- usare quella stringa come parametro aggiuntivo della query in modo che i risultati vengano filtrati come con una `contains` (ad esempio se l'utente cerca per “*ita*”, il risultato della query conterrà sia **Italy** che **Mauritania**)

### Bonus
Dopo aver stampato a video l’elenco delle country, chiedere all’utente di inserire l'`id` di una delle country.
Sulla base di quell'`id` eseguire ulteriori ricerche su database, che restituiscano:
- tutte le lingue parlate in quella country
- le statistiche più recenti per quella country

Stampare a video i risultati, nel seguente formato:
![[Pasted image 20231124125357.png]]