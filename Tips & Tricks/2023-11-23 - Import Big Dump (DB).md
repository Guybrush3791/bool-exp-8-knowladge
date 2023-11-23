# Dump file too big
Se il dump del db che vuoi importare risulta essere troppo grande seguire la seguente procedura:
## Terminale
Lanciare questo comando per trovare il percorso esatto del file `php.ini` utilizzato
```sh
php --ini
```

Che darà come risultato qualcosa del tipo
```sh
Configuration File (php.ini) Path: /etc/php
Loaded Configuration File:         /etc/php/php.ini
Scan for additional .ini files in: /etc/php/conf.d
Additional .ini files parsed:      /etc/php/conf.d/phpmariadb.ini
```

## Modificare file `php.ini`
Dopo averlo localizzato, aprilo con un editor di testo e ricerca le seguenti keyword:
- `upload_max_filesize`
- `post_max_size`

Impostare valori congruenti con il file che si vuole caricare (es: 10~20M)
```sh
; ...
upload_max_filesize = 20M
; ...
post_max_size = 20M
; ...
```

## Riavviare il server
Dopo aver modificato il file `php.ini` e' necessario rilanciare il server (MAMP) in modo da rendere le modifiche effettive. Sara' ora possibile caricare il dump desiderato all'interno del db tramite **PHPMyAdmin**.